package me.cosban.suckchat;

import java.util.ArrayList;
import java.util.Collection;
import org.bukkit.entity.Player;

public class Channel
{
	public ArrayList<Player> players = new ArrayList<Player>();
	public ArrayList<Player> listeners = new ArrayList<Player>();
	private String name;

	public Channel(String name) {
		this.name = name;
	}

	public String getName(){
		return name;
	}

	// returns true if successful
	public boolean addPlayer(Player p) {
		return this.players.add(p);
	}

	public boolean removePlayer(Player p) {
		return this.players.remove(p);
	}

	public Collection<Player> getPlayers() {
		return this.players;
	}

	public boolean addListener(Player p) {
		return this.listeners.add(p);
	}

	public boolean removeListener(Player p) {
		return this.listeners.remove(p);
	}

	public Collection<Player> getListeners() {
		return this.listeners;
	}

	public boolean hasPlayer(Player p) {
		return this.players.contains(p);
	}

	public boolean isListening(Player p){
		return this.listeners.contains(p);
	}
}