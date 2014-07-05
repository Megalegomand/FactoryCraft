package me.MnomisC.FactoryCraft;

import me.MnomisC.FactoryCraft.handlers.BlockHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by Simon on 05-07-2014.
 */

public class TabFactoryCraft extends CreativeTabs {

    public TabFactoryCraft(int par1, String par2Str) {
        super(par1, par2Str);
    }

    @Override
    public Item getTabIconItem() {
        return BlockHandler.chimney.getItem(null, 0, 0, 0);
    }

}
