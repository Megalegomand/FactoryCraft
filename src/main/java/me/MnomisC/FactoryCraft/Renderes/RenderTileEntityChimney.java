package me.MnomisC.FactoryCraft.Renderes;

import org.lwjgl.opengl.GL11;

import assets.FactoryCraft.models.ModelChimney;
import me.MnomisC.FactoryCraft.Reference.Reference;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderTileEntityChimney extends TileEntitySpecialRenderer {
	
	private ModelChimney model;
	private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID + ":textures/models/chimney.png");
	
	public RenderTileEntityChimney() {
		this.model = new ModelChimney();
	}
	
	@Override
	public void renderTileEntityAt(TileEntity teChimney, double x, double y, double z, float rotation) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		GL11.glScalef(1.0F, -1F, -1F);
		GL11.glRotatef(0F, 0.0F, 1.0F, 0.0F);
		this.bindTexture(texture);
		this.model.renderAll();
		GL11.glPopMatrix();
	}
}
