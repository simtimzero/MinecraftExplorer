package com.simtimzero.minexp.world;

import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by Seth on 2/17/2015.
 */
public class MinexpWorld
{

    public static void initiliseWorldGen()
    {
        registerWorldGen(new TestBlockTrollFace(), 1);
    }
    public static void registerWorldGen(IWorldGenerator worldGenClass, int weightedProbability)
    {
        // Bigger numbers on the weightedProbability means it spawns later in worldgen
        GameRegistry.registerWorldGenerator(worldGenClass, 1);
    }
}
