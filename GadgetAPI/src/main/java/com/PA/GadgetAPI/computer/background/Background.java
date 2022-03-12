package com.PA.GadgetAPI.computer.background;

import com.PA.GadgetAPI.GadgetAPI;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;

public final class Background {

    private final ResourceLocation textureLocation;
    private final TranslationTextComponent name;

    public Background(TranslationTextComponent name, ResourceLocation texture){
        this.name = name;
        this.textureLocation = texture;
    }

    public ResourceLocation getTextureLocation() {
        return textureLocation;
    }

    public TranslationTextComponent getName() {
        return name;
    }

    public static class BackgroundBuilder {

        private ResourceLocation textureLocation;
        private TranslationTextComponent name;

        public Background build(){
            if(name == null){
                GadgetAPI.LOGGER.error("{} has a null name!");
            } else if(textureLocation == null){
                GadgetAPI.LOGGER.error("{} has a null ResourceLocation!");
            } else {
                GadgetAPI.LOGGER.info("Background " + name + " was registered");
            }
            return new Background(name,textureLocation);
        }

        public BackgroundBuilder setName(String name){
            this.name = new TranslationTextComponent(name);
            return this;
        }
        public BackgroundBuilder setTextureLocation(ResourceLocation textureLocation){
            this.textureLocation = textureLocation;
            return this;
        }
    }
}
