package me.cosban.suckchat.managers;

import java.awt.List;
import java.util.ArrayList;

import me.cosban.suckchat.SuckChat;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigManager
{
	public static SuckChat plugin;
	private FileConfiguration config;
	private ArrayList<String> bad = new ArrayList<String>();
	private ArrayList<String> repl = new ArrayList<String>();

	private ConfigManager(SuckChat instance){
		bad.add("cosban:0.1");
		repl.add("fuck");
		plugin = instance;
		config = plugin.getConfig();
		loadDefaults();
		save();
	}

	public static ConfigManager getManager(SuckChat plugin){
		ConfigManager fm = new ConfigManager(plugin);
		return fm;
	}

	public boolean getBool(String s) {
		return config.getBoolean(s);
	}

	public String getString(String s) {
		return config.getString(s);
	}

	public List getList(String s) {
		return (List)config.getList(s);
	}

	public int getInt(String s) {
		return config.getInt(s);
	}

	public Double getDouble(String s) {
		return config.getDouble(s);
	}

	public void save() {
		try {
			plugin.saveConfig();
		} catch (Exception e) {
			SuckChat.getAPI().getLogger().info("[SuckChat] Unable to save config.yml");
			e.printStackTrace();
		}
	}

	private void loadDefaults() {
		config.options().copyDefaults(true);
		config.options().header("This is the configuration file for SuckChat, it is used to format the chat layout etc.\nConfiguration for the plugin can be found at http://phantomcraft.net/wiki/SuckChat");
		config.addDefault("chat.config.sendConsole", Boolean.valueOf(true));
		config.addDefault("chat.censor.enabled", Boolean.valueOf(false));
		config.addDefault("chat.censor.list", bad);
		config.addDefault("chat.censor.replacements", repl);
		config.addDefault("chat.format", "%prefix%%clancolor%[%group%]&f%nick%: %message%");
	}
	
	
}