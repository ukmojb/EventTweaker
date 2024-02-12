package com.wdcftgg.eventtweaker.mixins.bot;

import com.wdcftgg.eventtweaker.common.mcevent.mods.ManaChangeEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import vazkii.botania.api.subtile.SubTileEntity;
import vazkii.botania.api.subtile.SubTileFunctional;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : wdcftgg
 * @create 2024/1/20 10:56
 */
@Mixin(value = SubTileFunctional.class, remap = false)
public class MixinSubTileFunctional extends SubTileEntity {

    @Inject(method = "addMana", at = @At(value = "HEAD", target = "Lvazkii/botania/api/subtile/SubTileFunctional;addMana(I)V"))
    public void addMana(int mana, CallbackInfo ci) {
        ManaChangeEvent event = new ManaChangeEvent(this.getWorld().getBlockState(this.getPos()), this.getWorld(), this.getPos(), mana);
        event.post();
    }
}
