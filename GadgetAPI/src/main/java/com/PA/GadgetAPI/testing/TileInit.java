package com.PA.GadgetAPI.testing;

import com.PA.GadgetAPI.GadgetAPI;
import com.PA.GadgetAPI.objects.tileentity.PickupableBlockTileEntity;
import com.PA.GadgetAPI.testing.objects.tile.ComputerTile;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileInit {

    public static DeferredRegister<TileEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, GadgetAPI.MOD_ID);

    public static RegistryObject<TileEntityType<?>> test_tile = TILES.register("test_tile",()->TileEntityType.Builder.of(ComputerTile::new,BlockInit.pickupableTestBlock.get()).build(null));

}
