package com.wdcftgg.eventtweaker.common.mcevent.mods;

import com.wdcftgg.eventtweaker.common.mcevent.BaseEvent;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : wdcftgg
 * @create 2024/1/20 10:45
 */
public class ManaChangeEvent extends BaseEvent {

    private IBlockState blockState;
    private World world;
    private BlockPos pos;
    private int mana;

    public ManaChangeEvent(IBlockState block, World world, BlockPos blockPos, int mana){
        this.blockState = block;
        this.world = world;
        this.pos = blockPos;
        this.mana = mana;
    }

    public IBlockState getBlockState(){
        return blockState;
    }

    public Block getBlock(){
        return blockState.getBlock();
    }

    public BlockPos getBlockPos(){
        return pos;
    }

    public World getWorld(){
        return world;
    }

    public int getMana(){
        return mana;
    }

}
