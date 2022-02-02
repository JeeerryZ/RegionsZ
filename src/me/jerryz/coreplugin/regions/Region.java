package me.jerryz.coreplugin.regions;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import me.jerryz.coreplugin.Core;

public class Region {
	
	private String region;
	private Location spawnLocation;
	private ArrayList<String> players;
	private ArrayList<Material> canBuild, canBreak, canInteract;
	private boolean canPvp;
	private Plugin plugin;
	
	
	public Region(String region) {
		this.region = region;
		this.spawnLocation = null;
		this.players = new ArrayList<String>();
		this.canBuild = new ArrayList<Material>();
		this.canBreak = new ArrayList<Material>();
		this.canInteract = new ArrayList<Material>();
		this.canPvp = false;
		this.plugin = Core.getInstance();
	}


	public String getRegion() {
		return region;
	}


	public void setRegion(String region) {
		this.region = region;
	}


	public Location getSpawnLocation() {
		return spawnLocation;
	}


	public void setSpawnLocation(Location spawnLocation) {
		this.spawnLocation = spawnLocation;
	}


	public ArrayList<String> getPlayers() {
		return players;
	}


	public void setPlayers(ArrayList<String> players) {
		this.players = players;
	}


	public ArrayList<Material> getCanBuild() {
		return canBuild;
	}


	public void setCanBuild(ArrayList<Material> canBuild) {
		this.canBuild = canBuild;
	}


	public ArrayList<Material> getCanBreak() {
		return canBreak;
	}


	public void setCanBreak(ArrayList<Material> canBreak) {
		this.canBreak = canBreak;
	}


	public ArrayList<Material> getCanInteract() {
		return canInteract;
	}


	public void setCanInteract(ArrayList<Material> canInteract) {
		this.canInteract = canInteract;
	}


	public boolean isCanPvp() {
		return canPvp;
	}


	public void setCanPvp(boolean canPvp) {
		this.canPvp = canPvp;
	}


	public Plugin getPlugin() {
		return plugin;
	}


	public void setPlugin(Plugin plugin) {
		this.plugin = plugin;
	}
	
	public void addPlayer(String name) {
		this.players.add(name);
	}
	
	public void removePlayer(String name) {
		this.players.remove(name);
	}
	
	public void addPlayer(Player p) {
		this.players.add(p.getName());
	}
	
	public void removePlayer(Player p) {
		this.players.remove(p.getName());
	}
	
	public void addCanBreak(Material m) {
		this.canBreak.add(m);
	}
	
	public void addCanBuild(Material m) {
		this.canBuild.add(m);
	}
	
	public void addCanInteract(Material m) {
		this.canInteract.add(m);
	}
	
}
