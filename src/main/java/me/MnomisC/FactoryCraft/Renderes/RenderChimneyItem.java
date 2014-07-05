package me.MnomisC.FactoryCraft.Renderes;

import org.lwjgl.opengl.GL11;

import assets.FactoryCraft.models.ModelChimney;
import me.MnomisC.FactoryCraft.handlers.TextureHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class RenderChimneyItem implements IItemRenderer {

	private ModelChimney model;
	
	public RenderChimneyItem() {
		this.model = new ModelChimney();
	}
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		GL11.glPushMatrix();
		
		GL11.glScalef(1F, 1F, 1F);
		
		switch (type) {
			case INVENTORY:
				GL11.glTranslatef(0F, -1F, 0F);
				break;
			case ENTITY:
				GL11.glTranslatef(0, -0.5F, 0);
				break;
			case EQUIPPED:
				GL11.glTranslatef(0.5F, -0.5F, 0.5F);
				break;
			case EQUIPPED_FIRST_PERSON:
				GL11.glTranslatef(-0.6F, -0.2F, 0.7F);
				break;
			default:
				break;
		}
		
		Minecraft.getMinecraft().renderEngine.bindTexture(TextureHandler.chimney);
		
		model.renderAll();
		
		GL11.glPopMatrix();
	}
	
}
