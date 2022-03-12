package com.PA.GadgetAPI;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.client.model.SeparatePerspectiveModel;

public class DeviceUtils {

    public static int calcDistanceBlockPos(BlockPos start,BlockPos end){
        int x1 = start.getX();
        int y1 = start.getY();
        int z1 = start.getZ();
        int x2 = end.getX();
        int y2 = end.getY();
        int z2 = end.getZ();

        float m1 = (float) Math.sqrt(((x1-x2)^2) + ((y1-y2)^2) + ((z1-z2)^2));
        int m2 = Math.round(m1);

        return m2;
    }


    public static void renderItem(TileEntity entity, ItemStack itemStack, MatrixStack matrixStack, IRenderTypeBuffer bufferIn, float ticks, int light, int overlay, float x, float y, float z){
        matrixStack.pushPose();

        if (itemStack != null && !itemStack.isEmpty()) {

            SeparatePerspectiveModel.BakedModel ibakedmodel = (SeparatePerspectiveModel.BakedModel) Minecraft.getInstance().getItemRenderer().getModel(itemStack, entity.getLevel(), null);
            matrixStack.translate(x,y,z);
            Minecraft.getInstance().getItemRenderer().render(itemStack, ItemCameraTransforms.TransformType.FIXED, false, matrixStack, bufferIn, light, OverlayTexture.NO_OVERLAY, ibakedmodel);
        }

        matrixStack.popPose();

    }

}
