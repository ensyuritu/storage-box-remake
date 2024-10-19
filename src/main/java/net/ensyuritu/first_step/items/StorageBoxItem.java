package net.ensyuritu.first_step.items;

import net.ensyuritu.first_step.menu.StorageBoxMenu;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StorageBoxItem extends Item {
    public static final Logger LOGGER = LogManager.getLogger();
    public StorageBoxItem(Item.Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        if(!world.isClientSide) {
            player.openMenu(new SimpleMenuProvider((id, playerInventory, playerEntity) -> {
                return new StorageBoxMenu(id, playerInventory);
            }, Component.translatable("container.storage_box")));
        }
        return InteractionResultHolder.success(player.getItemInHand(hand));
    }

}
