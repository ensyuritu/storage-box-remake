package net.ensyuritu.first_step.items;

import net.ensyuritu.first_step.menu.StorageBoxMenu;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StorageBoxItem extends Item {
    private static final String INVENTORY_TAG = "Inventory";
    public static final Logger LOGGER = LogManager.getLogger();
    public static final Capability<IItemHandler> ITEM_HANDLER = CapabilityManager.get(new CapabilityToken<>(){});

    public StorageBoxItem(Item.Properties properties) {
        super(properties);
    }

    // インベントリデータを取得
    public static ItemStackHandler getInventory(ItemStack stack) {
        CompoundTag tag = stack.getOrCreateTag();
        ItemStackHandler handler = new ItemStackHandler(9); // スロット数を指定
        if (tag.contains(INVENTORY_TAG)) {
            handler.deserializeNBT(tag.getCompound(INVENTORY_TAG));
        }
        return handler;
    }

    // インベントリデータを保存
    public static void saveInventory(ItemStack stack, ItemStackHandler handler) {
        CompoundTag tag = stack.getOrCreateTag();
        tag.put(INVENTORY_TAG, handler.serializeNBT());
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        if (!world.isClientSide) {
            ItemStack stack = player.getItemInHand(hand);
            ItemStackHandler handler = getInventory(stack);

            // Menuを開く
            player.openMenu(new SimpleMenuProvider(
                    (id, playerInventory, playerEntity) -> new StorageBoxMenu(id, playerInventory, handler, stack),
                    Component.translatable("container.storage_box")
            ));

        }
        return InteractionResultHolder.success(player.getItemInHand(hand));
    }
}
