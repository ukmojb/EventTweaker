package com.wdcftgg.eventtweaker.common.api.event;


import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.player.IPlayer;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenRegister
@ZenClass("mods.eventtweaker.event.ManaDiscountEvent")
@ModOnly("botania")
public interface IManaDiscountEvent {


    @ZenMethod
    IPlayer getPlayer();

    @ZenMethod
    IItemStack getTool();

    @ZenMethod
    void setDiscount(float discount);

    @ZenMethod
    float getDiscount();
}