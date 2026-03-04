package com.wdcftgg.eventtweaker;

import com.wdcftgg.eventtweaker.client.impl.event.MCClientChatEvent;
import com.wdcftgg.eventtweaker.common.api.event.IPlayerFlyableFallEvent;
import com.wdcftgg.eventtweaker.client.api.event.IClientChatEvent;
import com.wdcftgg.eventtweaker.common.api.event.IServerChatEvent;
import com.wdcftgg.eventtweaker.common.impl.event.MCPlayerFlyableFallEvent;
import com.wdcftgg.eventtweaker.common.impl.event.MCServerChatEvent;
import com.wdcftgg.eventtweaker.common.mcevent.mc.ClientChatEvent;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.event.IEventHandle;
import crafttweaker.api.event.IEventManager;
import crafttweaker.util.EventList;
import crafttweaker.util.IEventHandler;
import net.minecraftforge.event.ServerChatEvent;
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
    private static final EventList<IPlayerFlyableFallEvent> PlayerFlyableFallEventList = new EventList<>();
    private static final EventList<IServerChatEvent> ServerChatEventList = new EventList<>();

    @ZenMethod
    public static IEventHandle onClientChat(IEventManager manager, IEventHandler<IClientChatEvent> event) {
        return ClientChatEventList.add(event);
    }

    @ZenMethod
    public static IEventHandle onPlayerFlyableFall(IEventManager manager, IEventHandler<IPlayerFlyableFallEvent> event) {
        return PlayerFlyableFallEventList.add(event);
    }

    @ZenMethod
    public static IEventHandle onServerChat(IEventManager manager, IEventHandler<IServerChatEvent> event) {
        return ServerChatEventList.add(event);
    }

    public static final class HandlerS {

        @SubscribeEvent
        public static void onPlayerFlyableFall(PlayerFlyableFallEvent event) {
            if (PlayerFlyableFallEventList.hasHandlers()) {
                PlayerFlyableFallEventList.publish(new MCPlayerFlyableFallEvent(event));
            }
        }

        @SubscribeEvent
        public static void onClientChatEvent(ClientChatEvent event) {
            if (ClientChatEventList.hasHandlers()) {
                ClientChatEventList.publish(new MCClientChatEvent(event));
            }
        }

        @SubscribeEvent
        public static void onServerChat(ServerChatEvent event) {
            if (ServerChatEventList.hasHandlers()) {
                ServerChatEventList.publish(new MCServerChatEvent(event));
            }
        }

    }

}
