package com.PA.GadgetAPI.mixin;

import com.PA.GadgetAPI.objects.event.RenderLevelEvent;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class GameRenderMixin {

    @Shadow @Final private Minecraft minecraft;

    @Inject(at = @At(value = "HEAD"), method = "renderLevel")
    public void renderLevel(float f1, long vector3f, MatrixStack f2, CallbackInfo ci){
        MinecraftForge.EVENT_BUS.post(new RenderLevelEvent(minecraft,f2,f1));
    }

}
