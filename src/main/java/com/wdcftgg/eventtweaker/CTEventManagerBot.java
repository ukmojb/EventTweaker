package com.wdcftgg.eventtweaker;

import com.wdcftgg.eventtweaker.client.api.event.IClientChatEvent;
import com.wdcftgg.eventtweaker.client.api.event.IRenderGameOverlayEvent;
import com.wdcftgg.eventtweaker.client.impl.event.MCClientChatEvent;
import com.wdcftgg.eventtweaker.client.impl.event.MCRenderGameOverlayEvent;
import com.wdcftgg.eventtweaker.common.api.event.IManaChangeEvent;
import com.wdcftgg.eventtweaker.common.impl.event.MCManaChangeEvent;
import com.wdcftgg.eventtweaker.common.mcevent.mods.ManaChangeEvent;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.event.IEventHandle;
import crafttweaker.api.event.IEventManager;
import crafttweaker.util.EventList;
import crafttweaker.util.IEventHandler;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : wdcftgg
 * @create 2024/1/13 20:10
 */
@ZenRegister
@ZenClass("mods.eventtweaker.botania.IEventManager")
@ZenExpansion("crafttweaker.events.IEventManager")
@ModOnly("botania")
public abstract class CTEventManagerBot {

    private static final EventList<IManaChangeEvent> ManaChangeList = new EventList<>();

    @ZenMethod
    public static IEventHandle onManaChange(IEventManager manager, IEventHandler<IManaChangeEvent> event) {
        return ManaChangeList.add(event);
    }


    public static final class Handler {

        @SubscribeEvent
        public static void onManaChangeEvent(ManaChangeEvent event) {
            if (ManaChangeList.hasHandlers()) {
                ManaChangeList.publish(new MCManaChangeEvent(event));
            }
        }

    }

}
