package net.ensyuritu.first_step.menu;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.ensyuritu.first_step.Main;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class StorageBoxScreen extends AbstractContainerScreen<StorageBoxMenu> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(Main.MODID, "textures/gui/container/storage_box.png");

    public StorageBoxScreen(StorageBoxMenu menu, Inventory playerInventory, Component title){
        super(menu, playerInventory, title);
    }

    @Override
    protected void renderBg(PoseStack pose, float partialTick, int mouseX, int mouseY) {
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        RenderSystem.setShaderTexture(0, TEXTURE);

        int x = (this.width - this.imageWidth) / 2;
        int y = (this.height - this.imageHeight) / 2;
        this.blit(pose, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);
    }

    @Override
    public void render(PoseStack pose, int mouseX, int mouseY, float partialTick){
        this.renderBackground(pose);
        super.render(pose, mouseX, mouseY, partialTick);

        this.renderTooltip(pose, mouseX, mouseY);
    }

    @Override
    protected void renderLabels(PoseStack pose, int mouseX, int mouseY){
        super.renderLabels(pose, mouseX, mouseY);

        //this.font.draw(pose, label, labelX, labelY, 0x404040);
    }
}
