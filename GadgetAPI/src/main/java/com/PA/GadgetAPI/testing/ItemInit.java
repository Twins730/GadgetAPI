package com.PA.GadgetAPI.testing;

import com.PA.GadgetAPI.GadgetAPI;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

    public static DeferredRegister<Item> ITEM = DeferredRegister.create(ForgeRegistries.ITEMS, GadgetAPI.MOD_ID);

    public static RegistryObject<Item> pickupableTestItem = ITEM.register("test_pickupblock",()-> new BlockItem(BlockInit.pickupableTestBlock.get(),new Item.Properties().tab(ItemGroup.TAB_MISC).stacksTo(1)));

}
