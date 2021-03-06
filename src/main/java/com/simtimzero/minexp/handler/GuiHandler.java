package com.simtimzero.minexp.handler;

import com.simtimzero.minexp.gui.GuiReinforcedFurnace;
import com.simtimzero.minexp.gui.GuiReinforcedFurnaceGold;
import com.simtimzero.minexp.inventory.ContainerReinforcedFurnace;
import com.simtimzero.minexp.inventory.ContainerReinforcedFurnaceGold;
import com.simtimzero.minexp.reference.GUIs;
import com.simtimzero.minexp.tileentities.TileEntityReinforcedFurnace;
import com.simtimzero.minexp.tileentities.TileEntityReinforcedFurnaceGold;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler
{
    public GuiHandler (){

    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if(ID == GUIs.RFURNACE.ordinal())
        {
            TileEntityReinforcedFurnace tileEntityReinforcedFurnace = (TileEntityReinforcedFurnace) world.getTileEntity(x, y, z);
            return new ContainerReinforcedFurnace(player.inventory, tileEntityReinforcedFurnace);
        }
        else if (ID == GUIs.RFURNACEG.ordinal())
        {
            TileEntityReinforcedFurnaceGold tileEntityReinforcedFurnaceGold = (TileEntityReinforcedFurnaceGold) world.getTileEntity(x,y,z);
            return new ContainerReinforcedFurnaceGold(player.inventory, tileEntityReinforcedFurnaceGold);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if(ID == GUIs.RFURNACE.ordinal())
        {
            TileEntityReinforcedFurnace tileEntityReinforcedFurnace = (TileEntityReinforcedFurnace) world.getTileEntity(x, y, z);
            return new GuiReinforcedFurnace(player.inventory, tileEntityReinforcedFurnace);
        }
        else if (ID == GUIs.RFURNACEG.ordinal())
        {
            TileEntityReinforcedFurnaceGold tileEntityReinforcedFurnaceGold = (TileEntityReinforcedFurnaceGold) world.getTileEntity(x,y,z);
            return new GuiReinforcedFurnaceGold(player.inventory, tileEntityReinforcedFurnaceGold);
        }
        return null;
    }
}
