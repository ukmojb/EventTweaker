package com.wdcftgg.eventtweaker.client.api;

import crafttweaker.annotations.ZenRegister;
import net.minecraft.client.renderer.GlStateManager;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : wdcftgg
 * @create 2024/1/13 21:34
 */
@ZenRegister
@ZenClass("mods.eventtweaker.event.RenderGameOverlayEvent")
public interface IRenderGameOverlayEvent {

    @ZenMethod
    float getPartialTicks();

}
