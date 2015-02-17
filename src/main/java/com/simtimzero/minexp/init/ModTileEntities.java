package com.simtimzero.minexp.init;



import com.simtimzero.minexp.reference.Names;
import com.simtimzero.minexp.tileentities.*;
import cpw.mods.fml.common.registry.GameRegistry;


public class ModTileEntities
{
    public static void init()
    {
   //     GameRegistry.registerTileEntityWithAlternatives(TileEntityReinforcedFurnace.class, Names.Blocks.RFURNACE, "tile." + Names.Blocks.RFURNACE);
        GameRegistry.registerTileEntity(TileEntityReinforcedFurnace.class, "TileEntityReinforcedFurnace");
    }

}
