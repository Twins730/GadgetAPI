package com.PA.GadgetAPI.objects.app;

import com.PA.GadgetAPI.computer.app.App;
import com.mojang.blaze3d.matrix.MatrixStack;

/**
 * Here is an example of how to make an app
 * if it is full screen then it will take up the entire screen.
 * if it needs internet then the app will show an "error needs internet window"
 * below is a render method you can use DeviceUtils class for help
 * */
public class ExampleApp extends App {

    public ExampleApp(AppBuilder builder) {
        super(builder);
    }

    @Override
    public void render(MatrixStack matrixStack) {
        super.render(matrixStack);
    }
}
