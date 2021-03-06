package me.cosban.suckchat.event;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

public class ChatEvent extends SuckEvent {
    private static final HandlerList handlers = new HandlerList();

    /**
     * Event for handling chat messages.
     * 
     * @param player The player sending the message.
     * @param message The message itself.
     * @param channel The channel the message was sent to.
     */
	public ChatEvent(Player player, String message, String channel) {
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