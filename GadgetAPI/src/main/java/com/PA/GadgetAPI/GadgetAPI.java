package com.PA.GadgetAPI;

import com.PA.GadgetAPI.init.KeyBindingInit;
import com.PA.GadgetAPI.testing.BlockInit;
import com.PA.GadgetAPI.testing.ContianerInit;
import com.PA.GadgetAPI.testing.ItemInit;
import com.PA.GadgetAPI.testing.TileInit;
import com.PA.GadgetAPI.testing.objects.screen.ComputerScreen;

import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("gadget_api")
public final class GadgetAPI {

    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "gadget_api";

    public GadgetAPI() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        BlockInit.BLOCKS.register(modEventBus);
        ItemInit.ITEM.register(modEventBus);
        TileInit.TILES.register(modEventBus);
        ContianerInit.CONTAINER_TYPES.register(modEventBus);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        ClientRegistry.registerKeyBinding(KeyBindingInit.KEY_ALT_INTERACT);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        ScreenManager.register(ContianerInit.TEST_CHEST.get(), ComputerScreen::new);
    }
}