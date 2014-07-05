package me.MnomisC.FactoryCraft.Utility;

import cpw.mods.fml.common.FMLLog;
import me.MnomisC.FactoryCraft.Reference.Reference;

import org.apache.logging.log4j.Level;

/**
 * Created by Simon on 04-07-2014.
 */
public class Log {
    public static void log(Level l, Object obj) {
        FMLLog.log(Reference.NAME, l, String.valueOf(obj));
    }

    public static void info(String s) { log(Level.INFO, s); }
    public static void error(String s) { log(Level.ERROR, s); }
    public static void debug(String s) { log(Level.DEBUG, s); }
    public static void fatal(String s) { log(Level.FATAL, "Something went completely wrong. Please contact the mod authors and show this message --> " + s); }
}
