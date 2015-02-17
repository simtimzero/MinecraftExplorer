package com.simtimzero.minexp.init;


import com.simtimzero.minexp.block.BlockMinexp;
import com.simtimzero.minexp.block.BlockTrollFace;
import com.simtimzero.minexp.block.ReinforcedFurnace;
import com.simtimzero.minexp.creativetab.CreativeTabMinexp;
import com.simtimzero.minexp.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks
{
    public static final BlockMinexp trollBlock = new BlockTrollFace();
    public static final BlockMinexp reinforcedFurnace = (BlockMinexp) new ReinforcedFurnace(false).setBlockName("reinforcedFurnace").setCreativeTab(CreativeTabMinexp.MINEXP_TAB);
    public static final BlockMinexp reinforcedFurnaceActive = new ReinforcedFurnace(true);

    public static void init()
    {


        GameRegistry.registerBlock(trollBlock, "trollBlock");
        GameRegistry.registerBlock(reinforcedFurnace, "reinforcedFurnace");
        GameRegistry.registerBlock(reinforcedFurnaceActive, "reinforcedFurnaceActive");
    }
}
