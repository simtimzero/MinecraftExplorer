package com.simtimzero.minexp.client.renderer;

import com.simtimzero.minexp.reference.Textures;
import com.simtimzero.minexp.tileentities.TileEntityGlowstoneDust;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;


/**
 * Created by Seth on 2/19/2015.
 */
@SideOnly(Side.CLIENT)
public class RenderModBlockstesting extends TileEntitySpecialRenderer
{


        @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick)
        {
            TileEntityGlowstoneDust tileEntityGlowstoneDust = (TileEntityGlowstoneDust) tileEntity;
            ForgeDirection direction = null;
            if (tileEntityGlowstoneDust.getWorldObj() != null)
            {
                direction = tileEntityGlowstoneDust.getOrientation();
            }
            this.bindTexture(Textures.Model.GLOWSTONE_WIRE);
            GL11.glPushMatrix();
            GL11.glEnable(GL12.GL_RESCALE_NORMAL);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glTranslatef((float) x, (float) y + 1.0F, (float) z + 1.0F);
            GL11.glScalef(1.0F, -1.0F, -1.0F);
            GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            short angle = 0;

            if (direction != null)
            {
                if (direction == ForgeDirection.NORTH)
                {
                    angle = 180;
                }
                else if (direction == ForgeDirection.SOUTH)
                {
                    angle = 0;
                }
                else if (direction == ForgeDirection.WEST)
                {
                    angle = 90;
                }
                else if (direction == ForgeDirection.EAST)
                {
                    angle = -90;
                }
            }
            GL11.glRotatef(angle, 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
            GL11.glDisable(GL12.GL_RESCALE_NORMAL);
            GL11.glPopMatrix();
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

    }
}
