package com.simtimzero.minexp.tileentities;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.UUID;

/**
 * Created by Seth on 2/24/2015.
 */
public class TileEntityMinExp extends TileEntity
{
    protected ForgeDirection orientation;
    protected byte state;
    protected String customName;
    protected UUID ownerUUID;

    public TileEntityMinExp()
    {
        orientation = ForgeDirection.SOUTH;
        state = 0;
        customName = "";
        ownerUUID = null;
    }

    public ForgeDirection getOrientation()
    {
        return orientation;
    }

    public void setOrientation(ForgeDirection orientation)
    {
        this.orientation = orientation;
    }

    public void setOrientation(int orientation)
    {
        this.orientation = ForgeDirection.getOrientation(orientation);
    }

    public short getState()
    {
        return state;
    }

    public void setState(byte state)
    {
        this.state = state;
    }
}
