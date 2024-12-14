package net.ensyuritu.first_step.menu;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.DataSlot;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;

public class StorageBoxMenu extends AbstractContainerMenu {
    //Client Menu Constructor
    public StorageBoxMenu(int containerId, Inventory playerInventory) {
        this(containerId, playerInventory, new ItemStackHandler(1), DataSlot.standalone());
    }

    //Server Menu Constructor
    public StorageBoxMenu(int containerId, Inventory playerInventory, IItemHandler dataInventory, DataSlot dataSingle) {
        super(ModContainers.CUSTOM_CONTAINER.get(), containerId);

        int slotSquareSize = 18;

        // Add Item Slot
        {
            int posX = 26;
            int posY = 36;
            this.addSlot(new SlotItemHandler(dataInventory, dataInventory.getSlots(), posX, posY));
        }


        // Add Hotbar Slot
        for(int i=0; i<9; i++){
            int inventorySlotId = i;
            int PosX = 8;
            int PosY = 142;
            this.addSlot(new Slot(playerInventory, inventorySlotId, PosX + slotSquareSize * i, PosY));
        }

        // Add Inventory Slot
        for(int i=0; i<27; i++){
            int inventorySlotId = i + 9;
            int PosX = 8;
            int PosY = 84;
            this.addSlot(new Slot(playerInventory, inventorySlotId, PosX + slotSquareSize * (i % 9), PosY + slotSquareSize * (i / 9)));
        }

        // Add data slots for handled integers
        this.addDataSlot(dataSingle);
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
