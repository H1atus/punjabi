package me.h1.punjabi.module;

public enum Category {
	COMBAT("Combat"), EXPLOITS("Exploits"), RENDER("Render"), PLAYER("Player"), CLIENT("Client");
	
	public String name;
	public int moduleIndex;
	
	Category(String name) {
		this.name = name;
	}

}
