package me.cosban.suckchat.managers;

import java.io.File;
import me.cosban.suckchat.SuckChat;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigManager
{
	public static SuckChat plugin;
	
	private ConfigManager(SuckChat instance){
		plugin = instance;
	}

	public static ConfigManager getManager(SuckChat plugin){
		ConfigManager fm = new ConfigManager(plugin);
		return fm;
	}

	public static void save() {
		try {
			plugin.saveConfig();
		} catch (Exception e) {
			plugin.getAPI().getLog().info("[suckchat] Unable to save config.yml");
		}
	}
}