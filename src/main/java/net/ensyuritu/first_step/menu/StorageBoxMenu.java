package net.ensyuritu.first_step.menu;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;

public class StorageBoxMenu extends AbstractContainerMenu {
    public StorageBoxMenu(int id, Inventory playerInventory) {
        super(ModContainers.CUSTOM_CONTAINER.get(), id);
    }

    public StorageBoxMenu(int id, Inventory playerInventory, FriendlyByteBuf data) {
        super(ModContainers.CUSTOM_CONTAINER.get(), id);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int i) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }
}
