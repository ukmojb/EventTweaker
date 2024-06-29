package com.wdcftgg.eventtweaker.client.impl.event;

import com.wdcftgg.eventtweaker.client.api.event.IRenderPlayerPostEvent;
import com.wdcftgg.eventtweaker.client.api.event.IRenderPlayerPreEvent;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.player.IPlayer;
import net.minecraftforge.client.event.RenderPlayerEvent;

public class MCRenderPlayerPostEvent implements IRenderPlayerPostEvent {

    private final RenderPlayerEvent.Post event;


    public MCRenderPlayerPostEvent(RenderPlayerEvent.Post event) {
        this.event = event;
    }


    @Override
    public float getPartialRenderTick() {
        return event.getPartialRenderTick();
    }

    @Override
    public double getX() {
        return event.getX();
    }

    @Override
    public double getY() {
        return event.getY();
    }

    @Override
    public double getZ() {
        return event.getZ();
    }

    @Override
    public IPlayer getPlayer() {
        return CraftTweakerMC.getIPlayer(event.getEntityPlayer());
    }
}

