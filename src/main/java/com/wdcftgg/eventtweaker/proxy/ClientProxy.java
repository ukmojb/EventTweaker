package com.wdcftgg.eventtweaker.proxy;


import com.wdcftgg.eventtweaker.client.event.ClientEvent;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy {

	public ClientProxy() {
	}

	public void onInit(){
		super.onInit();
		MinecraftForge.EVENT_BUS.register(ClientEvent.class);
	}



	public void onPreInit() {
		super.onPreInit();
	}

	public void onPostInit() {
		super.onPostInit();
	}

}
