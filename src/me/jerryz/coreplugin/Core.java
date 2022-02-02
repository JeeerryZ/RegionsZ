package me.jerryz.coreplugin;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.jerryz.coreplugin.api.Config;
import me.jerryz.coreplugin.commands.RegionCmd;

public class Core extends JavaPlugin {

	public HashMap<String, Integer> warn = new HashMap<String, Integer>();

	public static Core getInstance() {
		return (Core) Bukkit.getPluginManager().getPlugin("Core");
	}

	public void onEnable() {
		
		registerCommands();
		
	}

	
	private void registerCommands() {
		getCommand("region").setExecutor(new RegionCmd());
	}
	
	
	public void onDisable() {

		
	}

}
