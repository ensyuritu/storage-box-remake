package net.ensyuritu.first_step.menu;

import net.ensyuritu.first_step.items.StorageBoxItem;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;

public class StorageBoxMenu extends AbstractContainerMenu {
    private final ItemStackHandler itemHandler;
    private final ItemStack stack;

    // クライアント側コンストラクタ（サーバーデータなし）
    public StorageBoxMenu(int containerId, Inventory playerInventory) {
        this(containerId, playerInventory, new ItemStackHandler(1), ItemStack.EMPTY);
    }

    // サーバー側コンストラクタ
    public StorageBoxMenu(int containerId, Inventory playerInventory, ItemStackHandler itemHandler, ItemStack stack) {
        super(ModContainers.CUSTOM_CONTAINER.get(), containerId);
        this.itemHandler = itemHandler;
        this.stack = stack;

        // カスタムスロット
        this.addSlot(new SlotItemHandler(itemHandler, 0, 26, 36));

        // プレイヤーのインベントリスロット
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; ++col) {
                this.addSlot(new Slot(playerInventory, col + row * 9 + 9, 8 + col * 18, 84 + row * 18));
            }
        }

        // ホットバー
        for (int col = 0; col < 9; ++col) {
            this.addSlot(new Slot(playerInventory, col, 8 + col * 18, 142));
        }
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }

    @Override
    public ItemStack quickMoveStack(Player player, int i) {
        return ItemStack.EMPTY;
    }

    @Override
    public void removed(Player player) {
        super.removed(player);
        // クライアントでは保存しない
        if (!player.level.isClientSide) {
            // アイテムにインベントリデータを保存
            StorageBoxItem.saveInventory(stack, itemHandler);
        }
    }
}