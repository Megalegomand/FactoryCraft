package me.MnomisC.FactoryCraft.handlers;

import cpw.mods.fml.common.registry.GameRegistry;
import me.MnomisC.FactoryCraft.TileEntity.TEChimney;

public class TileEntityHandler {
	
	public static TEChimney teChimney = new TEChimney();
	//public static TileEntityLime teLime = new TileEntityLime();
	//public static TileEntityLimeSapling teLimeSapling = new TileEntityLimeSapling();
	
	public static void init() {
		GameRegistry.registerTileEntity(TEChimney.class, "teChimney");
		//GameRegistry.registerTileEntity(TileEntityLime.class, "teLime");
		//GameRegistry.registerTileEntity(TileEntityWoodMultiblock.class, "teMultiblock");
	}
}
