package com.simtimzero.minexp;

import com.simtimzero.minexp.handler.ConfigurationHandler;
import com.simtimzero.minexp.handler.GuiHandler;
import com.simtimzero.minexp.init.*;
import com.simtimzero.minexp.proxy.IProxy;
import com.simtimzero.minexp.proxy.ServerProxy;
import com.simtimzero.minexp.reference.Reference;

import com.simtimzero.minexp.utility.LogHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class MinecraftExplorer 
{
	//Safe Instance of Mod
	@Mod.Instance(Reference.MOD_ID)
	public static MinecraftExplorer instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static IProxy proxy;
	
	//PreInit = Init Blocks / Items / Configs / Network Handeling / Keybindings
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());

        ModItems.init();
        ModBlocks.init();
        WorldGen.init();

        LogHelper.info("Pre Initialization Complete for MineExp");
	}
	//Init = Gui / Tile Entities / Rendering / General Event Handelers / Register Recipies
	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
    {
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
        ModTileEntities.init();
        proxy.initRenderingAndTextures();
        Recipes.init();


    }
	//PostInit = wrap things up
	@Mod.EventHandler 
	public void postInit(FMLPostInitializationEvent event)
	{

	}
}
