package com.wdcftgg.eventtweaker.client.impl.event;

import com.wdcftgg.eventtweaker.client.api.event.IClientChatEvent;
import com.wdcftgg.eventtweaker.common.mcevent.mc.ClientChatEvent;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : wdcftgg
 * @create 2024/1/13 19:14
 */
public class MCClientChatEvent implements IClientChatEvent {
    private final ClientChatEvent event;

    public MCClientChatEvent(ClientChatEvent event) {
        this.event = event;
    }

    @Override
    public String getMessage() {
        return event.getMessage();
    }

    @Override
    public String getOriginalMessage() {
        return event.getOriginalMessage();
    }

    @Override
    public boolean isCanceled() {
        return false;
    }

    @Override
    public void setCanceled(boolean canceled) {
    }
}