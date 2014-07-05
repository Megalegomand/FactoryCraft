package me.MnomisC.FactoryCraft.handlers;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import me.MnomisC.FactoryCraft.Reference.ConfigValues;
import me.MnomisC.FactoryCraft.Reference.Reference;
import me.MnomisC.FactoryCraft.Utility.Log;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigHandler {

    public static Configuration config;

    public static void init(File f) {
        if (config == null) {
            config = new Configuration(f);
            loadConfig();
        }
    }

    @SubscribeEvent
    public void onConfigurationChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        Log.info(event.modID + " : " + Reference.MOD_ID + " : " + event.modID.equalsIgnoreCase(Reference.MOD_ID));
        if (event.modID.equalsIgnoreCase(Reference.MOD_ID)) {
            loadConfig();
        }
    }

    private static void loadConfig() {
        ConfigValues.debug = config.getBoolean("debugMode", Configuration.CATEGORY_GENERAL, false, "Debug mode");

        if (config.hasChanged()) {
            config.save();
        }
    }
}
