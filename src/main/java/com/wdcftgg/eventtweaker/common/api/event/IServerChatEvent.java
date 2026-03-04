package com.wdcftgg.eventtweaker.common.api.event;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.event.IEventCancelable;
import crafttweaker.api.player.IPlayer;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;


@ZenRegister
@ZenClass("mods.eventtweaker.event.ServerChatEvent")
public interface IServerChatEvent extends IEventCancelable {

    @ZenGetter("message")
    String getMessage();

    @ZenGetter("username")
    String getUsername();

    @ZenGetter("player")
    IPlayer getPlayer();
}