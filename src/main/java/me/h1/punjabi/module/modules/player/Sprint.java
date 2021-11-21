package me.h1.punjabi.module.modules.player;

import org.lwjgl.input.Keyboard;

import me.h1.punjabi.module.Category;
import me.h1.punjabi.module.Module;

public class Sprint extends Module {
	
	public Sprint() {
		super("Sprint", "Automatically runs", Category.PLAYER);
		this.setKey(Keyboard.KEY_M);
	}
	
}
