package com.simtimzero.minexp.init;

import com.simtimzero.minexp.item.ItemLeaf;
import com.simtimzero.minexp.item.ItemMinexp;
import com.simtimzero.minexp.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;


@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems
{
    public static final ItemMinexp Leaf = new ItemLeaf();

    public static void init()
    {
        GameRegistry.registerItem(Leaf, "TrollLeaf");
    }
}
