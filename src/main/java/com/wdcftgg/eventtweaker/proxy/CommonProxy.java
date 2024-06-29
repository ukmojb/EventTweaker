package com.wdcftgg.eventtweaker.proxy;

import com.wdcftgg.eventtweaker.CTEventManager;
import com.wdcftgg.eventtweaker.CTEventManagerBot;
import com.wdcftgg.eventtweaker.CTEventManagerRP;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;

import java.util.ArrayList;
import java.util.List;

public class CommonProxy {

	public static List<Integer> spacelist = new ArrayList<>();

	public void registerItemRenderer(Item item, int meta, String id) {
		//Ignored
	}

	public void onPreInit() {
	}

	public void onPostInit() {
	}

	public void onInit(){
		MinecraftForge.EVENT_BUS.register(CTEventManager.HandlerS.class);
		if (Loader.isModLoaded("botania")) {
			MinecraftForge.EVENT_BUS.register(CTEventManagerBot.Handler.class);
		}
		if (Loader.isModLoaded("randomportals")) {
			MinecraftForge.EVENT_BUS.register(CTEventManagerRP.Handler.class);
		}
	}

}
