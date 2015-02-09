package com.simtimzero.minexp.init;


import com.simtimzero.minexp.block.BlockMinexp;
import com.simtimzero.minexp.block.BlockTrollFace;
import com.simtimzero.minexp.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks
{
    public static final BlockMinexp trollBlock = new BlockTrollFace();

    public static void init()
    {
        GameRegistry.registerBlock(trollBlock, "trollBlock");
    }
}
