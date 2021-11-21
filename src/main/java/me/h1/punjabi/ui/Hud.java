package me.h1.punjabi.ui;

import java.awt.Color;
import java.util.Collections;
import java.util.Comparator;

import me.h1.punjabi.Main;
import me.h1.punjabi.module.Module;
import me.h1.punjabi.util.Refrence;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Hud extends Gui {
	
	private Minecraft mc = Minecraft.getMinecraft();
	
	public static class ModuleComparator implements Comparator<Module> {
		@Override
		public int compare(Module arg0, Module arg1) {
			if(Minecraft.getMinecraft().fontRenderer.getStringWidth(arg0.getName()) > Minecraft.getMinecraft().fontRenderer.getStringWidth(arg1.getName())) {
				return -1;
			}
			if(Minecraft.getMinecraft().fontRenderer.getStringWidth(arg0.getName()) > Minecraft.getMinecraft().fontRenderer.getStringWidth(arg1.getName())) {
				return 1;
			}
			return 0;
		}
	}
	
	@SubscribeEvent
	public void renderOverlay(RenderGameOverlayEvent event) {
		Collections.sort(Main.moduleManager.modules, new ModuleComparator());
		ScaledResolution sr = new ScaledResolution(mc);
		FontRenderer fr = mc.fontRenderer;
		if(event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
			fr.drawStringWithShadow("punjabi", 2, 1, 0x2ACBAC);
			fr.drawStringWithShadow(Refrence.VERSION, 42, 1, 0xCBFAC0);
		}

		if(event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
			int y = 2;
			final int[] counter = {1};
			for(Module mod : Main.moduleManager.getModuleList()) {
				if(mod.getName().equalsIgnoreCase("TabGui") && mod.isToggled()) {
					fr.drawStringWithShadow(mod.getName(),  sr.getScaledWidth() -fr.getStringWidth(mod.getName()) - 2, y, rainbow(counter[0] * 300));
					y += fr.FONT_HEIGHT;
					counter[0]++;
				}
			}
		}
	}
		public static int rainbow(int delay) {
			double rainbowState = Math.ceil((System.currentTimeMillis() + delay) / 20.0);
			rainbowState %= 360;
			return Color.getHSBColor((float) (rainbowState / 360.0f), 0.7f, 1f).getRGB();
	}
}
