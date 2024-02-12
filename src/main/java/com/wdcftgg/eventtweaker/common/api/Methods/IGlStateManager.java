package com.wdcftgg.eventtweaker.common.api.Methods;

import crafttweaker.annotations.ZenRegister;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : wdcftgg
 * @create 2024/1/13 22:02
 */
@ZenRegister
@ZenClass("mods.eventtweaker.GlStateManager")
public class IGlStateManager {

    private static Tessellator tessellator = Tessellator.getInstance();

    private static BufferBuilder buffer = tessellator.getBuffer();

    @ZenMethod
    public static void enableLighting()
    {
        GlStateManager.enableLighting();
    }

    @ZenMethod
    public static void disableLighting()
    {
        GlStateManager.disableLighting();
    }

    @ZenMethod
    public static void enableTexture2D()
    {
        GlStateManager.enableTexture2D();
    }

    @ZenMethod
    public static void disableTexture2D()
    {
        GlStateManager.disableTexture2D();
    }

    @ZenMethod
    public static void enableAlpha()
    {
        GlStateManager.enableAlpha();
    }

    @ZenMethod
    public static void disableAlpha()
    {
        GlStateManager.disableAlpha();
    }

    @ZenMethod
    public static void enableBlend()
    {
        GlStateManager.enableBlend();
    }

    @ZenMethod
    public static void disableBlend()
    {
        GlStateManager.disableBlend();
    }

    @ZenMethod
    public static void enableColorLogic()
    {
        GlStateManager.enableColorLogic();
    }

    @ZenMethod
    public static void disableColorLogic()
    {
        GlStateManager.disableColorLogic();
    }

    @ZenMethod
    public static void enableColorMaterial()
    {
        GlStateManager.enableColorMaterial();
    }

    @ZenMethod
    public static void disableColorMaterial()
    {
        GlStateManager.disableColorMaterial();
    }

    @ZenMethod
    public static void enableCull()
    {
        GlStateManager.enableCull();
    }

    @ZenMethod
    public static void disableCull()
    {
        GlStateManager.disableCull();
    }

    @ZenMethod
    public static void enableFog()
    {
        GlStateManager.enableFog();
    }

    @ZenMethod
    public static void disableFog()
    {
        GlStateManager.disableFog();
    }

    @ZenMethod
    public static void enableDepth()
    {
        GlStateManager.enableDepth();
    }

    @ZenMethod
    public static void disableDepth()
    {
        GlStateManager.disableDepth();
    }

    @ZenMethod
    public static void enableNormalize()
    {
        GlStateManager.enableNormalize();
    }

    @ZenMethod
    public static void disableNormalize()
    {
        GlStateManager.disableNormalize();
    }

    @ZenMethod
    public static void enablePolygonOffset()
    {
        GlStateManager.enablePolygonOffset();
    }

    @ZenMethod
    public static void disablePolygonOffset()
    {
        GlStateManager.disablePolygonOffset();
    }

    @ZenMethod
    public static void renderImage(String str)
    {
        Minecraft mc = Minecraft.getMinecraft();
        ResourceLocation res = new ResourceLocation(str);
        mc.getTextureManager().bindTexture(res);
    }

    @ZenMethod
    public static void createTessellator(float x1, float y1, float z1, float x2, float y2, float z2, float x3, float y3, float z3, float x4, float y4, float z4)
    {
        buffer.pos(x1, y1, z1).tex(0, 1).endVertex();
        buffer.pos(x2, y2, z2).tex(1, 1).endVertex();
        buffer.pos(x3, y3, z3).tex(1, 0).endVertex();
        buffer.pos(x4, y4, z4).tex(0, 0).endVertex();
        tessellator.draw();
    }

    @ZenMethod
    public static void draw()
    {
        tessellator.draw();
    }

    @ZenMethod
    public static void translate(float x, float y, float z)
    {
        GlStateManager.translate(x, y, z);
    }

    @ZenMethod
    public static void color(float colorRed, float colorGreen, float colorBlue, float colorAlpha)
    {
        GlStateManager.color(colorRed, colorGreen, colorBlue, colorAlpha);
    }

    @ZenMethod
    public static void color(float colorRed, float colorGreen, float colorBlue)
    {
        GlStateManager.color(colorRed, colorGreen, colorBlue);
    }

    @ZenMethod
    public static void rotate(float angle, float x, float y, float z)
    {
        GlStateManager.rotate(angle, x, y, z);
    }

    @ZenMethod
    public static void scale(float x, float y, float z)
    {
        GlStateManager.scale(x, y, z);
    }

    @ZenMethod
    public static void clearColor(float red, float green, float blue, float alpha)
    {
        GlStateManager.clearColor(red, green, blue, alpha);
    }
}
