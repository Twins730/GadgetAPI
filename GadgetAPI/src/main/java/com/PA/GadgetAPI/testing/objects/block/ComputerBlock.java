package com.PA.GadgetAPI.testing.objects.block;

import com.PA.GadgetAPI.objects.block.PickupableBlock;
import com.PA.GadgetAPI.testing.TileInit;
import com.PA.GadgetAPI.testing.objects.tile.ComputerTile;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;

public class ComputerBlock extends PickupableBlock {

    public ComputerBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void altInteraction(PlayerEntity entity, BlockState state, BlockPos pos, World world) {
        setOverrideAltInteraction(false);
        world.playSound(entity, pos, SoundEvents.ITEM_PICKUP, SoundCategory.BLOCKS, 1, 1);
    }

    @Override
    public void mainInteraction(PlayerEntity entity, BlockState state, BlockPos pos, World world) {
        setOverrideAltInteraction(false);
        if (!world.isClientSide) {
            TileEntity tileentity = world.getBlockEntity(pos);
            if (tileentity instanceof ComputerTile) {
                NetworkHooks.openGui((ServerPlayerEntity) entity, (ComputerTile) tileentity, pos);
            }
        }
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return TileInit.test_tile.get().create();
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }
}
