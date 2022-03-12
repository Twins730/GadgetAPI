package com.PA.GadgetAPI;

import com.PA.GadgetAPI.init.KeyBindingInit;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("gadget_api")
public final class GadgetAPI {

    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "gadget_api";

    public GadgetAPI() {
        ClientRegistry.registerKeyBinding(KeyBindingInit.KEY_ALT_INTERACT);
        MinecraftForge.EVENT_BUS.register(this);
    }
}