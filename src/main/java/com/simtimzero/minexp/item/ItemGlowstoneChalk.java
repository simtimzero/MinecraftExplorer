package com.simtimzero.minexp.item;

import com.simtimzero.minexp.init.ModBlocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by Seth on 2/18/2015.
 */
public class ItemGlowstoneChalk extends ItemMinexp
{
    public ItemGlowstoneChalk()
    {
        super();
        this.setUnlocalizedName("glowstonechalk");

    }


    public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
        if (p_77648_3_.getBlock(p_77648_4_, p_77648_5_, p_77648_6_) != Blocks.snow_layer)
        {
            if (p_77648_7_ == 0)
            {
                --p_77648_5_;
            }

            if (p_77648_7_ == 1)
            {
                ++p_77648_5_;
            }

            if (p_77648_7_ == 2)
            {
                --p_77648_6_;
            }

            if (p_77648_7_ == 3)
            {
                ++p_77648_6_;
            }

            if (p_77648_7_ == 4)
            {
                --p_77648_4_;
            }

            if (p_77648_7_ == 5)
            {
                ++p_77648_4_;
            }

            if (!p_77648_3_.isAirBlock(p_77648_4_, p_77648_5_, p_77648_6_))
            {
                return false;
            }
        }

        if (!p_77648_2_.canPlayerEdit(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_))
        {
            return false;
        }
        else
        {
            if (ModBlocks.glowstoneWire.canPlaceBlockAt(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_))
            {
                --p_77648_1_.stackSize;
                p_77648_3_.setBlock(p_77648_4_, p_77648_5_, p_77648_6_, ModBlocks.glowstoneWire);
            }

            return true;
        }
    }
}
