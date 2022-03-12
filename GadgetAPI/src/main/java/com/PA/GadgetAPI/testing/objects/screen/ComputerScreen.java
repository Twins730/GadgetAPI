package com.PA.GadgetAPI.testing.objects.screen;

import com.PA.GadgetAPI.GadgetAPI;
import com.PA.GadgetAPI.computer.background.BackGrounds;
import com.PA.GadgetAPI.testing.objects.container.TestLaptopContainer;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class ComputerScreen extends ContainerScreen<TestLaptopContainer> {

    private static final ResourceLocation TEX = new ResourceLocation("options_background.png");


    public ComputerScreen(TestLaptopContainer container, PlayerInventory inv, ITextComponent textComponent) {
        super(container,inv,new TranslationTextComponent(GadgetAPI.MOD_ID+".screen.computer"));
        this.leftPos = 0;
        this.topPos = 0;
    }


    @Override
    public void render(final MatrixStack stack, int mouseX, int mouseY,float ticks) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferbuilder = tessellator.getBuilder();
        this.minecraft.getTextureManager().bind(BACKGROUND_LOCATION);
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);

        this.renderDirtBackground(stack,0,bufferbuilder);

        tessellator.end();

        drawString(stack,this.minecraft.font, BackGrounds.BACKGROUNDS.get(0).getName(),this.width/2,this.height/2,10526880);

    }

    public void renderDirtBackground(MatrixStack stack,int p_231165_1_,BufferBuilder bufferbuilder) {

        bufferbuilder.vertex(8.0D, (double)this.height-16, 0.0D).uv(0.0F, (float)this.height / 32.0F + (float)p_231165_1_).color(64, 64, 64, 255).endVertex();
        bufferbuilder.vertex((double)this.width-16, (double)this.height-16, 0.0D).uv((float)this.width / 32.0F, (float)this.height / 32.0F + (float)p_231165_1_).color(64, 64, 64, 255).endVertex();
        bufferbuilder.vertex((double)this.width-16, 0.0D, 0.0D).uv((float)this.width / 32.0F, (float)p_231165_1_).color(64, 64, 64, 255).endVertex();
        bufferbuilder.vertex(8.0D, 8.0D, 0.0D).uv(0.0F, (float)p_231165_1_).color(64, 64, 64, 255).endVertex();


    }

    @Override
    protected void renderBg(MatrixStack p_230450_1_, float p_230450_2_, int p_230450_3_, int p_230450_4_) {

    }




}
