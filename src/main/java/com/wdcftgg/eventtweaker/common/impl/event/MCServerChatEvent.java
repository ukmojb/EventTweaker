package com.wdcftgg.eventtweaker.common.impl.event;

import com.wdcftgg.eventtweaker.client.api.event.IClientChatEvent;
import com.wdcftgg.eventtweaker.common.api.event.IServerChatEvent;
import com.wdcftgg.eventtweaker.common.mcevent.mc.ClientChatEvent;
import crafttweaker.CraftTweakerAPI;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.player.IPlayer;
import net.minecraftforge.event.ServerChatEvent;

public class MCServerChatEvent implements IServerChatEvent {

    private final ServerChatEvent event;


    public MCServerChatEvent(ServerChatEvent event) {
        this.event = event;
    }

    @Override
    public String getMessage() {
        return event.getMessage();
    }

    @Override
    public String getUsername() {
        return event.getUsername();
    }

    @Override
    public IPlayer getPlayer() {
        return CraftTweakerMC.getIPlayer(event.getPlayer());
    }

    @Override
    public boolean isCanceled() {
        return false;
    }

    @Override
    public void setCanceled(boolean b) {

    }
}
