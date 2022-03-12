package com.PA.GadgetAPI.testing;

import com.PA.GadgetAPI.GadgetAPI;
import com.PA.GadgetAPI.objects.block.PickupableBlock;
import com.PA.GadgetAPI.testing.objects.block.ComputerBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {

    public static DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, GadgetAPI.MOD_ID);

    public static RegistryObject<Block> pickupableTestBlock = BLOCKS.register("test_pickupblock",()-> new ComputerBlock(AbstractBlock.Properties.of(Material.BARRIER).strength(10,10)));



}
