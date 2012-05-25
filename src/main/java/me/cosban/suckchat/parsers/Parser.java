package me.cosban.suckchat.parsers;

import me.cosban.suckchat.SuckChat;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import ru.tehkode.permissions.PermissionGroup;

public class Parser {
	@SuppressWarnings("unused")
	private SuckChat plugin;

	public Parser(SuckChat instance) {
		this.plugin = instance;
	}

	public static Parser getParser(SuckChat instance) {
		Parser parser = new Parser(instance);
		return parser;
	}

	public String getInfo(Player m){
		String info = SuckChat.getAPI().getConfigManager().getString("chat.format");
		info = parseSender(info,m);
		info = parseNick(info,m);
		info = parsePrefix(info,m);
		info = parseSuffix(info,m);
		info = parseGroup(info,m);	
		return info;
	}

	public String getMsg(Player e, String info, String msg) {
		return info.replaceAll("%messsage%",msg);
	}

	public String parseFor(Player e, String msg) {
		return msg.replaceAll("%p", e.getName());
	}

	public String recipient(Player m, String msg) {
		return ChatColor.DARK_GRAY + "(From " + m.getName() + ") " + ChatColor.WHITE + msg;
	}

	public String sender(Player e, String msg) {
		return ChatColor.DARK_GRAY + "(To " + e.getName() + ") " + ChatColor.WHITE + msg;
	}

	public String eavesDropper(Player m,Player e,String msg) {
		return ChatColor.DARK_GRAY + "(From " + m.getName() + " to " + e.getName() + ") " + ChatColor.WHITE + msg;
	}

	public String parseSender(String s, Player m) {
		return s.replaceAll("%name%", m.getName());
	}

	public String parseNick(String s, Player m) {
		return s.replaceAll("%nick%", m.getDisplayName());
	}

	//	public String parseClan(String s, Player m) {
	//		try {
	//			return s.replaceAll("%clan%", escape(ClanManager.getPlayerClan(this.sender).getName())); } catch (Exception e) {
	//			}
	//		return s;
	//	}

	//	public String parseCColor(String s)
	//	{
	//		try {
	//			return s.replaceAll("%clancolor%", escape(ClanManager.getPlayerClan(this.sender).getColor())); } catch (Exception e) {
	//			}
	//		return s;
	//	}

	public String parsePrefix(String s, Player m) {
		String prefix = "";
		if (SuckChat.usePermEx) {
			PermissionGroup[] groups = SuckChat.getAPI().getPlugin().permEx.getUser(m).getGroups();
			for (PermissionGroup group : groups) {
				try {
					if (group.getOwnPrefix() != null)
						prefix = prefix + group.getOwnPrefix();
				}
				catch (NullPointerException e) {
					e.printStackTrace();
				}
			}
		}
		return s.replaceAll("%prefix%", prefix);
	}

	public String parseSuffix(String s, Player m) {
		String Suffix = "";
		if (SuckChat.usePermEx) {
			PermissionGroup[] groups = SuckChat.getAPI().getPlugin().permEx.getUser(m).getGroups();
			for (PermissionGroup group : groups) {
				try {
					if (group.getOwnSuffix() != null)
						Suffix = Suffix + group.getOwnSuffix();
				}
				catch (NullPointerException e) {
					e.printStackTrace();
				}
			}
		}
		return s.replaceAll("%suffix%", Suffix);
	}

	public String parseGroup(String s, Player m) {
		String groupNames = "";
		if (SuckChat.usePermEx) {
			String[] groups = SuckChat.getAPI().getPlugin().permEx.getUser(m).getGroupsNames();
			for (String group : groups) {
				if ((!SuckChat.getAPI().getPlugin().permEx.getGroup(group).has("chat.noshow")) || (SuckChat.getAPI().getPlugin().permEx.getGroup(group).has("*"))) {
					groupNames = groupNames + group + " ";
				}
			}
		}
		return s;
	}

	public boolean toShowName(String s, Player m) {
		@SuppressWarnings("unused")
		boolean show = true;
		if (SuckChat.usePermEx) {
			for (String t : SuckChat.getAPI().getPlugin().permEx.getGroup(s).getOwnPermissions(m.getWorld().getName())) {
				if (t.equals("chat.noshow")) show = false;
				if (t.equals("*")) return true;
			}
		}
		return false;
	}

	public String parseFor(Player p, Player pl, String m) {
		if (p.hasPermission("chat.variables.names")) return m.replaceAll("%p", pl.getName());
		return m;
	}

	public static String time() {
		long time = System.currentTimeMillis();
		time /= 1000L;
		long seconds = time % 60L;
		long minutes = time / 60L % 60L;
		long hours = time / 60L / 60L % 24L;
		SuckChat.getAPI().getLogger().info(String.valueOf(time));
		return hours + ":" + minutes + ":" + seconds;
	}
}