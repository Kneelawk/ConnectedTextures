package com.pommert.jedidiah.connectedtextures.client.render.tileentity;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import com.pommert.jedidiah.connectedtextures.client.render.ref.RefRes;
import com.pommert.jedidiah.connectedtextures.tileentity.TileEntityFancyLight;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderFancyLight extends TileEntitySpecialRenderer {

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y,
			double z, float f) {
		float r = 1f, g = 1f, b = 1f;
		if (tile != null) {
			TileEntityFancyLight fancyTile = (TileEntityFancyLight) tile;
			r = fancyTile.r;
			g = fancyTile.g;
			b = fancyTile.b;
		}

		GL11.glPushMatrix();
		GL11.glTranslated(x, y, z);

		bindTexture(RefRes.Textures.RES_FANCY_LIGHT_BACKGROUND);
		RefRes.Models.MODEL_FANCY_LIGHT.renderAll();

		GL11.glColor4f(r, g, b, 1f);
		GL11.glDisable(GL11.GL_LIGHTING);
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit,
				240f, 240f);

		bindTexture(RefRes.Textures.RES_FANCY_LIGHT_OVERLAY);
		RefRes.Models.MODEL_FANCY_LIGHT.renderAll();

		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glPopMatrix();
	}
}
