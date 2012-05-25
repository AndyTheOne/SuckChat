package me.cosban.suckchat.managers;

import java.util.ArrayList;
import java.util.Collection;

import me.cosban.suckchat.Channel;
import me.cosban.suckchat.SuckChat;
import org.bukkit.entity.Player;

public class ChannelManager
{
	private static SuckChat plugin;
	private ArrayList<Channel> channels = new ArrayList<Channel>();
	
	private ChannelManager(SuckChat instance){
		instance = plugin;
	}

	public static ChannelManager getManager(SuckChat instance){
		ChannelManager cm = new ChannelManager(instance);
		cm.addChannel("main");
		return cm;
	}

	public Channel getChannel(String n){
		for(Channel ch: getChannels()){
			if(n.equalsIgnoreCase(ch.getName())) return ch; 
		} return null;
	}

	public Channel addChannel(String n) {
		Channel ch = new Channel(n);
		channels.add(ch);
		return ch;
	}

	public void removeChannel(String n){
		channels.remove(getChannel(n));
	}

	public Collection<Channel> getChannels() {
		return channels;
	}

	public Collection<Channel> getPlayerChannels(Player p) {
		ArrayList<Channel> chans = new ArrayList<Channel>();
		for (Channel c : getChannels()) {
			if (c.hasPlayer(p)) chans.add(c);
		}
		return chans;
	}

	public Collection<Player> getListeners(Collection<Channel> ch){
		Collection<Player> listeners = new ArrayList<Player>();
		for(Channel c: ch){
			for(Player p: c.getListeners()) listeners.add(p);
		} return listeners;
	}

	public void loadPlayers() {
		for (Player p : plugin.getServer().getOnlinePlayers()) {
			if(p.hasPermission("chat.surewhynot")){
				getChannel("main").addPlayer(p);
			}
		}
	}
}