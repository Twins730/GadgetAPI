package com.PA.GadgetAPI.testing.objects.container;

import com.PA.GadgetAPI.testing.BlockInit;
import com.PA.GadgetAPI.testing.ContianerInit;
import com.PA.GadgetAPI.testing.objects.tile.ComputerTile;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;

import javax.annotation.Nullable;
import java.util.Objects;

public class TestLaptopContainer extends Container {

    public final ComputerTile tileEntity;
    private final IWorldPosCallable canInteractWithCallable;

    public TestLaptopContainer(final int windowId, final PlayerInventory playerInventory, final PacketBuffer data) {
        this(windowId, playerInventory, getTileEntity(playerInventory, data));
    }

    public TestLaptopContainer(final int windowId, final PlayerInventory playerInventory, final ComputerTile tileEntity) {
        super(ContianerInit.TEST_CHEST.get(), windowId);
        this.canInteractWithCallable = IWorldPosCallable.create(tileEntity.getLevel(), tileEntity.getBlockPos());
        this.tileEntity = tileEntity;
    }

    @Override
    public boolean stillValid(PlayerEntity playerIn) {
        return stillValid(canInteractWithCallable, playerIn, BlockInit.pickupableTestBlock.get());
    }

    private static ComputerTile getTileEntity(final PlayerInventory playerInventory, final PacketBuffer data) {
        Objects.requireNonNull(playerInventory, "playerInventory cannot be null");
        Objects.requireNonNull(data, "data cannot be null");
        final TileEntity tileAtPos = playerInventory.player.level.getBlockEntity(data.readBlockPos());
        if (tileAtPos instanceof ComputerTile) {
            return (ComputerTile) tileAtPos;
        }
        throw new IllegalStateException("Tile entity is not correct! " + tileAtPos);
    }
}
