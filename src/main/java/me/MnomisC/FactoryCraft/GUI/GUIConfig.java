package me.MnomisC.FactoryCraft.GUI;

import cpw.mods.fml.client.config.GuiConfig;
import me.MnomisC.FactoryCraft.Reference.Reference;
import me.MnomisC.FactoryCraft.handlers.ConfigHandler;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

/**
 * Created by Simon on 04-07-2014.
 */

public class GUIConfig extends GuiConfig {
    public GUIConfig(GuiScreen guiScreen) {
        super(
                guiScreen,
                new ConfigElement(ConfigHandler.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
                Reference.MOD_ID, false, false, GUIConfig.getAbridgedConfigPath(ConfigHandler.config.toString())
        );
    }
}
