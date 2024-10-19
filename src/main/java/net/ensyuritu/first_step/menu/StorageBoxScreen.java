package net.ensyuritu.first_step.menu;

import com.mojang.blaze3d.vertex.PoseStack;
import net.ensyuritu.first_step.Main;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class StorageBoxScreen extends AbstractContainerScreen<StorageBoxMenu> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(Main.MODID, "textures/gui/container/kari.png");

    public StorageBoxScreen(StorageBoxMenu menu, Inventory playerInventory, Component title){
        super(menu, playerInventory, title);
    }

    @Override
    protected void renderBg(PoseStack poseStack, float v, int i, int i1) {
        this.minecraft.getTextureManager().bindForSetup(TEXTURE);
        int x = (this.width - this.imageWidth) / 2;
        int y = (this.height - this.imageHeight) / 2;
        this.blit(poseStack, x, y, 0, 0, this.imageWidth, this.imageHeight);
    }
}
