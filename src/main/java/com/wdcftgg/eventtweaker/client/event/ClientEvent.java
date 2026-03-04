package com.wdcftgg.eventtweaker.client.event;

import com.wdcftgg.eventtweaker.common.network.MessageServerChatEvent;
import com.wdcftgg.eventtweaker.common.network.PacketHandler;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ClientEvent {

    @SubscribeEvent
    public static void onClientChatEvent(ClientChatEvent event) {
        PacketHandler.INSTANCE.sendToServer(new MessageServerChatEvent(event.getOriginalMessage(), event.getMessage()));
    }
}
