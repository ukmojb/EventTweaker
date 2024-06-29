package com.wdcftgg.eventtweaker;

import com.wdcftgg.eventtweaker.client.api.event.IClientChatEvent;
import com.wdcftgg.eventtweaker.client.api.event.IRenderGameOverlayEvent;
import com.wdcftgg.eventtweaker.client.api.event.IRenderPlayerPostEvent;
import com.wdcftgg.eventtweaker.client.api.event.IRenderPlayerPreEvent;
import com.wdcftgg.eventtweaker.client.impl.event.MCClientChatEvent;
import com.wdcftgg.eventtweaker.client.impl.event.MCRenderGameOverlayEvent;
import com.wdcftgg.eventtweaker.client.impl.event.MCRenderPlayerPostEvent;
import com.wdcftgg.eventtweaker.client.impl.event.MCRenderPlayerPreEvent;
import com.wdcftgg.eventtweaker.common.api.event.IPlayerFlyableFallEvent;
import com.wdcftgg.eventtweaker.common.impl.event.MCPlayerFlyableFallEvent;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.event.IEventHandle;
import crafttweaker.api.event.IEventManager;
import crafttweaker.util.EventList;
import crafttweaker.util.IEventHandler;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.entity.player.PlayerFlyableFallEvent;
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
    private static final EventList<IRenderPlayerPreEvent> RenderPlayerPreEventList = new EventList<>();
    private static final EventList<IRenderPlayerPostEvent> RenderPlayerPostEventList = new EventList<>();
    private static final EventList<IPlayerFlyableFallEvent> PlayerFlyableFallEventList = new EventList<>();

    @ZenMethod
    public static IEventHandle onClientChat(IEventManager manager, IEventHandler<IClientChatEvent> event) {
        return ClientChatEventList.add(event);
    }

    @ZenMethod
    public static IEventHandle onRenderGameOverlay(IEventManager manager, IEventHandler<IRenderGameOverlayEvent> event) {
        return RenderGameOverlayEventList.add(event);
    }
    @ZenMethod
    public static IEventHandle onRenderPlayerPre(IEventManager manager, IEventHandler<IRenderPlayerPreEvent> event) {
        return RenderPlayerPreEventList.add(event);
    }
    @ZenMethod
    public static IEventHandle onRenderPlayerPost(IEventManager manager, IEventHandler<IRenderPlayerPostEvent> event) {
        return RenderPlayerPostEventList.add(event);
    }

    @ZenMethod
    public static IEventHandle onPlayerFlyableFall(IEventManager manager, IEventHandler<IPlayerFlyableFallEvent> event) {
        return PlayerFlyableFallEventList.add(event);
    }


    public static final class HandlerC {

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
        @SubscribeEvent
        public static void onRenderPlayerPre(RenderPlayerEvent.Pre event) {
            if (RenderPlayerPreEventList.hasHandlers()) {
                RenderPlayerPreEventList.publish(new MCRenderPlayerPreEvent(event));
            }
        }
        @SubscribeEvent
        public static void onRenderPlayerPost(RenderPlayerEvent.Post event) {
            if (RenderPlayerPostEventList.hasHandlers()) {
                RenderPlayerPostEventList.publish(new MCRenderPlayerPostEvent(event));
            }
        }


    }
    public static final class HandlerS {

        @SubscribeEvent
        public static void onPlayerFlyableFall(PlayerFlyableFallEvent event) {
            if (PlayerFlyableFallEventList.hasHandlers()) {
                PlayerFlyableFallEventList.publish(new MCPlayerFlyableFallEvent(event));
            }
        }

    }

}
