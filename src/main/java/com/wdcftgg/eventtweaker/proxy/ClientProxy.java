package com.wdcftgg.eventtweaker.proxy;


import com.wdcftgg.eventtweaker.CTEventManager;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy {

	public ClientProxy() {
	}

	public void onInit(){
		MinecraftForge.EVENT_BUS.register(CTEventManager.HandlerC.class);
	}



	public void onPreInit() {
		super.onPreInit();
	}

	public void onPostInit() {
		super.onPostInit();
	}

}
