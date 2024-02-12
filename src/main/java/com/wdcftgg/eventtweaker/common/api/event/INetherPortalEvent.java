package com.wdcftgg.eventtweaker.common.api.event;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.event.IBlockEvent;
import crafttweaker.api.event.IEventCancelable;
import crafttweaker.api.event.IWorldEvent;
import crafttweaker.api.world.IWorld;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : wdcftgg
 * @create 2024/1/27 22:58
 */
@ZenRegister
@ZenClass("mods.eventtweaker.event.NetherPortalEvent")
@ModOnly("randomportals")
public interface INetherPortalEvent extends IEventCancelable, IWorldEvent {

    @ZenMethod
    IWorld getWorld();

    @ZenMethod
    boolean isValid();

    @ZenMethod
    int getWidth();

    @ZenMethod
    int getHeight();

    @ZenMethod
    boolean isUserCreated();

    @ZenMethod
    boolean isActivatedByFire();
}
