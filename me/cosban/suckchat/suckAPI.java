package me.cosban.suckchat;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginManager;

import me.cosban.suckchat.managers.ChannelManager;
import me.cosban.suckchat.managers.CommandManager;
import me.cosban.suckchat.managers.ConfigManager;
import me.cosban.suckchat.parsers.Censor;
import me.cosban.suckchat.parsers.Parser;

public class suckAPI {
	
	private SuckChat plugin;
	private suckAPI api;
	private PluginManager pm;
	private Logger logger;
	private SuckListener listener;
	private ConfigManager config;
	private Messenger messenger;
	private ChannelManager channel;
	private CommandManager command;
	private Parser parser;
	private Censor censor;
	
	public suckAPI(SuckChat instance) {
		plugin = instance;
		api = this;
		logger = Logger.getLogger("Minecraft");
		messenger = Messenger.getMessenger(getPlugin());
		pm = getPlugin().getServer().getPluginManager();
		censor = Censor.getCensor(getPlugin());
		config = ConfigManager.getManager(getPlugin());
		channel = ChannelManager.getManager(getPlugin());
		command = CommandManager.getManager(getPlugin());
		parser = Parser.getParser(getPlugin());
	}
	
	public SuckChat getPlugin(){
		return plugin;
	}
	
	public suckAPI getAPI(){
		return api;
	}
	
	public Logger getLogger(){
		return logger;
	}
	
	public Messenger getMessenger(){
		return messenger;
	}
	
	public SuckListener getListener(){
		return listener;
	}
	
	public PluginManager getPluginManager(){
		return pm;
	}
	
	public ConfigManager getConfigManager(){
		return config;
	}
	
	public ChannelManager getChannelManager(){
		return channel;
	}
	
	public CommandManager getCommandManager(){
		return command;
	}

	public Censor getCensor(){
		return censor;
	}
	
	public Parser getParser(){
		return parser;
	}
}
