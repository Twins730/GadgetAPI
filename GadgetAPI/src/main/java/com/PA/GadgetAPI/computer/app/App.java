package com.PA.GadgetAPI.computer.app;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.util.text.TranslationTextComponent;

public class App implements IAppRenderable{

    private boolean fullscreen;
    private boolean needsInternet;
    private TranslationTextComponent name;

    public App(AppBuilder builder){
       this.fullscreen = builder.isFullscreen();
       this.needsInternet = builder.isNeedsInternet();
       this.name = builder.getName();
    }

    public void render(MatrixStack matrixStack) {}

    public boolean isFullscreen() {
        return fullscreen;
    }

    public boolean isNeedsInternet() {
        return needsInternet;
    }

    public TranslationTextComponent getName() {
        return name;
    }

    public static class AppBuilder {

        private boolean fullscreen = false;
        private boolean needsInternet = false;
        private TranslationTextComponent name;

        public AppBuilder fullScreen(boolean fullscreen){
            this.fullscreen = fullscreen;
            return this;
        }

        public AppBuilder name(String name){
            this.name = new TranslationTextComponent(name);
            return this;
        }

        public AppBuilder needsInternet(boolean needsInternet){
            this.needsInternet = needsInternet;
            return this;
        }
        public boolean isFullscreen() {
            return fullscreen;
        }

        public boolean isNeedsInternet() {
            return needsInternet;
        }

        public TranslationTextComponent getName() {
            return name;
        }
    }
}