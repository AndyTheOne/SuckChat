package me.cosban.suckchat;

import java.util.logging.Logger;

import me.cosban.suckchat.managers.ChannelManager;
import me.cosban.suckchat.managers.ConfigManager;
import me.cosban.suckchat.parsers.Censor;
import me.cosban.suckchat.parsers.Parser;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class SuckAPI {
	private SuckChat plugin;
	private SuckAPI api;
	private PluginManager pm;
	private Logger logger;
	private SuckListener listener;
	private ConfigManager config;
	private Messenger messenger;
	private ChannelManager channel;
	private Parser parser;
	private Censor censor;
	
	public SuckAPI(SuckChat instance) {
		plugin = instance;
		api = this;
		logger = Bukkit.getLogger();
		messenger = Messenger.getMessenger(getPlugin());
		pm = getPlugin().getServer().getPluginManager();
		censor = Censor.getCensor(getPlugin());
		config = ConfigManager.getManager(getPlugin());
		channel = ChannelManager.getManager(getPlugin());
		parser = new Parser(instance);
	}
	
	public SuckChat getPlugin() {
		return plugin;
	}
	
	public SuckAPI getAPI() {
		return api;
	}
	
	public Logger getLogger() {
		return logger;
	}
	
	public Messenger getMessenger() {
		return messenger;
	}
	
	public SuckListener getListener() {
		return listener;
	}
	
	public PluginManager getPluginManager() {
		return pm;
	}
	
	public ConfigManager getConfigManager() {
		return config;
	}
	
	public ChannelManager getChannelManager() {
		return channel;
	}

	public Censor getCensor() {
		return censor;
	}
	
	public Parser getParser() {
		return parser;
	}
}