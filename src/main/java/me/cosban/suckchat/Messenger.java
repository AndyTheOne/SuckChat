package me.cosban.suckchat;

import org.bukkit.entity.Player;

public class Messenger {
	private SuckChat plugin;

	private Messenger(SuckChat instance) {
		this.plugin = instance;
	}

	public static Messenger getMessenger(SuckChat instance) {
		Messenger m = new Messenger(instance);
		return m;
	}

	// Triggers a formed chat event due to already being parsed.
	public void sendPlayer(Player m, Player e, String info, String msg) {
		e.sendMessage(prepareMessage(e, info, msg));
		SuckChat.getAPI().getListener().onPlayerFormedChat(m, e, info, msg);
	}

	public void sendChannel(Player m, Channel ch, String info, String msg) {
		for (Player p: ch.getListeners()) {
			sendPlayer(m,p,info,msg);
		}
	}

	public void sendMessage(Player m, String info, String msg) {
		for (Player e : plugin.getServer().getOnlinePlayers()) {
			sendPlayer(m, e, info, msg);
		}
	}
	
	// initial parsing for the mouth
	public String prepareInfo(Player player) {
		return SuckChat.getAPI().getParser().getInfo(player);
	}
	
	public String prepareMessage(Player player, String info, String message) {
		return SuckChat.getAPI().getParser().getMsg(player, info, message);
	}
}
