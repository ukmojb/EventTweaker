package com.wdcftgg.eventtweaker.common.api.event;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.block.IBlock;
import crafttweaker.api.block.IBlockState;
import crafttweaker.api.event.BlockBreakEvent;
import crafttweaker.api.event.IBlockEvent;
import crafttweaker.api.event.IEventCancelable;
import crafttweaker.api.world.IBlockPos;
import crafttweaker.api.world.IWorld;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenMethod;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : wdcftgg
 * @create 2024/1/20 11:17
 */
@ZenRegister
@ZenClass("mods.eventtweaker.event.ManaChangeEvent")
@ModOnly("botania")
public interface IManaChangeEvent extends IEventCancelable, IBlockEvent {

    @ZenMethod
    int getMana();

    @ZenMethod
    IWorld getWorld();

    @ZenMethod
    IBlockPos getPosition();

    @ZenMethod
    IBlockState getBlockState();

    @ZenMethod
    IBlock getBlock();
}