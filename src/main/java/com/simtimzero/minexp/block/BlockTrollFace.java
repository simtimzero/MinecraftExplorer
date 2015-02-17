package com.simtimzero.minexp.block;



public class BlockTrollFace extends BlockMinexp
{
    public BlockTrollFace()
    {
        super();
        this.setBlockName("trollBlock");
        this.setHardness(1.5f);
        this.setStepSound(soundTypePiston);
        this.setBlockTextureName("trollBlock");
        this.setResistance(2000.0f);
        this.setLightLevel(1.0f);

    }
}
