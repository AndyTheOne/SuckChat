package me.cosban.suckchat;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginManager;

import me.cosban.suckchat.managers.ChannelManager;
import me.cosban.suckchat.managers.CommandManager;

public class suckAPI {
	
	private SuckChat plugin;
	private suckAPI api;
	private PluginManager pm;
	private Logger log;
	private SuckListener listener;
	private Messenger messenger;
	private ChannelManager channel;
	private CommandManager command;
	
	public suckAPI(SuckChat suckChat) {
		suckChat = plugin;
		api = this;
		log = Logger.getLogger("Minecraft");
		messenger = Messenger.getMessenger(getPlugin());
		//managers
		pm = getPlugin().getServer().getPluginManager();
		channel = ChannelManager.getManager(getPlugin());
		command = CommandManager.getManager(getPlugin());
	}
	
	public SuckChat getPlugin(){
		return plugin;
	}
	
	public suckAPI getAPI(){
		return api;
	}
	
	public Logger getLog(){
		return log;
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
	
	public ChannelManager getChannelManager(){
		return channel;
	}
	
	public CommandManager getCommandManager(){
		return command;
	}

}
