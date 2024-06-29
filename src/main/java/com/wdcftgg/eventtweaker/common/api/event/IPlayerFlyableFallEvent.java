package com.wdcftgg.eventtweaker.common.api.event;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.event.IEventCancelable;
import crafttweaker.api.event.IPlayerEvent;
import crafttweaker.api.player.IPlayer;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenRegister
@ZenClass("mods.eventtweaker.event.PlayerFlyableFallEvent")
public interface IPlayerFlyableFallEvent extends IPlayerEvent, IEventCancelable {

    @ZenMethod
    IPlayer getPlayer();

    @ZenMethod
    float getDistance();

    @ZenMethod
    void setDistance(float discount);

    @ZenMethod
    float getMultiplier();

    @ZenMethod
    void setMultiplier(float multiplier);
}
