package com.PA.GadgetAPI.computer.app;

import com.PA.GadgetAPI.GadgetAPI;
import com.PA.GadgetAPI.objects.app.ExampleApp;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import java.util.ArrayList;

/**
 * Below is an example of how to register an app for the computer.
 * */
@Mod.EventBusSubscriber(modid = GadgetAPI.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Apps {

    /**
     * DO NOT Create a new ArrayList because it will not be registered
     * instead use Apps.APPS.add(your app registery here like seen below);
     *
     * */
    public static ArrayList<App> APPS = new ArrayList<>();

    //@SubscribeEvent
    public static void commonSetup(FMLCommonSetupEvent event) {
        //APPS.add(new ExampleApp(new App.AppBuilder().needsInternet(true).fullScreen(false).name("app.example_modid.example_app")));
    }
}
