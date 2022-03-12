package com.PA.GadgetAPI.computer.app;

import com.mojang.blaze3d.matrix.MatrixStack;

/**
 * You can ignore this class it just lets me call your renderer in the device
 * */
public interface IAppRenderable {

    //Called in the device mods device renderer
    public void render(MatrixStack matrixStack);

}
