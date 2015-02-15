package com.pommert.jedidiah.connectedtextures.client.render.blocks;

import com.pommert.jedidiah.connectedtextures.client.render.IconMulti;

import net.minecraft.block.Block;
import net.minecraft.util.IIcon;
import net.minecraftforge.common.util.ForgeDirection;

public class GlowingTexturesRenderBlocks extends BaseRenderBlocks {
	@Override
	public void renderFaceYNeg(Block block, double x, double y, double z,
			IIcon texture) {
		if (hasOverrideBlockTexture())
			texture = overrideBlockTexture;

		if (texture instanceof IconMulti) {
			IconMulti tex = (IconMulti) texture;
			if (tex.icons.length < 2)
				return;

			boolean renderGlow = tex.icons.length >= 3;
			if (block instanceof IGlowingTexture)
				renderGlow &= ((IGlowingTexture) block).shouldRenderGlow(
						blockAccess, (int) x, (int) y, (int) z, currentMeta, 0);

			tex.currentType = 1;
			renderFace(tex, x, y, z, ForgeDirection.DOWN, new double[] { 0D,
					0D, 1D, 16D, 16D }, new double[] { 0D, 0D, 0D, 16D, 0D },
					new double[] { 1D, 0D, 0D, 0D, 0D }, new double[] { 1D, 0D,
							1D, 0D, 16D });
			if (renderGlow) {
				tex.currentType = 2;
				renderGlowingFace(tex, x, y, z, new double[] { 0D, 0D, 1D, 16D,
						16D }, new double[] { 0D, 0D, 0D, 16D, 0D },
						new double[] { 1D, 0D, 0D, 0D, 0D }, new double[] { 1D,
								0D, 1D, 0D, 16D });
			}
			tex.currentType = 0;
		}
	}

	@Override
	public void renderFaceYPos(Block block, double x, double y, double z,
			IIcon texture) {
		if (hasOverrideBlockTexture())
			texture = overrideBlockTexture;

		if (texture instanceof IconMulti) {
			IconMulti tex = (IconMulti) texture;
			if (tex.icons.length < 2)
				return;

			boolean renderGlow = tex.icons.length >= 3;
			if (block instanceof IGlowingTexture)
				renderGlow &= ((IGlowingTexture) block).shouldRenderGlow(
						blockAccess, (int) x, (int) y, (int) z, currentMeta, 0);

			tex.currentType = 1;
			renderFace(tex, x, y, z, ForgeDirection.UP, new double[] { 1D, 1D,
					1D, 16D, 16D }, new double[] { 1D, 1D, 0D, 16D, 0D },
					new double[] { 0D, 1D, 0D, 0D, 0D }, new double[] { 0D, 1D,
							1D, 0D, 16D });
			if (renderGlow) {
				tex.currentType = 2;
				renderGlowingFace(tex, x, y, z, new double[] { 1D, 1D, 1D, 16D,
						16D }, new double[] { 1D, 1D, 0D, 16D, 0D },
						new double[] { 0D, 1D, 0D, 0D, 0D }, new double[] { 0D,
								1D, 1D, 0D, 16D });
			}
			tex.currentType = 0;
		}
	}

	@Override
	public void renderFaceZNeg(Block block, double x, double y, double z,
			IIcon texture) {
		if (hasOverrideBlockTexture())
			texture = overrideBlockTexture;

		if (texture instanceof IconMulti) {
			IconMulti tex = (IconMulti) texture;
			if (tex.icons.length < 2)
				return;

			boolean renderGlow = tex.icons.length >= 3;
			if (block instanceof IGlowingTexture)
				renderGlow &= ((IGlowingTexture) block).shouldRenderGlow(
						blockAccess, (int) x, (int) y, (int) z, currentMeta, 0);

			tex.currentType = 1;
			renderFace(tex, x, y, z, ForgeDirection.NORTH, new double[] { 0D,
					0D, 0D, 16D, 16D }, new double[] { 0D, 1D, 0D, 16D, 0D },
					new double[] { 1D, 1D, 0D, 0D, 0D }, new double[] { 1D, 0D,
							0D, 0D, 16D });
			if (renderGlow) {
				tex.currentType = 2;
				renderGlowingFace(tex, x, y, z, new double[] { 0D, 0D, 0D, 16D,
						16D }, new double[] { 0D, 1D, 0D, 16D, 0D },
						new double[] { 1D, 1D, 0D, 0D, 0D }, new double[] { 1D,
								0D, 0D, 0D, 16D });
			}
			tex.currentType = 0;
		}
	}

