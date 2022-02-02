package me.jerryz.coreplugin.api;

import java.util.ArrayList;

import me.jerryz.coreplugin.regions.Region;

public class CoreAPI {

	private static ArrayList<Region> regions = new ArrayList<Region>();
	
	
	public static Region createRegion(String name) {
		Region r = new Region(name);
		regions.add(r);
		return r;
	}
	
	public static Region getRegion(String name) {
		for(Region r : regions) {
			if(r.getRegion().equalsIgnoreCase(name)) return r;
		}
		return null;
	}
	
	public static ArrayList<Region> getAllRegions(){
		return regions;
	}

	public static void deleteRegion(String name) {
		regions.remove(getRegion(name));
	}
	
}
