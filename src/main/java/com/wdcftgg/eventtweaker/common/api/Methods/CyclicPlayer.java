package com.wdcftgg.eventtweaker.common.api.methods;


import com.lothrazar.cyclicmagic.playerupgrade.storage.InventoryPlayerExtended;
import com.lothrazar.cyclicmagic.util.UtilPlayerInventoryFilestorage;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.player.IPlayer;
import net.minecraft.item.ItemStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.ArrayList;
import java.util.List;

@ZenRegister
@ModOnly("cyclicmagic")
@ZenExpansion("crafttweaker.player.IPlayer")
@ZenClass("mods.eventtweaker.cyclicmagic.IPlayer")
@SuppressWarnings("unused")
public abstract class CyclicPlayer {
    @ZenMethod
    public static IItemStack[] getCyclicInventory(IPlayer iPlayer) {
        List<ItemStack> list = new ArrayList<>();
        InventoryPlayerExtended playerExtended = UtilPlayerInventoryFilestorage.getPlayerInventory(CraftTweakerMC.getPlayer(iPlayer));

        for (int i = 0; i < 36; i++) {
            ItemStack itemStack = playerExtended.getStackInSlot(i);
            if (itemStack != null) list.add(itemStack);
        }

        return CraftTweakerMC.getIItemStacks(list);
    }

    @ZenMethod
    public static int getCyclicInventoryStackInSlot(IPlayer iPlayer, IItemStack stack) {
        int num = -1;
        InventoryPlayerExtended playerExtended = UtilPlayerInventoryFilestorage.getPlayerInventory(CraftTweakerMC.getPlayer(iPlayer));
        for (int i = 0; i < 36; i++) {
            ItemStack itemStack = playerExtended.getStackInSlot(i);
            if (itemStack == CraftTweakerMC.getItemStack(stack)) num = i;
        }
        return num;
    }

    @ZenMethod
    public static IItemStack getCyclicInventoryInSlot(IPlayer iPlayer, int slot) {
        InventoryPlayerExtended playerExtended = UtilPlayerInventoryFilestorage.getPlayerInventory(CraftTweakerMC.getPlayer(iPlayer));
        return CraftTweakerMC.getIItemStack(playerExtended.getStackInSlot(slot));
    }

    @ZenMethod
    public static void setCyclicInventoryInSlot(IPlayer iPlayer, int slot, IItemStack stack) {
        InventoryPlayerExtended playerExtended = UtilPlayerInventoryFilestorage.getPlayerInventory(CraftTweakerMC.getPlayer(iPlayer));
        playerExtended.setInventorySlotContents(slot, CraftTweakerMC.getItemStack(stack));
    }
}
