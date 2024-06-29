package com.wdcftgg.eventtweaker.common;


import com.wdcftgg.eventtweaker.EventTweaker;
import net.minecraftforge.common.config.Config;

@Config(modid = EventTweaker.MODID) // 相当于入口标记一样的东西。`modid` 一定要填你的 mod id。
@Config.LangKey("config." + EventTweaker.NAME + ".general")
public class EvtConfig {

    @Config.Comment("Baubles' version is https://www.curseforge.com/minecraft/mc-mods/bubbles-a-baubles-fork")
    @Config.Name("isBaubleFork")
    @Config.RequiresMcRestart
    public static boolean isBaubleFork = false;
}
