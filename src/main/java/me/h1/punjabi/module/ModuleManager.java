package me.h1.punjabi.module;


import java.util.ArrayList;
import java.util.List;

import me.h1.punjabi.Main;
import me.h1.punjabi.module.modules.player.Sprint;



public class ModuleManager {
	
	public ArrayList<Module> modules;
	
	public ModuleManager() {
		(modules = new ArrayList<Module>()).clear();
		//Player
		this.modules.add(new Sprint());
	}
	
	public Module getModule (String name) {
		for(Module m : this.modules) {
			if(m.getName().equalsIgnoreCase(name)) {
				return m;
			}
		}
		return null;
	}
	
	public ArrayList<Module> getModuleList() {
		return this.modules;
	}
	
	public static List<Module> getModulesbyCategory(Category c) {
		List<Module> modules = new ArrayList<Module>();
		
		for(Module m : Main.moduleManager.modules) {
			if(m.getCategory() == c)
				modules.add(m);
		}
		return modules;
	}
	
}
