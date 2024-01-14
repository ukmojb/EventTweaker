package com.wdcftgg.eventtweaker.client.event;

import com.wdcftgg.eventtweaker.client.api.IClientChatEvent;
import net.minecraftforge.client.event.ClientChatEvent;

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
    public void setMessage(String message) {
        event.setMessage(message);
    }

    @Override
    public String getOriginalMessage() {
        return event.getOriginalMessage();
    }

    @Override
    public boolean isCanceled() {
        return event.isCanceled();
    }

    @Override
    public void setCanceled(boolean canceled) {
        event.setCanceled(canceled);
    }
}