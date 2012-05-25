package me.cosban.suckchat.managers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.cosban.suckchat.SuckChat;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandManager {
	private Map<String, CommandExecutor> commands = new HashMap<String, CommandExecutor>();
	private CommandManager(SuckChat instance) {

	}

	public static CommandManager getManager(SuckChat plugin) {
		CommandManager cm = new CommandManager(plugin);
		// cm.registerCommand("mute", command);
		// cm.registerCommand("unmute", command);		
		// cm.registerCommand("pm", command);
		// cm.registerCommand("ch", command);
		return cm;
	}

	public void registerCommand(String name, CommandExecutor command) {
		this.commands.put(name, command);
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		List<String> tempList = Arrays.asList(args);
		while (tempList.contains("")) {
			tempList.remove("");
		}
		args = tempList.toArray(new String[0]);
		CommandExecutor commandEx = this.commands.get(label);
		return commandEx.onCommand(sender, command, label, args);
	}

	public static boolean noPerm(Player p) {
		p.sendMessage(ChatColor.RED + "Insufficient permissions to perform command");
		return false;
	}
}