package com.wdcftgg.eventtweaker.common.api.Methods;

import baubles.api.BaublesApi;
import baubles.api.cap.IBaublesItemHandler;
import com.wdcftgg.eventtweaker.common.EvtConfig;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.player.IPlayer;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenRegister
@ModOnly("baubles")
@ZenExpansion("crafttweaker.player.IPlayer")
@ZenClass("mods.eventtweaker.baubles.IPlayer")
@SuppressWarnings("unused")
public abstract class BaublePlayer {
    @ZenMethod
    public static void setBaubleInSlot(IPlayer iPlayer, IItemStack itemStack, int slot) {
        if (EvtConfig.isBaubleFork) {
            IBaublesItemHandler baubles = BaublesApi.getBaublesHandler(CraftTweakerMC.getPlayer(iPlayer));
            baubles.setStackInSlot(slot, CraftTweakerMC.getItemStack(itemStack));
        }
    }
}
