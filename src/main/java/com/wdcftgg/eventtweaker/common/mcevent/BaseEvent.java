package com.wdcftgg.eventtweaker.common.mcevent;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : wdcftgg
 * @create 2024/1/20 10:57
 */
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.Event;

public class BaseEvent extends Event {

    public boolean post() {
        return MinecraftForge.EVENT_BUS.post(this);
    }

}
