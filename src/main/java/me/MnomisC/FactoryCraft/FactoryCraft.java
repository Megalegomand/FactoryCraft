package me.MnomisC.FactoryCraft;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import me.MnomisC.FactoryCraft.Reference.Reference;
import me.MnomisC.FactoryCraft.Utility.Log;
import me.MnomisC.FactoryCraft.handlers.ConfigHandler;
import me.MnomisC.FactoryCraft.proxy.IProxy;
import net.minecraft.creativetab.CreativeTabs;

@Mod(modid = Reference.MOD_ID, name=Reference.NAME, version=Reference.VERSION, guiFactory = Reference.GUI_FACTORY)
public class FactoryCraft {

    @Mod.Instance(Reference.MOD_ID)
    public static FactoryCraft instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.SERVER_PROXY)
    public static IProxy proxy;

    public static CreativeTabs tabFactoryCraft = new TabFactoryCraft(CreativeTabs.getNextID(), "FactoryCraft");

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        Log.info("Pre initialization started!");
        ConfigHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigHandler());
        Log.info("Pre initialization complete!");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        Log.info("Initialization started!");
        Log.info("Initialization complete!");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        Log.info("Post initialization started!");
        Log.info("Post initialization complete!");
    }
}
