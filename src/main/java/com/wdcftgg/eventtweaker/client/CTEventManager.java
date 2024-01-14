package com.wdcftgg.eventtweaker.client;

import com.wdcftgg.eventtweaker.client.api.IClientChatEvent;
import com.wdcftgg.eventtweaker.client.api.IRenderGameOverlayEvent;
import com.wdcftgg.eventtweaker.client.event.MCClientChatEvent;
import com.wdcftgg.eventtweaker.client.event.MCRenderGameOverlayEvent;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.event.IEventHandle;
import crafttweaker.api.event.IEventManager;
import crafttweaker.util.EventList;
import crafttweaker.util.IEventHandler;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
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
@ZenClass("mods.eventtweaker.IEventManager")
@ZenExpansion("crafttweaker.events.IEventManager")
public abstract class CTEventManager {

    private static final EventList<IClientChatEvent> ClientChatEventList = new EventList<>();
    private static final EventList<IRenderGameOverlayEvent> RenderGameOverlayEventList = new EventList<>();

    @ZenMethod
    public static IEventHandle onClientChat(IEventManager manager, IEventHandler<IClientChatEvent> event) {
        return ClientChatEventList.add(event);
    }

    @ZenMethod
    public static IEventHandle onRenderGameOverlay(IEventManager manager, IEventHandler<IRenderGameOverlayEvent> event) {
        return RenderGameOverlayEventList.add(event);
    }

    public static final class Handler {

        @SubscribeEvent
        public static void onClientChatEvent(ClientChatEvent event) {
            if (ClientChatEventList.hasHandlers()) {
                ClientChatEventList.publish(new MCClientChatEvent(event));
            }
        }

        @SubscribeEvent
        public static void onRenderGameOverlayEvent(RenderGameOverlayEvent event) {
            if (RenderGameOverlayEventList.hasHandlers()) {
                RenderGameOverlayEventList.publish(new MCRenderGameOverlayEvent(event));
            }
        }

    }

}
