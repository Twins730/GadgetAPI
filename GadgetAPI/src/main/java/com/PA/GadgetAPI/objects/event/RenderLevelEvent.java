package com.PA.GadgetAPI.objects.event;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraftforge.eventbus.api.Event;

public class RenderLevelEvent extends Event {

    private Minecraft minecraft;
    private MatrixStack stack;
    private float ticks;

    public RenderLevelEvent(Minecraft minecraft, MatrixStack stack, float ticks) {
        this.minecraft = minecraft;
        this.stack = stack;
        this.ticks = ticks;
    }

    public Minecraft getMinecraft() {
        return minecraft;
    }

    public MatrixStack getStack() {
        return stack;
    }

    public float getTicks() {
        return ticks;
    }
}
