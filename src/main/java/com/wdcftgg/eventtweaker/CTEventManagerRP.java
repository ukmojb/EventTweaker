package com.wdcftgg.eventtweaker;

import com.therandomlabs.randomportals.api.event.NetherPortalEvent;
import com.wdcftgg.eventtweaker.common.api.event.IManaChangeEvent;
import com.wdcftgg.eventtweaker.common.api.event.INetherPortalEvent;
import com.wdcftgg.eventtweaker.common.impl.event.MCManaChangeEvent;
import com.wdcftgg.eventtweaker.common.impl.event.MCNetherPortalEvent;
import com.wdcftgg.eventtweaker.common.mcevent.mods.ManaChangeEvent;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.event.IEventHandle;
import crafttweaker.api.event.IEventManager;
import crafttweaker.util.EventList;
import crafttweaker.util.IEventHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : wdcftgg
 * @create 2024/1/27 22:57
 */
@ZenRegister
@ZenClass("mods.eventtweaker.randomportals.IEventManager")
@ZenExpansion("crafttweaker.events.IEventManager")
@ModOnly("botania")
public abstract class CTEventManagerRP {

    private static final EventList<INetherPortalEvent> NetherPortalList = new EventList<>();

    @ZenMethod
    public static IEventHandle onNetherPortalAdd(IEventManager manager, IEventHandler<INetherPortalEvent> event) {
        return NetherPortalList.add(event);
    }


    public static final class Handler {

        @SubscribeEvent
        public static void onManaChangeEvent(NetherPortalEvent.Activate event) {
            if (NetherPortalList.hasHandlers()) {
                NetherPortalList.publish(new MCNetherPortalEvent(event));
            }
        }

    }

}
