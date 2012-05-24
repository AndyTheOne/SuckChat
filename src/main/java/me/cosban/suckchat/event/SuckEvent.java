package me.cosban.suckchat.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;

public abstract class SuckEvent extends Event {
	private String message;
	private String channel;
	private Player player;
	
	public SuckEvent(Player player, String message, String channel) {
		this.message = message;
		this.channel = channel;
		this.player = player;
	}

    public String getMessage() {
    	return message;
    }
    
    public String getChannel() {
    	return channel;
    }
    
    public Player getPlayer() {
    	return player;
    }
}