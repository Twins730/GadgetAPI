package com.PA.GadgetAPI.testing;

import com.PA.GadgetAPI.GadgetAPI;
import com.PA.GadgetAPI.testing.objects.container.TestLaptopContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ContianerInit {

    public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = DeferredRegister.create(ForgeRegistries.CONTAINERS, GadgetAPI.MOD_ID);

    public static final RegistryObject<ContainerType<TestLaptopContainer>> TEST_CHEST = CONTAINER_TYPES.register("test_laptop",()-> IForgeContainerType.create(TestLaptopContainer::new));


}
