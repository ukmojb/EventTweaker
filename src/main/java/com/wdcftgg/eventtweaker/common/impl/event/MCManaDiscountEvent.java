package com.wdcftgg.eventtweaker.common.impl.event;

import com.wdcftgg.eventtweaker.common.api.event.IManaDiscountEvent;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.player.IPlayer;
import vazkii.botania.api.mana.ManaDiscountEvent;

public class MCManaDiscountEvent implements IManaDiscountEvent {

    private final ManaDiscountEvent event;

    public MCManaDiscountEvent(ManaDiscountEvent event) {
        this.event = event;
    }


    @Override
    public IPlayer getPlayer() {
        return CraftTweakerMC.getIPlayer(event.getEntityPlayer());
    }

    @Override
    public IItemStack getTool() {
        return CraftTweakerMC.getIItemStack(event.getTool());
    }

    @Override
    public void setDiscount(float var1) {
        event.setDiscount(var1);
    }

    @Override
    public float getDiscount() {
        return event.getDiscount();
    }
}
