package me.cosban.suckchat;

import me.cosban.suckchat.commands.MuteCommand;
import me.cosban.suckchat.commands.PrivateMessageCommand;

import org.bukkit.plugin.java.JavaPlugin;

import ru.tehkode.permissions.PermissionManager;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class SuckChat extends JavaPlugin {
	private static SuckAPI api;
	public static boolean usePermEx;
	public PermissionManager permEx;

	public void onEnable() {
		api = new SuckAPI(this);
		loadDependencies();
		getServer().getPluginManager().registerEvents(new SuckListener(), this);
		
		getCommand("mute").setExecutor(new MuteCommand());
		getCommand("unmute").setExecutor(new MuteCommand());
		getCommand("msg").setExecutor(new MuteCommand());
		getCommand("pm").setExecutor(new PrivateMessageCommand());
		getCommand("reply").setExecutor(new PrivateMessageCommand());
	}

	public void onDisable() {

	}

	public static SuckAPI getAPI() {
		return api;
	}

	private void loadDependencies() {
		if (getServer().getPluginManager().isPluginEnabled("PermissionsEx")) {
			permEx = PermissionsEx.getPermissionManager();
			usePermEx = true;
			getAPI().getLogger().info("[SuckChat] Attached to PermissionsEx!");
		} else {
			usePermEx = false;
		}
	}
}