package com.wdcftgg.eventtweaker;

import com.wdcftgg.eventtweaker.proxy.CommonProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
/**
 * Created by IntelliJ IDEA.
 *
 * @Author : wdcftgg
 * @create 2024/1/13 18:59
 */
@Mod(modid = EventTweaker.MODID, name = EventTweaker.NAME, version = EventTweaker.VERSION, dependencies="required-after:crafttweaker;after:botania")
public class EventTweaker {

    public static final String MODID = "eventtweaker";
    public static final String NAME = "EventTweaker";
    public static final String VERSION = "1.3";
    public static Logger logger;
    @Mod.Instance
    public static EventTweaker instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();

    }

    public static final String CLIENT_PROXY_CLASS = "com.wdcftgg.eventtweaker.proxy.ClientProxy";
    public static final String SERVER_PROXY_CLASS = "com.wdcftgg.eventtweaker.proxy.ServerProxy";

    @SidedProxy(clientSide = CLIENT_PROXY_CLASS, serverSide = SERVER_PROXY_CLASS)
    public static CommonProxy proxy;


    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.onInit();
    }
}
