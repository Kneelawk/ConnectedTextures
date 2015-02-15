package com.pommert.jedidiah.connectedtextures.client.render.blocks;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class BaseRenderBlocks extends RenderBlocks {
	public static boolean[][] lo = { { true, false }, { false, false },
			{ true, false }, { true, true }, { true, false }, { false, true } };
	public static boolean[][] li = { { false, true }, { false, true },
			{ true, false }, { false, true }, { true, false }, { true, false } };

	protected Block currentBlock;
	protected int currentMeta;

	public void initForBlock(IBlockAccess world, int x, int y, int z,
			Block block, int modelId, RenderBlocks render) {
		blockAccess = world;
		currentBlock = block;
		currentMeta = world.getBlockMetadata(x, y, z);
		block.setBlockBoundsBasedOnState(world, x, y, z);
		setRenderBoundsFromBlock(block);
	}

	protected void setVertexLightingUV(int side, double u, double v) {
		if (enableAO) {
			Tessellator tess = Tessellator.instance;

			double lu = (lo[side][0] ? 1D - (li[side][0] ? v : u)
					: (li[side][0] ? v : u));
			double lv = (lo[side][1] ? 1D - (li[side][1] ? v : u)
					: (li[side][1] ? v : u));
			tess.setBrightness(mixAoBrightness(brightnessTopLeft,
					brightnessTopRight, brightnessBottomLeft,
					brightnessBottomRight, lu * lv, (1D - lu) * lv, lu
							* (1D - lv), (1D - lu) * (1D - lv)));
			tess.setColorOpaque_F((float) (colorRedTopLeft * lu * lv
					+ colorRedTopRight * (1D - lu) * lv + colorRedBottomLeft
					* lu * (1D - lv) + colorRedBottomRight * (1D - lu)
					* (1D - lv)),
					(float) (colorGreenTopLeft * lu * lv + colorGreenTopRight
							* (1D - lu) * lv + colorGreenBottomLeft * lu
							* (1D - lv) + colorGreenBottomRight * (1D - lu)
							* (1D - lv)),
					(float) (colorBlueTopLeft * lu * lv + colorBlueTopRight
							* (1D - lu) * lv + colorBlueBottomLeft * lu
							* (1D - lv) + colorBlueBottomRight * (1D - lu)
							* (1D - lv)));
		}
	}

	protected void renderFace(IIcon tex, double x, double y, double z,
			ForgeDirection side, double[] c1, double[] c2, double[] c3,
			double[] c4) {
		Tessellator tess = Tessellator.instance;

		int s = side.ordinal();

		double u = tex.getInterpolatedU(c1[3]);
		double v = tex.getInterpolatedV(c1[4]);
		setVertexLightingUV(s, c1[3] / 16D, c1[4] / 16D);
		tess.addVertexWithUV(x + c1[0], y + c1[1], z + c1[2], u, v);

		u = tex.getInterpolatedU(c2[3]);
		v = tex.getInterpolatedV(c2[4]);
		setVertexLightingUV(s, c2[3] / 16D, c2[4] / 16D);
		tess.addVertexWithUV(x + c2[0], y + c2[1], z + c2[2], u, v);

		u = tex.getInterpolatedU(c3[3]);
		v = tex.getInterpolatedV(c3[4]);
		setVertexLightingUV(s, c3[3] / 16D, c3[4] / 16D);
		tess.addVertexWithUV(x + c3[0], y + c3[1], z + c3[2], u, v);

		u = tex.getInterpolatedU(c4[3]);
		v = tex.getInterpolatedV(c4[4]);
		setVertexLightingUV(s, c4[3] / 16D, c4[4] / 16D);
		tess.addVertexWithUV(x + c4[0], y + c4[1], z + c4[2], u, v);
	}

	protected void renderGlowingFace(IIcon tex, double x, double y, double z,
			double[] c1, double[] c2, double[] c3, double[] c4) {
		Tessellator tess = Tessellator.instance;

		tess.setColorOpaque_F(1F, 1F, 1F);
		tess.setBrightness(0xE << 0x14 | 0xE << 0x4);

		double u = tex.getInterpolatedU(c1[3]);
		double v = tex.getInterpolatedV(c1[4]);
		tess.addVertexWithUV(x + c1[0], y + c1[1], z + c1[2], u, v);

		u = tex.getInterpolatedU(c2[3]);
		v = tex.getInterpolatedV(c2[4]);
		tess.addVertexWithUV(x + c2[0], y + c2[1], z + c2[2], u, v);

		u = tex.getInterpolatedU(c3[3]);
		v = tex.getInterpolatedV(c3[4]);
		tess.addVertexWithUV(x + c3[0], y + c3[1], z + c3[2], u, v);

		u = tex.getInterpolatedU(c4[3]);
		v = tex.getInterpolatedV(c4[4]);
		tess.addVertexWithUV(x + c4[0], y + c4[1], z + c4[2], u, v);
	}
}
