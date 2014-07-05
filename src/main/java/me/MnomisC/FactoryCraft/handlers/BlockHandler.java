package me.MnomisC.FactoryCraft.handlers;

import cpw.mods.fml.common.registry.GameRegistry;
import me.MnomisC.FactoryCraft.Blocks.BlockChimney;
import me.MnomisC.FactoryCraft.Blocks.StoneMachineFrame;
import me.MnomisC.FactoryCraft.Blocks.WoodMachineFrame;
import me.MnomisC.FactoryCraft.FactoryCraft;
import net.minecraft.block.Block;

public class BlockHandler {
	
	public static Block woodMachineFrame = new WoodMachineFrame("WoodMachineFrame");
	public static Block chimney = new BlockChimney("Chimney").setBlockName("Chimney");
	public static Block stoneMachineFrame = new StoneMachineFrame("StoneMachineFrame");
	//public static Block ironMachineFrame = new IronMachineFrame("IronMachineFrame");
	//public static Block steelMachineFrame = new SteelMachineFrame("SteelMachineFrame");
	//public static Block lime = new BlockLime("Lime").setBlockName("Lime");
	
	//Fluids//
	
	
	//Lime Tree//
	//public static Block limeLeaves = new LimeLeaves("LimeLeaves");
	//public static Block limeLog = new LimeLog("LimeLog");
	//public static Block limeSapling = new LimeSapling("LimeSapling");
	
	public static void init() {
		GameRegistry.registerBlock(woodMachineFrame, "WoodMachineFrame");
		GameRegistry.registerBlock(chimney, "Chimney");
//		GameRegistry.registerBlock(limeLeaves, "LimeLeaves");
//		GameRegistry.registerBlock(limeLog, "LimeLog");
//		GameRegistry.registerBlock(limeSapling, "LimeSapling");
		GameRegistry.registerBlock(stoneMachineFrame, "StoneMachineFrame");
//		GameRegistry.registerBlock(ironMachineFrame, "IronMachineFrame");
//		GameRegistry.registerBlock(steelMachineFrame, "SteelMachineFrame");
//		GameRegistry.registerBlock(lime, "Lime");
	}
}