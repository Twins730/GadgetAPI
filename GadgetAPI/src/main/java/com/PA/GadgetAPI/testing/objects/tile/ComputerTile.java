package com.PA.GadgetAPI.testing.objects.tile;

import com.PA.GadgetAPI.objects.tileentity.PickupableBlockTileEntity;
import com.PA.GadgetAPI.testing.TileInit;
import com.PA.GadgetAPI.testing.objects.container.TestLaptopContainer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;

public class ComputerTile extends PickupableBlockTileEntity {

    public ComputerTile(TileEntityType<?> type) {
        super(type);
    }

    public ComputerTile() {
        this(TileInit.test_tile.get());
    }



    @Override
    protected ITextComponent getDefaultName() {
        return null;
    }

    @Override
    protected Container createMenu(int p_213906_1_, PlayerInventory p_213906_2_) {
        return new TestLaptopContainer(p_213906_1_,p_213906_2_,this);
    }

    @Override
    public int getContainerSize() {
        return 0;
    }

    @Override
    public void tick() {

    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return null;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> p_199721_1_) {

    }
}
