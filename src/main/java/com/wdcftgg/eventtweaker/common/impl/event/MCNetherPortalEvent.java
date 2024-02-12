package com.wdcftgg.eventtweaker.common.impl.event;

import com.therandomlabs.randomportals.api.event.NetherPortalEvent;
import com.therandomlabs.randomportals.api.netherportal.NetherPortal;
import com.wdcftgg.eventtweaker.common.api.event.INetherPortalEvent;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.world.IWorld;
import com.therandomlabs.randomportals.api.frame.Frame;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : wdcftgg
 * @create 2024/1/27 22:58
 */
public class MCNetherPortalEvent implements INetherPortalEvent {

    private final NetherPortalEvent.Activate event;

    public MCNetherPortalEvent(NetherPortalEvent.Activate event) {
        this.event = event;
    }


    @Override
    public IWorld getWorld() {
        return CraftTweakerMC.getIWorld(event.getWorld());
    }

    @Override
    public int getHeight() {
        return event.getPortal().getFrame().getHeight();
    }

    @Override
    public int getWidth() {
        return event.getPortal().getFrame().getWidth();
    }

    @Override
    public boolean isUserCreated() {
        return event.isUserCreated();
    }

    @Override
    public boolean isActivatedByFire() {
        return event.isActivatedByFire();
    }

    @Override
    public boolean isValid()
    {
        Frame netherPortal = event.getPortal().getFrame();
        return netherPortal.getBottomLeft() != null && netherPortal.getWidth() >= 2 && netherPortal.getWidth() <= 21 && netherPortal.getHeight() >= 3 && netherPortal.getHeight() <= 21;
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
