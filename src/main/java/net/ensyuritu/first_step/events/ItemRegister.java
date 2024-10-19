package net.ensyuritu.first_step.events;


import net.ensyuritu.first_step.items.StorageBoxItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.ensyuritu.first_step.Main.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus= Mod.EventBusSubscriber.Bus.FORGE)
public class ItemRegister {
    public static final DeferredRegister<Item>  ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final RegistryObject<Item> STORAGE_BOX_ITEM = ITEMS.register("storage_box", () -> new StorageBoxItem(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
