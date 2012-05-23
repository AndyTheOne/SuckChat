package me.cosban.suckchat;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import ru.tehkode.permissions.PermissionManager;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class SuckChat extends JavaPlugin
{
	private static suckAPI api;
	public static boolean usePermEx;
	public PermissionManager permEx;

	public void onEnable()
	{
		api = new suckAPI(this);
		loadDependencies();
		getAPI().getLogger().info("Enabled");
	}

	public void onDisable() {
		getAPI().getLogger().info("Disabled");
	}
	public static suckAPI getAPI(){
		return api;
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		return getAPI().getCommandManager().onCommand(sender, command, label, args);
	}

	private void loadDependencies() {
		if (getServer().getPluginManager().isPluginEnabled("PermissionsEx")) {
			permEx = PermissionsEx.getPermissionManager();
			usePermEx = true;
			getAPI().getLogger().info("[SuckChat] Attached to PermissionsEx");
		} else {
			usePermEx = false;
		}
	}
}