package com.simtimzero.minexp.init;


        import com.simtimzero.minexp.block.ReinforcedFurnace;
        import cpw.mods.fml.common.registry.GameRegistry;
        import net.minecraft.init.Blocks;
        import net.minecraft.init.Items;
        import net.minecraft.item.ItemStack;
        import net.minecraftforge.oredict.ShapedOreRecipe;
        import net.minecraftforge.oredict.ShapelessOreRecipe;

public class Recipes
{
    public static void init()
    {
        // GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.Leaf), " s ", "sss", " s ", 's', "stickWood"));
        // GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModBlocks.trollBlock), "stickWood", "stickWood", "stickWood", "stickWood", "stickWood", "stickWood", "stickWood", "stickWood", new ItemStack(ModItems.Leaf)));
        GameRegistry.addRecipe(new ItemStack(ModItems.Leaf), " s ", "sss", " s ", 's', new ItemStack(Items.stick));
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.trollBlock), new ItemStack(ModItems.Leaf), new ItemStack(Items.stick), new ItemStack(Items.stick), new ItemStack(Items.stick), new ItemStack(Items.stick), new ItemStack(Items.stick), new ItemStack(Items.stick), new ItemStack(Items.stick), new ItemStack(Items.stick));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.reinforcedFurnace), "iii", "ifi", "iii", 'i', "ingotIron", 'f', Blocks.furnace));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.glowstoneChalk, 8), new ItemStack(Items.glowstone_dust), new ItemStack(Items.flint), new ItemStack(Items.paper), new ItemStack(Items.clay_ball));

    }
}
