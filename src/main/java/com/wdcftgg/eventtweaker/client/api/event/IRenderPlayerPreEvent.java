package com.wdcftgg.eventtweaker.client.api.event;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.event.IPlayerEvent;
import crafttweaker.api.player.IPlayer;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenRegister
@ZenClass("mods.eventtweaker.event.RenderPlayerEvent.Pre")
public interface IRenderPlayerPreEvent extends IPlayerEvent {

    @ZenMethod
    float getPartialRenderTick();

    @ZenMethod
    double getX();

    @ZenMethod
    double getY();

    @ZenMethod
    double getZ();

    @ZenMethod
    IPlayer getPlayer();
}
