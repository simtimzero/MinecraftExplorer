package com.simtimzero.minexp.block;


import com.simtimzero.minexp.MinecraftExplorer;
import com.simtimzero.minexp.init.ModBlocks;
import com.simtimzero.minexp.reference.GUIs;
import com.simtimzero.minexp.reference.Reference;
import com.simtimzero.minexp.tileentities.TileEntityReinforcedFurnace;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.sql.Ref;
import java.util.Random;

public class ReinforcedFurnace extends BlockMinexp implements ITileEntityProvider
{
    @SideOnly(Side.CLIENT)
    private IIcon top;
    @SideOnly(Side.CLIENT)
    private IIcon front;
    @SideOnly(Side.CLIENT)
    private IIcon side;

    private static boolean isBurning;
    private final boolean isBurning2;
    private final Random random = new Random();

    public ReinforcedFurnace(boolean isActive)
    {
     super(Material.rock);
        this.setHardness(1.5f);
        this.setResistance(1000.0f);
        this.setStepSound(soundTypePiston);
        isBurning2 = isActive;
        if(isBurning2 == true)
        {
            this.setLightLevel(1.0f);
        }
        else
        {
            this.setLightLevel(0f);
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconregister)
    {
        this.blockIcon = iconregister.registerIcon(Reference.MOD_ID + ":" + "reinforcedFurnace_front_off");
        this.front = iconregister.registerIcon(this.isBurning2 ? Reference.MOD_ID + ":reinforcedFurnace_front_on" : Reference.MOD_ID + ":reinforcedFurnace_front_off");
        this.top = iconregister.registerIcon(Reference.MOD_ID + ":reinforcedFurnace_top");
        this.side = iconregister.registerIcon(Reference.MOD_ID + ":reinforcedFurnace_side");

    }
    public IIcon getIcon(int side, int meta)
    {
        return side == 1 ? this.top : (side == 0 ? this.top : (side != meta ? this.side : this.front));

    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
        if (player.isSneaking())
        {
            return false;
        }
        else
        {
            if (!world.isRemote)
            {
                if (world.getTileEntity(x,y,z)instanceof TileEntityReinforcedFurnace)
                {
                    player.openGui(MinecraftExplorer.instance, GUIs.RFURNACE.ordinal(), world, x, y, z);
                }
            }

            return true;
        }
      //  player.openGui(MinecraftExplorer.instance, 0, world, x, y, z);
        //return true;
    }

    public Item getItemDropped(int par1, Random random, int par3)
    {
        return Item.getItemFromBlock(ModBlocks.reinforcedFurnace);
    }
    public Item getItem(World world, int par2, int par3, int par4)
    {
        return Item.getItemFromBlock(ModBlocks.reinforcedFurnace);
    }
    public TileEntity createNewTileEntity(World world, int par2)
    {
        return new TileEntityReinforcedFurnace();
    }

    @SideOnly(Side.CLIENT)
    public void onBlockAdded(World world, int x, int y, int z)
    {
        super.onBlockAdded(world,x,y,z);
        this.direction(world,x,y,z);
    }

    private void direction(World p_149930_1_, int p_149930_2_, int p_149930_3_, int p_149930_4_)
    {
        if (!p_149930_1_.isRemote)
        {
            Block block = p_149930_1_.getBlock(p_149930_2_, p_149930_3_, p_149930_4_ - 1);
            Block block1 = p_149930_1_.getBlock(p_149930_2_, p_149930_3_, p_149930_4_ + 1);
            Block block2 = p_149930_1_.getBlock(p_149930_2_ - 1, p_149930_3_, p_149930_4_);
            Block block3 = p_149930_1_.getBlock(p_149930_2_ + 1, p_149930_3_, p_149930_4_);
            byte b0 = 3;

            if (block.func_149730_j() && !block1.func_149730_j())
            {
                b0 = 3;
            }

            if (block1.func_149730_j() && !block.func_149730_j())
            {
                b0 = 2;
            }

            if (block2.func_149730_j() && !block3.func_149730_j())
            {
                b0 = 5;
            }

            if (block3.func_149730_j() && !block2.func_149730_j())
            {
                b0 = 4;
            }

            p_149930_1_.setBlockMetadataWithNotify(p_149930_2_, p_149930_3_, p_149930_4_, b0, 2);
        }
    }

    public void onBlockPlacedBy(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_)
    {
        int l = MathHelper.floor_double((double)(p_149689_5_.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0)
        {
            p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 2, 2);
        }

        if (l == 1)
        {
            p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 5, 2);
        }

        if (l == 2)
        {
            p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 3, 2);
        }

