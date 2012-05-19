package me.cosban.suckchat.parsers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import me.cosban.suckchat.SuckChat;


public class Censor {
	private SuckChat plugin;
	private HashMap<String,Double> bad = new HashMap<>();
	private ArrayList<String> repl = new ArrayList<>();

	private Censor(SuckChat instance){
		plugin = instance;
		bad.put("cosban", .02);
		repl.add("fuck");
	}
	
	public static Censor getCensor(SuckChat instance){
		Censor censor = new Censor(instance);
		return censor;
	}

	public String censor(String s){
		if(plugin.getAPI().getConfigManager().getBool("chat.censor.enabled")){
			String[] words = s.split("\\s");
			String done = "";
			for (int i = 0; i < words.length; i++) {
				if (bad.containsKey(words[i].toLowerCase())) {
					Random rand = new Random();
					String replacement = repl.get(rand.nextInt(repl.size()));
					if (rand.nextDouble() < bad.get(words[i])) words[i] = replacement;
				} 
				done = done + words[i] + " ";
			} return done;
		} return s;
	}

	public HashMap<String,Double> getBad(){
		return bad;
	}
	
	public ArrayList<String> getRepl(){
		return repl;
	}

	private String getLastColor(String s) {
		if (s.contains("&")) {
			if (s.endsWith("&")) return getLastColor(s.substring(0, s.lastIndexOf("&")));
			return s.lastIndexOf("&") < s.length() - 1 ? s.substring(s.lastIndexOf("&"), s.lastIndexOf("&") + 2) : "§f";
		} return "§f";
	}
}
