package com.pommert.jedidiah.connectedtextures.client.render.blocks;

import java.util.HashMap;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderBlocksControl {
	private static HashMap<String, BaseRenderBlocks> renderers = new HashMap<String, BaseRenderBlocks>();

	public static void init() {
		registerBlockRenderer("ConnectedTextures",
				new ConnectedTexturesRenderBlocks());
		registerBlockRenderer("GlowingTextures",
				new GlowingTexturesRenderBlocks());
	}

	public static void registerBlockRenderer(String renderName,
			BaseRenderBlocks renderer) {
		renderers.put(renderName, renderer);
	}

	public static boolean renderWorldBlock(IBlockAccess world, int x, int y,
			int z, Block block, int modelId, RenderBlocks render) {
		if (render.hasOverrideBlockTexture()) {
			return render.renderStandardBlock(block, x, y, z);
		} else {
			if (block instanceof IUseSpecialRender) {
				BaseRenderBlocks renderBase = renderers
						.get(((IUseSpecialRender) block).getRenderName());
				if (renderBase == null)
					return false;
				renderBase.initForBlock(world, x, y, z, block, modelId,
						renderBase);
				return renderBase.renderStandardBlock(block, x, y, z);
			} else {
				return false;
			}
		}
	}
}
