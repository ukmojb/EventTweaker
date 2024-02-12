package com.wdcftgg.eventtweaker;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
/**
 * Created by IntelliJ IDEA.
 *
 * @Author : wdcftgg
 * @create 2024/1/13 18:59
 */
@Mod(modid = EventTweaker.MODID, name = EventTweaker.NAME, version = EventTweaker.VERSION, dependencies="required-after:crafttweaker")
public class EventTweaker {

    public static final String MODID = "eventtweaker";
    public static final String NAME = "EventTweaker";
    public static final String VERSION = "1.0.0";
    public static Logger logger;
    @Mod.Instance
    public static EventTweaker instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();

    }

    @Mod.EventHandler
    public void onConstruct(FMLConstructionEvent event) {

        MinecraftForge.EVENT_BUS.register(CTEventManager.Handler.class);
        if (Loader.isModLoaded("botania")) {
            MinecraftForge.EVENT_BUS.register(CTEventManagerBot.Handler.class);
        }
        if (Loader.isModLoaded("randomportals")) {
            MinecraftForge.EVENT_BUS.register(CTEventManagerRP.Handler.class);
        }

    }
}
