package com.simtimzero.minexp.proxy;

import com.simtimzero.minexp.block.BlockGlowstoneWire;
import com.simtimzero.minexp.client.renderer.RenderModBlocks;
import com.simtimzero.minexp.client.renderer.Renderers;
import com.simtimzero.minexp.init.ModBlocks;
import com.simtimzero.minexp.reference.RenderIds;
import com.simtimzero.minexp.tileentities.TileEntityGlowstoneDust;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy
{

    @Override
    public ClientProxy getClientProxy() {
        return this;
    }

    @Override
    public void initRenderingAndTextures()
    {
        RenderIds.glowstoneWire = RenderingRegistry.instance().getNextAvailableRenderId();

        //ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGlowstoneDust.class, new RenderModBlocks());
        RenderingRegistry.registerBlockHandler(new RenderModBlocks());
    }
}