	@Override
	public void renderFaceZPos(Block block, double x, double y, double z,
			IIcon texture) {
		if (hasOverrideBlockTexture())
			texture = overrideBlockTexture;

		if (texture instanceof IconMulti) {
			IconMulti tex = (IconMulti) texture;
			if (tex.icons.length < 2)
				return;

			boolean renderGlow = tex.icons.length >= 3;
			if (block instanceof IGlowingTexture)
				renderGlow &= ((IGlowingTexture) block).shouldRenderGlow(
						blockAccess, (int) x, (int) y, (int) z, currentMeta, 0);

			tex.currentType = 1;
			renderFace(tex, x, y, z, ForgeDirection.SOUTH, new double[] { 1D,
					0D, 1D, 16D, 16D }, new double[] { 1D, 1D, 1D, 16D, 0D },
					new double[] { 0D, 1D, 1D, 0D, 0D }, new double[] { 0D, 0D,
							1D, 0D, 16D });
			if (renderGlow) {
				tex.currentType = 2;
				renderGlowingFace(tex, x, y, z, new double[] { 1D, 0D, 1D, 16D,
						16D }, new double[] { 1D, 1D, 1D, 16D, 0D },
						new double[] { 0D, 1D, 1D, 0D, 0D }, new double[] { 0D,
								0D, 1D, 0D, 16D });
			}
			tex.currentType = 0;
		}
	}

	@Override
	public void renderFaceXNeg(Block block, double x, double y, double z,
			IIcon texture) {
		if (hasOverrideBlockTexture())
			texture = overrideBlockTexture;

		if (texture instanceof IconMulti) {
			IconMulti tex = (IconMulti) texture;
			if (tex.icons.length < 2)
				return;

			boolean renderGlow = tex.icons.length >= 3;
			if (block instanceof IGlowingTexture)
				renderGlow &= ((IGlowingTexture) block).shouldRenderGlow(
						blockAccess, (int) x, (int) y, (int) z, currentMeta, 0);

			tex.currentType = 1;
			renderFace(tex, x, y, z, ForgeDirection.WEST, new double[] { 0D,
					0D, 1D, 16D, 16D }, new double[] { 0D, 1D, 1D, 16D, 0D },
					new double[] { 0D, 1D, 0D, 0D, 0D }, new double[] { 0D, 0D,
							0D, 0D, 16D });
			if (renderGlow) {
				tex.currentType = 2;
				renderGlowingFace(tex, x, y, z, new double[] { 0D, 0D, 1D, 16D,
						16D }, new double[] { 0D, 1D, 1D, 16D, 0D },
						new double[] { 0D, 1D, 0D, 0D, 0D }, new double[] { 0D,
								0D, 0D, 0D, 16D });
			}
			tex.currentType = 0;
		}
	}

	@Override
	public void renderFaceXPos(Block block, double x, double y, double z,
			IIcon texture) {
		if (hasOverrideBlockTexture())
			texture = overrideBlockTexture;

		if (texture instanceof IconMulti) {
			IconMulti tex = (IconMulti) texture;
			if (tex.icons.length < 2)
				return;

			boolean renderGlow = tex.icons.length >= 3;
			if (block instanceof IGlowingTexture)
				renderGlow &= ((IGlowingTexture) block).shouldRenderGlow(
						blockAccess, (int) x, (int) y, (int) z, currentMeta, 0);

			tex.currentType = 1;
			renderFace(tex, x, y, z, ForgeDirection.EAST, new double[] { 1D,
					0D, 0D, 16D, 16D }, new double[] { 1D, 1D, 0D, 16D, 0D },
					new double[] { 1D, 1D, 1D, 0D, 0D }, new double[] { 1D, 0D,
							1D, 0D, 16D });
			if (renderGlow) {
				tex.currentType = 2;
				renderGlowingFace(tex, x, y, z, new double[] { 1D, 0D, 0D, 16D,
						16D }, new double[] { 1D, 1D, 0D, 16D, 0D },
						new double[] { 1D, 1D, 1D, 0D, 0D }, new double[] { 1D,
								0D, 1D, 0D, 16D });
			}
			tex.currentType = 0;
		}
	}
}
