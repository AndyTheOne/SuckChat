package me.cosban.suckchat.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ActionCommand implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (command.getName().equalsIgnoreCase("me")) {
			
		}
		
		else if (command.getName().equalsIgnoreCase("action")) {
			
		}
		return true;
	}
}