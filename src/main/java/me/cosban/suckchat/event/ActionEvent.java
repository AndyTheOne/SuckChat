package me.cosban.suckchat.event;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

public class ActionEvent extends SuckEvent {
    private static final HandlerList handlers = new HandlerList();
    
    /**
     * Event for action messages.
     * 
     * @param player The player sending the message.
     * @param message The message itself.
     * @param channel The channel this occurred in.
     */
	public ActionEvent(Player player, String message, String channel) {
		super(player, message, channel);
	}

	@Override
	public HandlerList getHandlers() {
		return null;
	}
	
    public static HandlerList getHandlerList() {
        return handlers;
    }
}