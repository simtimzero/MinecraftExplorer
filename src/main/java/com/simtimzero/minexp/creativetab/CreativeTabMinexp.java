package com.simtimzero.minexp.creativetab;


import com.simtimzero.minexp.init.ModItems;
import com.simtimzero.minexp.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabMinexp
{
    public static final CreativeTabs MINEXP_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase())
    {
        @Override
        public Item getTabIconItem()
        {
            return ModItems.Leaf;
        }

    };
}
