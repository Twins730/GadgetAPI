package com.PA.GadgetAPI.computer.background;

import com.PA.GadgetAPI.GadgetAPI;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import java.util.ArrayList;

@Mod.EventBusSubscriber(modid = GadgetAPI.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BackGrounds {

    public static ArrayList<Background> BACKGROUNDS = new ArrayList<>();

    /**
     * A Registry would look something like this - Use common setup so servers can be synced as well as clients
     * When registering add it as BackGrounds.BACKGROUNDS and DO NOT create your own arraylist for this as they will not be added
     * */
    @SubscribeEvent
    public static void commonSetup(FMLCommonSetupEvent event) {
        BACKGROUNDS.add(new Background.BackgroundBuilder().setName("background.gadget_api.dev").setTextureLocation(new ResourceLocation(GadgetAPI.MOD_ID,"textures/backgrounds/developer_wallpaper.png")).build());
        BACKGROUNDS.add(new Background.BackgroundBuilder().setName("background.gadget_api.horse").setTextureLocation(new ResourceLocation(GadgetAPI.MOD_ID,"textures/backgrounds/horse.png")).build());
        BACKGROUNDS.add(new Background.BackgroundBuilder().setName("background.gadget_api.beach").setTextureLocation(new ResourceLocation(GadgetAPI.MOD_ID,"textures/backgrounds/sunset.png")).build());
        BACKGROUNDS.add(new Background.BackgroundBuilder().setName("background.gadget_api.mesa").setTextureLocation(new ResourceLocation(GadgetAPI.MOD_ID,"textures/backgrounds/mesa.png")).build());
        BACKGROUNDS.add(new Background.BackgroundBuilder().setName("background.gadget_api.sunset").setTextureLocation(new ResourceLocation(GadgetAPI.MOD_ID,"textures/backgrounds/sunset.png")).build());
        BACKGROUNDS.add(new Background.BackgroundBuilder().setName("background.gadget_api.dusk").setTextureLocation(new ResourceLocation(GadgetAPI.MOD_ID,"textures/backgrounds/dusk.png")).build());
        BACKGROUNDS.add(new Background.BackgroundBuilder().setName("background.gadget_api.space").setTextureLocation(new ResourceLocation(GadgetAPI.MOD_ID,"textures/backgrounds/space.png")).build());
        BACKGROUNDS.add(new Background.BackgroundBuilder().setName("background.gadget_api.bricks").setTextureLocation(new ResourceLocation(GadgetAPI.MOD_ID,"textures/backgrounds/bricks.png")).build());
    }
}
