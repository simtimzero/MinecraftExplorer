package com.simtimzero.minexp.utility;

import com.simtimzero.minexp.reference.Reference;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Seth on 2/24/2015.
 */
public class ResourceLocationHelper
{
    public static ResourceLocation getResourceLocation(String modId, String path)
    {
        return new ResourceLocation(modId, path);
    }
    public static ResourceLocation getResourceLocation(String path)
    {
        return getResourceLocation(Reference.LOWERCASE_MOD_ID, path);
    }
}
