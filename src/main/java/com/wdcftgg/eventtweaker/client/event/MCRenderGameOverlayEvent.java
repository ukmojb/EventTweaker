package com.wdcftgg.eventtweaker.client.event;

import com.wdcftgg.eventtweaker.client.api.IRenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : wdcftgg
 * @create 2024/1/13 21:35
 */
public class MCRenderGameOverlayEvent implements IRenderGameOverlayEvent {

    private final RenderGameOverlayEvent event;

    public MCRenderGameOverlayEvent(RenderGameOverlayEvent event) {
        this.event = event;
    }


    @Override
    public float getPartialTicks() {
        return event.getPartialTicks();
    }
}
