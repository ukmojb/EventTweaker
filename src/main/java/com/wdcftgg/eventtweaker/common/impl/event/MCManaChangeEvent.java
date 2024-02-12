package com.wdcftgg.eventtweaker.common.impl.event;

import com.wdcftgg.eventtweaker.common.api.event.IManaChangeEvent;
import com.wdcftgg.eventtweaker.common.mcevent.mods.ManaChangeEvent;
import crafttweaker.api.block.IBlock;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.world.IBlockPos;
import crafttweaker.api.world.IWorld;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : wdcftgg
 * @create 2024/1/20 11:15
 */
public class MCManaChangeEvent implements IManaChangeEvent {

    private final ManaChangeEvent event;

    public MCManaChangeEvent(ManaChangeEvent event) {
        this.event = event;
    }

    @Override
    public int getMana() {
        return event.getMana();
    }

    @Override
    public IWorld getWorld() {
        return CraftTweakerMC.getIWorld(event.getWorld());
    }

    @Override
    public crafttweaker.api.block.IBlockState getBlockState() {
        return CraftTweakerMC.getBlockState(event.getBlockState());
    }

    @Override
    public IBlock getBlock() {
        return CraftTweakerMC.getBlock(event.getBlock(), event.getBlock().getMetaFromState(event.getBlockState()));
    }

    @Override
    public IBlockPos getPosition() {
        return CraftTweakerMC.getIBlockPos(event.getBlockPos());
    }

    @Override
    public int getX() {
        return event.getBlockPos().getX();
    }

    @Override
    public int getY() {
        return event.getBlockPos().getY();
    }

    @Override
    public int getZ() {
        return event.getBlockPos().getZ();
    }

    @Override
    public boolean isCanceled() {
        return event.isCanceled();
    }

    @Override
    public void setCanceled(boolean canceled) {
        event.setCanceled(canceled);
    }
}
