package com.wdcftgg.eventtweaker.common.Methods;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.player.IPlayer;
import net.minecraft.client.Minecraft;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : wdcftgg
 * @create 2024/1/13 21:44
 */
@ZenRegister
@ZenClass("mods.eventtweaker.Minecraft")
public class IMinecraft {

    @ZenMethod
    public static IPlayer getPlayer(){
        return CraftTweakerMC.getIPlayer(Minecraft.getMinecraft().player);
    }

    @ZenMethod
    public static int getfps(){
        return Minecraft.getDebugFPS();
    }

    @ZenMethod
    public static boolean isFullScreen(){
        return Minecraft.getMinecraft().isFullScreen();
    }

}
