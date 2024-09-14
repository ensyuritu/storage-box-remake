package com.hacklab.first_step.menu;

import com.hacklab.first_step.First_step;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import org.slf4j.Logger;

public class StorageBoxScreen extends AbstractContainerScreen<StorageBoxMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(First_step.MODID, "textures/gui/container/storage_box.png");
    private static final Logger LOGGER = LogUtils.getLogger();

    public StorageBoxScreen(StorageBoxMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
    }

    @Override
    protected void renderBg(PoseStack poseStack, float v, int i, int i1) {
        LOGGER.info("StorageBoxScreen::renderBg");
        this.minecraft.getTextureManager().bindForSetup(TEXTURE);
        int x = (this.width - this.imageWidth) / 2;
        int y = (this.height - this.imageHeight) / 2;
        this.blit(poseStack, x, y, 0, 0, this.imageWidth, this.imageHeight);
    }
}
