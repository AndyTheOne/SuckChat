package me.cosban.suckchat;

import org.bukkit.entity.Player;

public class Messenger {
	private static SuckChat plugin;
	
	private Messenger(SuckChat instance){
		plugin = instance;
	}
	
	public static Messenger getMessenger(SuckChat instance){
		Messenger m = new Messenger(instance);
		return m;
	}
	
	//Triggers a formed chat event due to already being parsed
	public void sendPlayer(Player m, Player e, String info, String msg){
		e.sendMessage(info + msg);
		plugin.getAPI().getListener().onPlayerFormedChat(m, e, info, msg);
	}
	
	public void sendChannel(Player m, String msg){
		
	}

	public void sendMessage(Player p, String message) {
		//send to channels
	}
}
