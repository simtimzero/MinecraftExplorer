package com.simtimzero.minexp.init;


import com.simtimzero.minexp.block.*;
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
    public static final BlockMinexp glowstoneWire = new BlockGlowstoneWire();
    public static final BlockMinexp reinforcedFurnaceGold = (BlockMinexp) new ReinforcedFurnaceGold(false).setBlockName("reinforcedFurnaceGold").setCreativeTab(CreativeTabMinexp.MINEXP_TAB);
    public static final BlockMinexp reinforcedFurnaceActiveGold = new ReinforcedFurnaceGold(true);

    public static void init()
    {


        GameRegistry.registerBlock(trollBlock, "trollBlock");
        GameRegistry.registerBlock(reinforcedFurnace, "reinforcedFurnace");
        GameRegistry.registerBlock(reinforcedFurnaceActive, "reinforcedFurnaceActive");
        GameRegistry.registerBlock(glowstoneWire, "glowstoneWire");
        GameRegistry.registerBlock(reinforcedFurnaceGold, "reinforcedFurnaceGold");
        GameRegistry.registerBlock(reinforcedFurnaceActiveGold, "reinforcedFurnaceActiveGold");
    }
}
