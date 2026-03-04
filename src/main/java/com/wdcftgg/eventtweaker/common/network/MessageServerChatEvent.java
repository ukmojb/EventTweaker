package com.wdcftgg.eventtweaker.common.network;

import com.wdcftgg.eventtweaker.common.mcevent.mc.ClientChatEvent;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageServerChatEvent implements IMessageHandler<MessageServerChatEvent, IMessage>, IMessage  {

    private String originalMessage;
    private String message;

    public MessageServerChatEvent() {
    }

    public MessageServerChatEvent(String originalMessage, String message) {
        this.originalMessage = originalMessage;
        this.message = message;
    }

    public void fromBytes(ByteBuf buf) {
        this.originalMessage = ByteBufUtils.readUTF8String(buf);
        this.message = ByteBufUtils.readUTF8String(buf);
    }

    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeUTF8String(buf, originalMessage);
        ByteBufUtils.writeUTF8String(buf, message);
    }


    public IMessage onMessage(MessageServerChatEvent message, MessageContext ctx) {

        ClientChatEvent clientChatEvent = new ClientChatEvent(message.originalMessage, message.message);
        clientChatEvent.post();

        return null;
    }
}

