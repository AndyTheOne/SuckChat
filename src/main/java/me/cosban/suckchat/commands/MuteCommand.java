package me.cosban.suckchat.commands;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MuteCommand implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (command.getName().equalsIgnoreCase("mute")) {
			String ip = args[0].substring(0, args[0].indexOf("/")-1);
			byte[] cidr = args[0].substring(args[0].indexOf("/")+1).getBytes();
			try {
				InetAddress address = InetAddress.getByAddress(ip, cidr);
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}	
		}

		else if (command.getName().equalsIgnoreCase("unmute")) {
			
		}
		return true;
	}
}