package com.simtimzero.minexp.world;

import com.simtimzero.minexp.block.BlockMinexp;
import com.simtimzero.minexp.block.BlockTrollFace;
import com.simtimzero.minexp.init.ModBlocks;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

/**
 * Created by Seth on 2/17/2015.
 */
public class TestBlockTrollFace implements IWorldGenerator {
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch(world.provider.dimensionId)
        {
            case -1:
                generateNether(random, chunkX * 16, chunkZ * 16, world);
                break;
            case 0:
                generateSurface(random, chunkX * 16, chunkZ * 16, world);
                break;
            case 1:
                generateEnd(random, chunkX * 16, chunkZ * 16, world);
                break;
            default:
                ;
        }
    }

    private void addOre(Block block, Block blockSpawn, Random random, World world, int posX, int posZ, int minY, int maxY, int spawnChance, int minVeinSize, int  maxVeinSize)
    {
        for(int i = 0; i < spawnChance; i++)
        {
            int defaultChunkSize = 16;
            int xPos = posX + random.nextInt(defaultChunkSize);
            int yPos = minY + random.nextInt(maxY - minY);
            int zPos = posZ + random.nextInt(defaultChunkSize);

            new WorldGenMinable(block,(minVeinSize + random.nextInt(maxVeinSize - minVeinSize)), blockSpawn ).generate(world, random,xPos,yPos,zPos);
        }
    }

    private void generateEnd(Random random, int chunkX, int chunkZ, World world)
    {

    }

    private void generateSurface(Random random, int chunkX, int chunkZ, World world)
    {
        // block to spawn, block to replace, random, world, chunk pos x, chunk pos z, min spawn height, max spawn height, chance, min vein, max vein
        addOre(ModBlocks.trollBlock, Blocks.stone, random, world, chunkX, chunkZ, 40, 74, 20 ,2, 5);
    }

    private void generateNether(Random random, int chunkX, int chunkZ, World world)
    {

    }
}
