package me.cosban.suckchat;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import ru.tehkode.permissions.PermissionManager;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class SuckChat extends JavaPlugin
{
	private suckAPI api;
	public static boolean usePermEx;

	public void onEnable()
	{
		api = new suckAPI(this);
		loadDependencies();
		getAPI().getLog().info("Enabled");
	}

	public void onDisable() {
		getAPI().getLog().info("Disabled");
	}
	
	public suckAPI getAPI(){
		return api;
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		return getAPI().getCommandManager().onCommand(sender, command, label, args);
	}

	private void loadDependencies() {
		if (getServer().getPluginManager().isPluginEnabled("PermissionsEx")) {
			PermissionManager permEx = PermissionsEx.getPermissionManager();
			usePermEx = true;
			getAPI().getLog().info("Attached to PermissionsEx");
		} else {
			usePermEx = false;
		}
	}
}