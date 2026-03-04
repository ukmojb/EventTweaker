package com.wdcftgg.eventtweaker.common.mcevent.mc;

import com.wdcftgg.eventtweaker.common.mcevent.BaseEvent;

public class ClientChatEvent extends BaseEvent {

    private String originalMessage;
    private String message;

    public ClientChatEvent(String originalMessage, String message){
        this.originalMessage = originalMessage;
        this.message = message;
    }

    public String getOriginalMessage() {
        return originalMessage;
    }

    public String getMessage() {
        return message;
    }
}
