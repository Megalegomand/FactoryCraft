package me.MnomisC.FactoryCraft.TileEntity;

import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntities {
	
	public static TEChimney teChimney = new TEChimney();
	//public static TELime teLime = new TileEntityLime();
	//public static TELimeSapling teLimeSapling = new TileEntityLimeSapling();
	
	public static void init() {
		GameRegistry.registerTileEntity(TEChimney.class, "teChimney");
		//GameRegistry.registerTileEntity(TileEntityLime.class, "teLime");
		//GameRegistry.registerTileEntity(TileEntityWoodMultiblock.class, "teMultiblock");
	}
}