        if (l == 3)
        {
            p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 4, 2);
        }

        if (p_149689_6_.hasDisplayName())
        {
            ((TileEntityReinforcedFurnace)p_149689_1_.getTileEntity(p_149689_2_, p_149689_3_, p_149689_4_)).furnaceName(p_149689_6_.getDisplayName());
        }
    }
    public static void updateBlockState(boolean burning, World world, int x, int y, int z)
    {
        int direction = world.getBlockMetadata(x, y, z);
        TileEntity tileentity = world.getTileEntity(x, y, z);
        isBurning = true;
        if(burning)
        {
            world.setBlock(x, y, z, ModBlocks.reinforcedFurnaceActive);
        }
        else
        {
            world.setBlock(x, y, z, ModBlocks.reinforcedFurnace);
        }

        isBurning = false;
        world.setBlockMetadataWithNotify(x, y, z, direction, 2);

        if(tileentity != null)
        {
            tileentity.validate();
            world.setTileEntity(x, y, z, tileentity);
        }
    }

    public void breakBlock(World world, int x, int y, int z, Block block, int meta)
    {
        if(!isBurning) {
            TileEntityReinforcedFurnace tileentityreinforcedfurnace = (TileEntityReinforcedFurnace) world.getTileEntity(x, y, z);
            if (tileentityreinforcedfurnace != null)
            {
                for(int i = 0; i < tileentityreinforcedfurnace.getSizeInventory(); ++i)
                {
                    ItemStack itemstack = tileentityreinforcedfurnace.getStackInSlot(i);
                    if(itemstack != null) {
                        float f = this.random.nextFloat() * 0.6f + 0.1f;
                        float f1 = this.random.nextFloat() * 0.6f + 0.1f;
                        float f2 = this.random.nextFloat() * 0.6f + 0.1f;

                        while (itemstack.stackSize > 0) {
                            int j = this.random.nextInt(21) + 10;

                            if (j > itemstack.stackSize) {
                                j = itemstack.stackSize;
                            }

                            itemstack.stackSize -= j;
                            EntityItem entityitem = new EntityItem(world, (double) ((float) x + f), (double) ((float) y + f1), (double) ((float) z + f2), new ItemStack(itemstack.getItem(), j, itemstack.getItemDamage()));

                            if (itemstack.hasTagCompound()) {
                                entityitem.getEntityItem().setTagCompound(((NBTTagCompound) itemstack.getTagCompound().copy()));
                            }

                            float f3 = 0.025f;
                            entityitem.motionX = (double) ((float) this.random.nextGaussian() * f3);
                            entityitem.motionY = (double) ((float) this.random.nextGaussian() * f3 + 0.1f);
                            entityitem.motionZ = (double) ((float) this.random.nextGaussian() * f3);
                            world.spawnEntityInWorld(entityitem);
                        }
                    }
                }

                world.func_147453_f(x, y, z, block);
            }
        }
        super.breakBlock(world,z,y,z,block,meta);
    }
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_)
    {
        if (this.isBurning2)
        {
            int l = p_149734_1_.getBlockMetadata(p_149734_2_, p_149734_3_, p_149734_4_);
            float f = (float)p_149734_2_ + 0.5F;
            float f1 = (float)p_149734_3_ + 0.0F + p_149734_5_.nextFloat() * 6.0F / 16.0F;
            float f2 = (float)p_149734_4_ + 0.5F;
            float f3 = 0.52F;
            float f4 = p_149734_5_.nextFloat() * 0.6F - 0.3F;

            if (l == 4)
            {
                p_149734_1_.spawnParticle("smoke", (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
                p_149734_1_.spawnParticle("flame", (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
            }
            else if (l == 5)
            {
                p_149734_1_.spawnParticle("smoke", (double)(f + f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
                p_149734_1_.spawnParticle("flame", (double)(f + f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
            }
            else if (l == 2)
            {
                p_149734_1_.spawnParticle("smoke", (double)(f + f4), (double)f1, (double)(f2 - f3), 0.0D, 0.0D, 0.0D);
                p_149734_1_.spawnParticle("flame", (double)(f + f4), (double)f1, (double)(f2 - f3), 0.0D, 0.0D, 0.0D);
            }
            else if (l == 3)
            {
                p_149734_1_.spawnParticle("smoke", (double)(f + f4), (double)f1, (double)(f2 + f3), 0.0D, 0.0D, 0.0D);
                p_149734_1_.spawnParticle("flame", (double)(f + f4), (double)f1, (double)(f2 + f3), 0.0D, 0.0D, 0.0D);
            }
        }
    }


}
