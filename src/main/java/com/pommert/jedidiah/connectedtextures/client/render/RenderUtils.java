package com.pommert.jedidiah.connectedtextures.client.render;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.opengl.GL11;

import com.pommert.jedidiah.connectedtextures.blocks.BlockBreakableCT;
import com.pommert.jedidiah.connectedtextures.blocks.BlockCT;
import com.pommert.jedidiah.connectedtextures.client.render.blocks.ConnectedTexturesRenderBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderUtils {

	public static void renderInventoryBlock(Block block, int meta,
			RenderBlocks render) {
		Tessellator tess = Tessellator.instance;
		block.setBlockBoundsForItemRender();
		render.setRenderBoundsFromBlock(block);
		GL11.glRotatef(90, 0, 1, 0);
		GL11.glTranslatef(-0.5F, 0, -0.5F);

		float r = 1, g = 1, b = 1;
		if (EntityRenderer.anaglyphEnable) {
			float r2 = (r * 30 + g * 59 + 11 * b) / 100;
			float g2 = (r * 30 + g * 70) / 100;
			float b2 = (r * 30 + b * 70) / 100;
			r = r2;
			g = g2;
			b = b2;
		}

		GL11.glColor4f(r, g, b, 1);
		render.colorRedTopLeft *= r;
		render.colorRedTopRight *= r;
		render.colorRedBottomLeft *= r;
		render.colorRedBottomRight *= r;
		render.colorGreenTopLeft *= g;
		render.colorGreenTopRight *= g;
		render.colorGreenBottomLeft *= g;
		render.colorGreenBottomRight *= g;
		render.colorBlueTopLeft *= b;
		render.colorBlueTopRight *= b;
		render.colorBlueBottomLeft *= b;
		render.colorBlueBottomRight *= b;

		if (block.getIcon(0, meta) != null) {
			tess.startDrawingQuads();
			tess.setNormal(0, -1, 0);
			render.renderFaceYNeg(block, 0, -0.5, 0, block.getIcon(0, meta));
			tess.draw();
			tess.startDrawingQuads();
			tess.setNormal(0, 1, 0);
			render.renderFaceYPos(block, 0, -0.5, 0, block.getIcon(1, meta));
			tess.draw();
			tess.startDrawingQuads();
			tess.setNormal(0, 0, -1);
			render.renderFaceXPos(block, 0, -0.5, 0, block.getIcon(2, meta));
			tess.draw();
			tess.startDrawingQuads();
			tess.setNormal(0, 0, 1);
			render.renderFaceXNeg(block, 0, -0.5, 0, block.getIcon(3, meta));
			tess.draw();
			tess.startDrawingQuads();
			tess.setNormal(-1, 0, 0);
			render.renderFaceZNeg(block, 0, -0.5, 0, block.getIcon(4, meta));
			tess.draw();
			tess.startDrawingQuads();
			tess.setNormal(1, 0, 0);
			render.renderFaceZPos(block, 0, -0.5, 0, block.getIcon(5, meta));
			tess.draw();
		}
	}
}
