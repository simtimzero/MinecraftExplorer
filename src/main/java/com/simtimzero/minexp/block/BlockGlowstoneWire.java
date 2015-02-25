package com.simtimzero.minexp.block;


import com.simtimzero.minexp.init.ModBlocks;
import com.simtimzero.minexp.reference.Reference;
import com.simtimzero.minexp.reference.RenderIds;
import com.simtimzero.minexp.tileentities.TileEntityGlowstoneDust;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Direction;
import net.minecraft.util.IIcon;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BlockGlowstoneWire extends BlockMinexp
{
    @SideOnly(Side.CLIENT)
    private static IIcon cross;
    @SideOnly(Side.CLIENT)
    private static IIcon line;
    @SideOnly(Side.CLIENT)
    private static IIcon cross_overlay;
    @SideOnly(Side.CLIENT)
    private static IIcon line_overlay;
    private Set arrayHashSetVar = new HashSet();
    private boolean boolIsPowerOn = true;



    public BlockGlowstoneWire()
    {
        super(Material.circuits);
        this.setLightLevel(1.0f);
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.0625f, 1.0f);

/**
        if (sideDown == true)
        {
            //setBlockBounds(minX, minY, minZ, maxX, maxY, maxZ);
            this.setBlockBounds(0.0f,0.0f,0.0f,1.0f,0.0625f,1.0f);
        }
        else if (sideUp == true)
        {
            this.setBlockBounds(0.0f,.9375f,0.0f,1.0f,1.0f,1.0f);
        }
        else if (sideSouth == true)
        {
            this.setBlockBounds(0.0f,0.0f,0.0f,1.0f,0.0625f,1.0f);
        }
        else if (sideNorth == true)
        {
            this.setBlockBounds(0.0f,0.0f,0.0f,1.0f,0.0625f,1.0f);
        }
        else if (sideEast == true)
        {
            this.setBlockBounds(0.0f,0.0f,0.0f,1.0f,0.0625f,1.0f);
        }
        else if (sideWest == true)
        {
            this.setBlockBounds(0.0f,0.0f,0.0f,1.0f,0.0625f,1.0f);
        }
        else
        {
            this.setBlockBounds(0.0f,0.0f,0.0f,1.0f,0.0625f,1.0f);
        }
        ModBlocks.glowstoneWire.setBlockBounds(x,y,z,x1,y1,z1);
*/













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

    public int getSide(World world, int x, int y, int z)
    {
        boolean sideUp = false;
        boolean sideDown = false;
        boolean sideSouth = false;
        boolean sideNorth = false;
        boolean sideEast = false;
        boolean sideWest = false;

        Block block = world.getBlock(x, y - 1, z);
        Block block1 = world.getBlock(x, y + 1, z);
        Block block2 = world.getBlock(x, y,z + 1);
        Block block3 = world.getBlock(x, y, z - 1);
        Block block4 = world.getBlock(x + 1, y, z);
        Block block5 = world.getBlock(x - 1, y, z);
        if (block.isSideSolid(world, x, y, z, ForgeDirection.UP))
        {
            sideUp = true;
        }
        else if (block1.isSideSolid(world, x, y, z, ForgeDirection.DOWN))
        {
            sideDown = true;
        }
        else if (block2.isSideSolid(world, x, y, z, ForgeDirection.SOUTH))
        {
            sideSouth = true;
        }
        else if (block3.isSideSolid(world,x,y,z, ForgeDirection.NORTH))
        {
            sideNorth = true;
        }
        else if (block4.isSideSolid(world,x,y,z, ForgeDirection.EAST))
        {
            sideEast = true;
        }
        else if (block5.isSideSolid(world,x,y,z, ForgeDirection.WEST))
        {
            sideWest = true;
        }
        //Quick Ref. 0 = up, 1 = down, 2 = south, 3 = north, 4 = west, 5 = east.
        if (sideUp == true)
        {
            return 0;
        }
        else if (sideDown == true)
        {
            return 1;
        }
        else if (sideSouth == true)
        {
            return 3;
        }
        else if (sideNorth == true)
        {
            return 2;
        }
        else if (sideWest == true)
        {
            return 4;
        }
        else if (sideEast == true)
        {
            return 5;
        }
        else return 1;

    }
    public int getRenderType()
    {
        return RenderIds.glowstoneWire;
    }
    @SideOnly(Side.CLIENT)
    public int colorMultiplier(IBlockAccess param1, int x, int y, int z)
    {
        return 8388608;
    }
    public boolean canPlaceBlockAt(World world, int x, int y, int z)
    {
        //return true;
        Block block = world.getBlock(x, y - 1, z);
        Block block1 = world.getBlock(x, y + 1, z);
        Block block2 = world.getBlock(x, y,z + 1);
        Block block3 = world.getBlock(x, y, z - 1);
        Block block4 = world.getBlock(x + 1, y, z);
        Block block5 = world.getBlock(x - 1, y, z);
        if (block.isSideSolid(world, x, y, z, ForgeDirection.UP))
        {
            return true;
        }
        else if (block1.isSideSolid(world, x, y, z, ForgeDirection.DOWN))
        {
            return true;
        }
        else if (block2.isSideSolid(world, x, y, z, ForgeDirection.SOUTH))
        {
            return true;
        }
        else if (block3.isSideSolid(world,x,y,z, ForgeDirection.NORTH))
        {
            return true;
        }
        else if (block4.isSideSolid(world,x,y,z, ForgeDirection.EAST))
        {
            return true;
        }
        else if (block5.isSideSolid(world,x,y,z, ForgeDirection.WEST))
        {
            return true;
        }
        else
        {
            return false;
        }




        //block.isSideSolid(world, x, y, z, ForgeDirection.UP)
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
    //Deals with Redstone Signals
    /**
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
            this.arrayHashSetVar.add(new ChunkPosition(x, y, z));
            this.arrayHashSetVar.add(new ChunkPosition(x - 1, y, z));
            this.arrayHashSetVar.add(new ChunkPosition(x + 1, y, z));
            this.arrayHashSetVar.add(new ChunkPosition(x, y - 1, z));
            this.arrayHashSetVar.add(new ChunkPosition(x, y + 1, z));
            this.arrayHashSetVar.add(new ChunkPosition(x, y, z - 1));
            this.arrayHashSetVar.add(new ChunkPosition(x, y, z + 1));
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
    */
    private void getPlacedCordsTriggerNotifyOfChange(World world, int x, int y, int z)
    {
        //this.func_150175_a(world, x, y, z, x, y, z);
        ArrayList arraylist = new ArrayList(this.arrayHashSetVar);
        this.arrayHashSetVar.clear();

        for (int l = 0; l < arraylist.size(); ++l)
        {
            ChunkPosition chunkposition = (ChunkPosition)arraylist.get(l);
            world.notifyBlocksOfNeighborChange(chunkposition.chunkPosX, chunkposition.chunkPosY, chunkposition.chunkPosZ, this);
        }
    }
    public void onBlockAdded(World world, int x, int y, int z)
    {
        super.onBlockAdded(world, x, y, z);

/**
        boolean sideUp = false;
        boolean sideDown = false;
        boolean sideSouth = false;
        boolean sideNorth = false;
        boolean sideEast = false;
        boolean sideWest = false;

        Block block = world.getBlock(x, y - 1, z);
        Block block1 = world.getBlock(x, y + 1, z);
        Block block2 = world.getBlock(x, y,z + 1);
        Block block3 = world.getBlock(x, y, z - 1);
        Block block4 = world.getBlock(x + 1, y, z);
        Block block5 = world.getBlock(x - 1, y, z);
        if (block.isSideSolid(world, x, y, z, ForgeDirection.UP))
        {
            sideUp = true;
        }
        else if (block1.isSideSolid(world, x, y, z, ForgeDirection.DOWN))
        {
            sideDown = true;
        }
        else if (block2.isSideSolid(world, x, y, z, ForgeDirection.SOUTH))
        {
            sideSouth = true;
        }
        else if (block3.isSideSolid(world,x,y,z, ForgeDirection.NORTH))
        {
            sideNorth = true;
        }
        else if (block4.isSideSolid(world,x,y,z, ForgeDirection.EAST))
        {
            sideEast = true;
        }
        else if (block5.isSideSolid(world,x,y,z, ForgeDirection.WEST))
        {
            sideWest = true;
        }


        if (sideUp == true)
        {
            //setBlockBounds(minX, minY, minZ, maxX, maxY, maxZ);
            this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.0625f, 1.0f);
        }
        else if (sideDown == true)
        {
            this.setBlockBounds(0.0f, .9375f, 0.0f, 1.0f, 1.0f, 1.0f);
        }
        else if (sideNorth == true)
        {
            this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0625f);
        }
        else if (sideSouth == true)
        {
            this.setBlockBounds(0.0f, 0.0f,0.9375f, 1.0f, 1.0f, 1.0f);
        }
        else if (sideWest == true)
        {
            this.setBlockBounds(0.0f, 0.0f, 0.0f, 0.0625f, 1.0f, 1.0f);
        }
        else if (sideEast == true)
        {
            this.setBlockBounds(0.9375f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        }
        else
        {
            this.setBlockBounds(0.0f, 0.0f, 0.0f,1.0f,0.0625f,1.0f);
        }
        ModBlocks.glowstoneWire.setBlockBounds(x,y,z,x1,y1,z1);
        */

        if (!world.isRemote)
        {
            this.getPlacedCordsTriggerNotifyOfChange(world, x, y, z);
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
            this.getPlacedCordsTriggerNotifyOfChange(world, x, y, z);
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
                this.getPlacedCordsTriggerNotifyOfChange(world, x, y, z);
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

    //More Stuff pertaining to Redstone
    /**
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
     */
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
    public Item getItem(World world, int x, int y, int z)
    {
        return Items.glowstone_dust;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.cross = p_149651_1_.registerIcon(Reference.MOD_ID + ":glowstone_dust_cross.png");
        this.line = p_149651_1_.registerIcon(Reference.MOD_ID + ":glowstone_dust_line.png");
        this.cross_overlay = p_149651_1_.registerIcon(Reference.MOD_ID + ":glowstone_dust_cross_overlay.png");
        this.line_overlay = p_149651_1_.registerIcon(Reference.MOD_ID + ":glowstone_dust_line_overlay.png");
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
