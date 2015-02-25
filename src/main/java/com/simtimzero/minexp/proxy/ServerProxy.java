package com.simtimzero.minexp.proxy;

import com.simtimzero.minexp.MinecraftExplorer;
import com.simtimzero.minexp.handler.GuiHandler;
import com.simtimzero.minexp.reference.Reference;
import com.simtimzero.minexp.tileentities.TileEntityReinforcedFurnace;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class ServerProxy extends CommonProxy
{


    @Override
    public ClientProxy getClientProxy() {
        return null;
    }

    @Override
    public void initRenderingAndTextures()
    {

    }
}
