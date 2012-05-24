package me.cosban.suckchat;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import me.cosban.suckchat.managers.ChannelManager;

public class SuckListener implements Listener {
	private SuckChat plugin;

	public SuckListener(SuckChat instance) {
		this.plugin = instance;
	}
	
	@EventHandler(priority=EventPriority.NORMAL)
	public void onPlayerJoin(PlayerJoinEvent event) {
		if (event.getPlayer().hasPermission("chat.surewhynot")) {
			plugin.getAPI().getChannelManager().getChannel("main").addPlayer(event.getPlayer());
		}
	}

	@EventHandler(priority=EventPriority.NORMAL)
	public void onPlayerChat(PlayerChatEvent event) {
		plugin.getAPI().getMessenger().prepareMessage(event.getPlayer(), event.getMessage());
		event.setCancelled(true);
	}
	
	@EventHandler(priority=EventPriority.NORMAL)
	public void onPlayerQuit(PlayerQuitEvent event) {
		for (Channel ch : plugin.getAPI().getChannelManager().getPlayerChannels(event.getPlayer())) {
			ch.removePlayer(event.getPlayer());
		}
	}

	public void onPlayerFormedChat(Player m, Player e, String info, String msg) {
		
	}
}