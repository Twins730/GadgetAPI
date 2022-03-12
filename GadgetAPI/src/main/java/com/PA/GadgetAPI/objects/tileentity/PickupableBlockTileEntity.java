package com.PA.GadgetAPI.objects.tileentity;

import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.TileEntityType;

/**
 * I Just made this, so I remember what class does what, you can to if you want, but it's not necessary
 * */
public abstract class PickupableBlockTileEntity extends LockableLootTileEntity implements ITickableTileEntity {

    public PickupableBlockTileEntity(TileEntityType<?> type) {
        super(type);
    }

    @Override
    public void load(BlockState p_230337_1_, CompoundNBT p_230337_2_) {
        super.load(p_230337_1_, p_230337_2_);
    }

    @Override
    public CompoundNBT save(CompoundNBT p_189515_1_) {
        return super.save(p_189515_1_);
    }


}
