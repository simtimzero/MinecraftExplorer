package com.simtimzero.minexp.block;


import com.simtimzero.minexp.init.ModBlocks;
import com.simtimzero.minexp.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Direction;
import net.minecraft.util.IIcon;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BlockGlowstoneWireTest extends BlockMinexp
{
    @SideOnly(Side.CLIENT)
    private static IIcon cross;
    @SideOnly(Side.CLIENT)
    private static IIcon line;
    @SideOnly(Side.CLIENT)
    private static IIcon cross_overlay;
    @SideOnly(Side.CLIENT)
    private static IIcon line_overlay;
    private Set field_150179_b = new HashSet();
    private boolean boolIsPowerOn = true;


    public BlockGlowstoneWireTest()
    {
        super(Material.circuits);
        this.setLightLevel(1.0f);
        this.setBlockBounds(0.0f,0.0f,0.0f,1.0f,0.0625f,1.0f);

    }
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
    {
        return null;
    }
    public boolean isOpaqueCube()
    {
        return false;
    }
    public boolean renderAsNormalBlock()
    {
        return true;
    }
    //public int getRenderType()
    //{
    //    return 5;
    //}
    @SideOnly(Side.CLIENT)
    public int colorMultiplier(IBlockAccess param1, int x, int y, int z)
    {
        return 8388608;
    }
    public boolean canPlaceBlockAt(World world, int x, int y, int z)
    {
        return true;
        //Block block = p_147466_0_.getBlock(p_147466_1_, p_147466_2_, p_147466_3_);
        //block.isSideSolid(p_147466_0_, p_147466_1_, p_147466_2_, p_147466_3_, ForgeDirection.UP)
    }
    private void getBlockData(World world, int x, int y, int z)
    {
        if (world.getBlock(x, y, z) == this)
        {
            world.notifyBlocksOfNeighborChange(x, y, z, this);
            world.notifyBlocksOfNeighborChange(x - 1, y, z, this);
            world.notifyBlocksOfNeighborChange(x + 1, y, z, this);
            world.notifyBlocksOfNeighborChange(x, y, z - 1, this);
            world.notifyBlocksOfNeighborChange(x, y, z + 1, this);
            world.notifyBlocksOfNeighborChange(x, y - 1, z, this);
            world.notifyBlocksOfNeighborChange(x, y + 1, z, this);
        }
    }
    private void func_150175_a(World world, int x, int y, int z, int x2, int y2, int z2)
    {
        int k1 = world.getBlockMetadata(x, y, z);
        byte b0 = 0;
        int i3 = this.func_150178_a(world, x2, y2, z2, b0);
        this.boolIsPowerOn = false;
        int l1 = world.getStrongestIndirectPower(x, y, z);
        this.boolIsPowerOn = true;

        if (l1 > 0 && l1 > i3 - 1)
        {
            i3 = l1;
        }

        int i2 = 0;

        for (int j2 = 0; j2 < 4; ++j2)
        {
            int k2 = x;
            int l2 = z;

            if (j2 == 0)
            {
                k2 = x - 1;
            }

            if (j2 == 1)
            {
                ++k2;
            }

            if (j2 == 2)
            {
                l2 = z - 1;
            }

            if (j2 == 3)
            {
                ++l2;
            }

            if (k2 != x2 || l2 != z2)
            {
                i2 = this.func_150178_a(world, k2, y, l2, i2);
            }

            if (world.getBlock(k2, y, l2).isNormalCube() && !world.getBlock(x, y + 1, z).isNormalCube())
            {
                if ((k2 != x2 || l2 != z2) && y >= y2)
                {
                    i2 = this.func_150178_a(world, k2, y + 1, l2, i2);
                }
            }
            else if (!world.getBlock(k2, y, l2).isNormalCube() && (k2 != x2 || l2 != z2) && y <= y2)
            {
                i2 = this.func_150178_a(world, k2, y - 1, l2, i2);
            }
        }

        if (i2 > i3)
        {
            i3 = i2 - 1;
        }
        else if (i3 > 0)
        {
            --i3;
        }
        else
        {
            i3 = 0;
        }

        if (l1 > i3 - 1)
        {
            i3 = l1;
        }

        if (k1 != i3)
        {
            world.setBlockMetadataWithNotify(x, y, z, i3, 2);
            this.field_150179_b.add(new ChunkPosition(x, y, z));
            this.field_150179_b.add(new ChunkPosition(x - 1, y, z));
            this.field_150179_b.add(new ChunkPosition(x + 1, y, z));
            this.field_150179_b.add(new ChunkPosition(x, y - 1, z));
            this.field_150179_b.add(new ChunkPosition(x, y + 1, z));
            this.field_150179_b.add(new ChunkPosition(x, y, z - 1));
            this.field_150179_b.add(new ChunkPosition(x, y, z + 1));
        }
    }
    private int func_150178_a(World world, int x, int y, int z, int meta)
    {
        if (world.getBlock(x, y, z) != this)
        {
            return meta;
        }
        else
        {
            int i1 = world.getBlockMetadata(x, y, z);
            return i1 > meta ? i1 : meta;
        }
    }
    private void func_150177_e(World world, int x, int y, int z)
    {
        this.func_150175_a(world, x, y, z, x, y, z);
        ArrayList arraylist = new ArrayList(this.field_150179_b);
        this.field_150179_b.clear();

        for (int l = 0; l < arraylist.size(); ++l)
        {
            ChunkPosition chunkposition = (ChunkPosition)arraylist.get(l);
            world.notifyBlocksOfNeighborChange(chunkposition.chunkPosX, chunkposition.chunkPosY, chunkposition.chunkPosZ, this);
        }
    }
    public void onBlockAdded(World world, int x, int y, int z)
    {
        super.onBlockAdded(world, x, y, z);

        if (!world.isRemote)
        {
            this.func_150177_e(world, x, y, z);
            world.notifyBlocksOfNeighborChange(x, y + 1, z, this);
            world.notifyBlocksOfNeighborChange(x, y - 1, z, this);
            world.notifyBlocksOfNeighborChange(x,y,z +1, this);
            world.notifyBlocksOfNeighborChange(x,y,z -1, this);
            world.notifyBlocksOfNeighborChange(x+1,y,z, this);
            world.notifyBlocksOfNeighborChange(x-1,y,z, this);

            this.getBlockData(world, x - 1, y, z);
            this.getBlockData(world, x + 1, y, z);
            this.getBlockData(world, x, y, z - 1);
            this.getBlockData(world, x, y, z + 1);


            if (world.getBlock(x - 1, y, z).isNormalCube())
            {
                this.getBlockData(world, x - 1, y + 1, z);
            }
            else
            {
                this.getBlockData(world, x - 1, y - 1, z);
            }

            if (world.getBlock(x + 1, y, z).isNormalCube())
            {
                this.getBlockData(world, x + 1, y + 1, z);
            }
            else
            {
                this.getBlockData(world, x + 1, y - 1, z);
            }

            if (world.getBlock(x, y, z - 1).isNormalCube())
            {
                this.getBlockData(world, x, y + 1, z - 1);
            }
            else
            {
                this.getBlockData(world, x, y - 1, z - 1);
            }

            if (world.getBlock(x, y, z + 1).isNormalCube())
            {
                this.getBlockData(world, x, y + 1, z + 1);
            }
            else
            {
                this.getBlockData(world, x, y - 1, z + 1);
            }

        }
    }
    public void breakBlock(World world, int x, int y, int z, Block block, int p_149749_6_)
    {
        super.breakBlock(world, x, y, z, block, p_149749_6_);

        if (!world.isRemote)
        {
            world.notifyBlocksOfNeighborChange(x, y + 1, z, this);
            world.notifyBlocksOfNeighborChange(x, y - 1, z, this);
            world.notifyBlocksOfNeighborChange(x + 1, y, z, this);
            world.notifyBlocksOfNeighborChange(x - 1, y, z, this);
            world.notifyBlocksOfNeighborChange(x, y, z + 1, this);
            world.notifyBlocksOfNeighborChange(x, y, z - 1, this);
            this.func_150177_e(world, x, y, z);
            this.getBlockData(world, x - 1, y, z);
            this.getBlockData(world, x + 1, y, z);
            this.getBlockData(world, x, y, z - 1);
            this.getBlockData(world, x, y, z + 1);

            if (world.getBlock(x - 1, y, z).isNormalCube())
            {
                this.getBlockData(world, x - 1, y + 1, z);
            }
            else
            {
                this.getBlockData(world, x - 1, y - 1, z);
            }

            if (world.getBlock(x + 1, y, z).isNormalCube())
            {
                this.getBlockData(world, x + 1, y + 1, z);
            }
            else
            {
                this.getBlockData(world, x + 1, y - 1, z);
            }

            if (world.getBlock(x, y, z - 1).isNormalCube())
            {
                this.getBlockData(world, x, y + 1, z - 1);
            }
            else
            {
                this.getBlockData(world, x, y - 1, z - 1);
            }

            if (world.getBlock(x, y, z + 1).isNormalCube())
            {
                this.getBlockData(world, x, y + 1, z + 1);
            }
            else
            {
                this.getBlockData(world, x, y - 1, z + 1);
            }
        }
    }
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
    {
        if (!world.isRemote)
        {
            boolean flag = this.canPlaceBlockAt(world, x, y, z);

            if (flag)
            {
                this.func_150177_e(world, x, y, z);
            }
            else
            {
                this.dropBlockAsItem(world, x, y, z, 0, 0);
                world.setBlockToAir(x, y, z);
            }

            super.onNeighborBlockChange(world, x, y, z, block);
        }
    }
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return null;
    }
    public int isProvidingStrongPower(IBlockAccess p_149748_1_, int p_149748_2_, int p_149748_3_, int p_149748_4_, int p_149748_5_)
    {
        return !this.boolIsPowerOn ? 0 : this.isProvidingWeakPower(p_149748_1_, p_149748_2_, p_149748_3_, p_149748_4_, p_149748_5_);
    }

    public int isProvidingWeakPower(IBlockAccess blockAccess, int x, int y, int z, int rPower)
    {
        if (!this.boolIsPowerOn)
        {
            return 0;
        }
        else
        {
            int i1 = blockAccess.getBlockMetadata(x, y, z);

            if (i1 == 0)
            {
                return 0;
            }
            else if (rPower == 1)
            {
                return i1;
            }
            else
            {
                boolean flag = checkBlockProvidesPower(blockAccess, x - 1, y, z, 1) || !blockAccess.getBlock(x - 1, y, z).isNormalCube() && checkBlockProvidesPower(blockAccess, x - 1, y - 1, z, -1);
                boolean flag1 = checkBlockProvidesPower(blockAccess, x + 1, y, z, 3) || !blockAccess.getBlock(x + 1, y, z).isNormalCube() && checkBlockProvidesPower(blockAccess, x + 1, y - 1, z, -1);
                boolean flag2 = checkBlockProvidesPower(blockAccess, x, y, z - 1, 2) || !blockAccess.getBlock(x, y, z - 1).isNormalCube() && checkBlockProvidesPower(blockAccess, x, y - 1, z - 1, -1);
                boolean flag3 = checkBlockProvidesPower(blockAccess, x, y, z + 1, 0) || !blockAccess.getBlock(x, y, z + 1).isNormalCube() && checkBlockProvidesPower(blockAccess, x, y - 1, z + 1, -1);

                if (!blockAccess.getBlock(x, y + 1, z).isNormalCube())
                {
                    if (blockAccess.getBlock(x - 1, y, z).isNormalCube() && checkBlockProvidesPower(blockAccess, x - 1, y + 1, z, -1))
                    {
                        flag = true;
                    }

                    if (blockAccess.getBlock(x + 1, y, z).isNormalCube() && checkBlockProvidesPower(blockAccess, x + 1, y + 1, z, -1))
                    {
                        flag1 = true;
                    }

                    if (blockAccess.getBlock(x, y, z - 1).isNormalCube() && checkBlockProvidesPower(blockAccess, x, y + 1, z - 1, -1))
                    {
                        flag2 = true;
                    }

                    if (blockAccess.getBlock(x, y, z + 1).isNormalCube() && checkBlockProvidesPower(blockAccess, x, y + 1, z + 1, -1))
                    {
                        flag3 = true;
                    }
                }

                return !flag2 && !flag1 && !flag && !flag3 && rPower >= 2 && rPower <= 5 ? i1 : (rPower == 2 && flag2 && !flag && !flag1 ? i1 : (rPower == 3 && flag3 && !flag && !flag1 ? i1 : (rPower == 4 && flag && !flag2 && !flag3 ? i1 : (rPower == 5 && flag1 && !flag2 && !flag3 ? i1 : 0))));
            }
        }
    }
    public static boolean checkBlockProvidesPower(IBlockAccess blockAccess, int x, int y, int z, int meta)
    {
        if (isPowerProviderOrWire(blockAccess, x, y, z, meta))
        {
            return true;
        }
        else if (blockAccess.getBlock(x, y, z) == Blocks.powered_repeater)
        {
            int i1 = blockAccess.getBlockMetadata(x, y, z);
            return meta == (i1 & 3);
        }
        else
        {
            return false;
        }
    }
    public static boolean isPowerProviderOrWire(IBlockAccess blockAccess, int x, int y, int z, int meta)
    {
        Block block = blockAccess.getBlock(x, y, z);

        if (block == ModBlocks.glowstoneWire)
        {
            return true;
        }
        else if (block == Blocks.redstone_wire)
        {
            return true;
        }
        else if (!Blocks.unpowered_repeater.func_149907_e(block))
        {
            return block.canConnectRedstone(blockAccess, x, y, z, meta);
        }
        else
        {
            int i1 = blockAccess.getBlockMetadata(x, y, z);
            return meta == (i1 & 3) || meta == Direction.rotateOpposite[i1 & 3];
        }
    }
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random random)
    {
        int l = world.getBlockMetadata(x, y, z);

        if (l > 0)
        {
            double d0 = (double)x + 0.5D + ((double)random.nextFloat() - 0.5D) * 0.2D;
            double d1 = (double)((float)y + 0.0625F);
            double d2 = (double)z + 0.5D + ((double)random.nextFloat() - 0.5D) * 0.2D;
            float f = (float)l / 15.0F;
            float f1 = f * 0.6F + 0.4F;

            if (l == 0)
            {
                f1 = 0.0F;
            }

            float f2 = f * f * 0.7F - 0.5F;
            float f3 = f * f * 0.6F - 0.7F;

            if (f2 < 0.0F)
            {
                f2 = 0.0F;
            }

            if (f3 < 0.0F)
            {
                f3 = 0.0F;
            }

            world.spawnParticle("reddust", d0, d1, d2, (double) f1, (double) f2, (double) f3);
        }
    }
    @SideOnly(Side.CLIENT)
    public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_)
    {
        return Items.glowstone_dust;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.cross = p_149651_1_.registerIcon(Reference.MOD_ID + ":glowstone_dust_cross");
        this.line = p_149651_1_.registerIcon(Reference.MOD_ID + ":glowstone_dust_line");
        this.cross_overlay = p_149651_1_.registerIcon(Reference.MOD_ID + ":glowstone_dust_cross_overlay");
        this.line_overlay = p_149651_1_.registerIcon(Reference.MOD_ID + ":glowstone_dust_line_overlay");
        this.blockIcon = this.cross;
    }

//    @SideOnly(Side.CLIENT)
//    public static IIcon getGlowstoneWireIcon(String p_150173_0_)
//    {
//        return p_150173_0_.equals("cross") ? ModBlocks.glowstoneWire.cross : (p_150173_0_.equals("line") ? this.line : (p_150173_0_.equals("cross_overlay") ? this.cross_overlay : (p_150173_0_.equals("line_overlay") ? this.line_overlay : null)));
//    }



    @SideOnly(Side.CLIENT)
    public static IIcon getGlowstoneWireIcon(String tile)
    {
        if (tile == "cross")
        {
            return cross;
        }
        else if (tile =="line")
        {
            return line;
        }
        else if (tile == "cross_overlay")
        {
            return cross_overlay;
        }
        else if (tile == "line_overlay")
        {
            return line_overlay;
        }
        else
        {
            return null;
        }
    }


}
