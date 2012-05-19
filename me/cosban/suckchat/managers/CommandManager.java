package me.cosban.suckchat.managers;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.cosban.suckchat.SuckChat;

public class CommandManager {
	private static SuckChat plugin;
	
	private CommandManager(SuckChat instance){
		plugin = instance;
	}
	
	public static CommandManager getManager(SuckChat plugin) {
		CommandManager cm = new CommandManager(plugin);
		return cm;
	}
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
				
		return noPerm((Player)sender);
	}
	
	public static boolean noPerm(Player p) {
		p.sendMessage(ChatColor.RED + "Insufficient permissions to perform command");
		return false;
	}
}
