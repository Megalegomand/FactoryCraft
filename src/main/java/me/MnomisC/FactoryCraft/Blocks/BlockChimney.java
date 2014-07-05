package me.MnomisC.FactoryCraft.Blocks;

import me.MnomisC.FactoryCraft.FactoryCraft;
import me.MnomisC.FactoryCraft.Reference.Reference;
import me.MnomisC.FactoryCraft.TileEntity.TEChimney;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockChimney extends BlockContainer {
	
	public BlockChimney(String name) {
		super(Material.rock);
		this.setBlockName(name);
		this.setCreativeTab(FactoryCraft.tabFactoryCraft);
		this.setHardness(10F);
		this.setResistance(5F);
		this.setBlockBounds(0.0625F, 0F, 0.0625F, 0.9375F, 1F, 0.9375F);
		this.setBlockTextureName(Reference.MOD_ID + ":chimney");
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TEChimney();
	}
	
	public int getRenderType() {
		return -2;
	}
	
	public boolean isOpaqueCube() {
		return false;
	}
	
	public boolean renderAsNormalBlock() {
		return false;
	}
}
