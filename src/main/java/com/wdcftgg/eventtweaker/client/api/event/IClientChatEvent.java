package com.wdcftgg.eventtweaker.client.api.event;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.event.IEventCancelable;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenSetter;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : wdcftgg
 * @create 2024/1/13 19:13
 */
@ZenRegister
@ZenClass("mods.eventtweaker.event.ClientChatEvent")
public interface IClientChatEvent extends IEventCancelable {

    @ZenMethod
    String getMessage();

    @ZenMethod
    void setMessage(String message);

    @ZenMethod
    String getOriginalMessage();
}