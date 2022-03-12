package com.PA.GadgetAPI.objects.block;

import com.PA.GadgetAPI.GadgetAPI;
import com.PA.GadgetAPI.init.KeyBindingInit;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is to be used for blocks that the player can pick up by shift-clicking
 * -You need to register a tile entity for most of this class to work
 * */
public abstract class PickupableBlock extends Block {

    private List<CompoundNBT> data = new ArrayList<>();
    private List<String> dataName = new ArrayList<>();
    private boolean overrideAltInteraction = true;
    private Item item;

    public PickupableBlock(Properties properties) {
        super(properties);
    }

    public void setItem(Item item){
        this.item = item;
    }

    @Override
    //Called when the block is destroyed by mining or other means.
    public void playerWillDestroy(World world, BlockPos blockPos, BlockState state, PlayerEntity entity) {
        TileEntity tileentity = world.getBlockEntity(blockPos);
        if (!world.isClientSide && tileentity != null) {
            ItemStack stack = new ItemStack(item);
            CompoundNBT compoundnbt = tileentity.getTileData();
            stack.addTagElement("TileData", compoundnbt);
            if (data.size() > 0) {
                for (int i = 0; i < data.size(); i++) {
                    stack.addTagElement(dataName.get(i), data.get(i));
                }
            }
            ItemEntity itementity = new ItemEntity(world, (double) blockPos.getX() + 0.5D, (double) blockPos.getY() + 0.5D, (double) blockPos.getZ() + 0.5D, stack);
            itementity.setDefaultPickUpDelay();
            world.addFreshEntity(itementity);
        }
    }


    //Actually "pick up" the block and keep its data
    @Override
    public ActionResultType use(BlockState blockState, World world, BlockPos pos, PlayerEntity entity, Hand hand, BlockRayTraceResult traceResult) {
        TileEntity tileentity = world.getBlockEntity(pos);
        if (tileentity != null) {
            if (entity.isShiftKeyDown()) {
                if (item != null) {
                    ItemStack stack = new ItemStack(item);
                    CompoundNBT compoundnbt = tileentity.getTileData();
                    stack.addTagElement("TileData", compoundnbt);
                    if (data.size() > 0) {
                        for (int i = 0; i < data.size(); i++) {
                            stack.addTagElement(dataName.get(i), data.get(i));
                        }
                    }
                    entity.addItem(stack);
                    world.removeBlock(pos, false);
                    world.playSound(entity, pos, SoundEvents.ITEM_PICKUP, SoundCategory.AMBIENT, 1f, 1f);
                    return ActionResultType.SUCCESS;
                } else {
                    GadgetAPI.LOGGER.error("{} is null");
                    return ActionResultType.FAIL;
                }

            } else {
                if (KeyBindingInit.KEY_ALT_INTERACT.isDown() || overrideAltInteraction) {
                    altInteraction(entity,blockState,pos,world);
                } else {
                    mainInteraction(entity, blockState, pos, world);
                }
                return ActionResultType.SUCCESS;
            }
        }

        return ActionResultType.PASS;
    }

    public void setOverrideAltInteraction(boolean overrideAltInteraction){
        this.overrideAltInteraction = overrideAltInteraction;
    }

    public boolean isOverrideAltInteraction(){
        return overrideAltInteraction;
    }

    /** Put what ever you want to be run for the alternate interaction*/
    public abstract void altInteraction(PlayerEntity entity,BlockState state,BlockPos pos,World world);

    /** Put what ever you want to be run for the main interaction*/
    public abstract void mainInteraction(PlayerEntity entity,BlockState state,BlockPos pos,World world);


    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }
}
