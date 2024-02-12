package com.wdcftgg.eventtweaker.mixins;

import com.wdcftgg.eventtweaker.EventTweaker;
import net.minecraftforge.common.ForgeVersion;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import zone.rong.mixinbooter.ILateMixinLoader;

import java.util.Collections;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : wdcftgg
 * @create 2024/1/20 10:54
 */
@SuppressWarnings("unused")
@IFMLLoadingPlugin.Name(EventTweaker.MODID)
@IFMLLoadingPlugin.MCVersion(ForgeVersion.mcVersion)
public class MixinConfig implements ILateMixinLoader {
    @Override
    public List<String> getMixinConfigs() {
        return Collections.singletonList("mixins.eventtweaker.json");
    }
}
