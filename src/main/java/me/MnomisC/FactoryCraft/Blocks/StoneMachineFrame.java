package me.MnomisC.FactoryCraft.Blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.MnomisC.FactoryCraft.FactoryCraft;
import me.MnomisC.FactoryCraft.Reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.Random;

public class StoneMachineFrame extends Block {
	
	int x, y, z;
	World world;
	
	IIcon main;
	IIcon error;
	
	IIcon normal;
	IIcon vl;
	IIcon vr;
	IIcon ht;
	IIcon hb;
	IIcon tlc;
	IIcon trc;
	IIcon blc;
	IIcon brc;
	
	public StoneMachineFrame(String name) {
		super(Material.rock);
		
		this.setBlockName(name);
		this.setCreativeTab(FactoryCraft.tabFactoryCraft);
		this.setBlockTextureName(Reference.MOD_ID + ":CobbleMB");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister ir) {
		main = ir.registerIcon(Reference.MOD_ID + ":Glass");
		error = ir.registerIcon(Reference.MOD_ID + ":ERROR");
		
		normal = ir.registerIcon(Reference.MOD_ID + ":StoneMB");
		vr = ir.registerIcon(Reference.MOD_ID + ":WoodMultiBlock/VR");
		vl = ir.registerIcon(Reference.MOD_ID + ":WoodMultiBlock/VL");
		hb = ir.registerIcon(Reference.MOD_ID + ":WoodMultiBlock/HB");
		ht = ir.registerIcon(Reference.MOD_ID + ":WoodMultiBlock/HT");
		tlc = ir.registerIcon(Reference.MOD_ID + ":WoodMultiBlock/TLC");
		trc = ir.registerIcon(Reference.MOD_ID + ":WoodMultiBlock/TRC");
		blc = ir.registerIcon(Reference.MOD_ID + ":WoodMultiBlock/BLC");
		brc = ir.registerIcon(Reference.MOD_ID + ":WoodMultiBlock/BRC");
	}
	
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
		System.out.println("I have no idea what i'm doing");
		isMultiblock();
	}
	
	public int tickRate(World world) {
		return 10;
	}
	
	public boolean isMultiblock() {
		System.out.println("Cake");
		if (world.getBlock(x, y + 1, z).getClass().getSuperclass() == this.getClass()) {
			System.out.println("I Like Trains");
		}
		
		return false;
	}
	
	public void onBlockAdded(World world, int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.world = world;
	}
	
	/*public TileEntity createTileEntity(World world, int metadata) {
		return new TEStoneMultiBlock();
	}*/
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata) {
		switch (metadata) {
			case 0:
				return normal;
			case 1:
				return (side == 0 ? tlc : (side == 2 || side == 4 ? blc : (side == 1 ? brc : trc)));
			case 2:
				return (side == 3 ? tlc : (side == 2 ? brc : (side == 5 || side == 1 ? blc : trc)));
			case 3:
				return (side == 0 || side == 3 ? blc : (side == 1 || side == 2 ? trc : (side == 5 ? tlc : brc)));
			case 4:
				return (side == 1 || side == 4 || side == 2 ? tlc : brc);
			case 5:
				return (side == 0 ? vr : (side == 1 ? vl : (side == 4 ? hb : ht)));
			case 6:
				return (side == 2 ? hb : (side == 1 ? hb : ht));
			case 7:
				return (side == 0 ? vl : (side == 4 ? ht : (side == 1 ? vr : hb)));
			case 8:
				return (side == 3 || side == 0 ? hb : ht);
			case 9:
				return (side == 4 || side == 2 ? vr : vl);
			case 10:
				return (side == 2 || side == 4 ? vl : vr);
			default:
				return error;
		}
	}
}
