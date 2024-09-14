package com.hacklab.first_step.menu;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.ModContainer;
import org.jetbrains.annotations.Nullable;

public class StorageBoxMenu extends AbstractContainerMenu {
    public StorageBoxMenu(int id, Inventory playerInventory) {
        super(ModContainers.CUSTOM_CONTAINER.get(), id);
        // 必要な初期化をここに記述
    }

    public StorageBoxMenu(int id, Inventory playerInventory, FriendlyByteBuf data) {
        super(ModContainers.CUSTOM_CONTAINER.get(), id);
        // FriendlyByteBufを使用した初期化をここに記述
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
