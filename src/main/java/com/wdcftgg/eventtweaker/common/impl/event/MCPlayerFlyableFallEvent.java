package com.wdcftgg.eventtweaker.common.impl.event;

import com.wdcftgg.eventtweaker.common.api.event.IPlayerFlyableFallEvent;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.player.IPlayer;
import net.minecraftforge.event.entity.player.PlayerFlyableFallEvent;

public class MCPlayerFlyableFallEvent implements IPlayerFlyableFallEvent {

    private final PlayerFlyableFallEvent event;

    public MCPlayerFlyableFallEvent(PlayerFlyableFallEvent event) {
        this.event = event;
    }

    @Override
    public IPlayer getPlayer() {
        return CraftTweakerMC.getIPlayer(event.getEntityPlayer());
    }

    @Override
    public float getDistance() {
        return event.getDistance();
    }

    @Override
    public void setDistance(float discount) {
        event.setDistance(discount);
    }

    @Override
    public float getMultiplier() {
        return event.getMultiplier();
    }

    @Override
    public void setMultiplier(float multiplier) {
        event.setMultiplier(multiplier);
    }

    @Override
    public boolean isCanceled() {
        return event.isCanceled();
    }

    @Override
    public void setCanceled(boolean b) {
        event.setCanceled(b);
    }
}
