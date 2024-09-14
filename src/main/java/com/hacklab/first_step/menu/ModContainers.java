package com.hacklab.first_step.menu;

import com.hacklab.first_step.First_step;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModContainers {
    public static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, First_step.MODID);

    public static final RegistryObject<MenuType<StorageBoxMenu>> CUSTOM_CONTAINER = CONTAINERS.register("storage_box",
            () -> IForgeMenuType.create(StorageBoxMenu::new));
}
