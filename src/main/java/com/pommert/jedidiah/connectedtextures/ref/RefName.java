package com.pommert.jedidiah.connectedtextures.ref;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RefName {
	public class Blocks {
		public static final String BLOCK_CONNECTED_TEXTURE_GLASS = "blockConnectedTextureGlass";
		public static final String BLOCK_CONNECTED_TEXTURE_BRICK = "blockConnectedTextureBrick";
		public static final String BLOCK_GLOWING_TILE = "blockGlowingTile";
		public static final String BLOCK_DISCO_FLOOR = "blockDiscoFloor";
	}

	@SideOnly(Side.CLIENT)
	public class RenderNames {
		public static final String RENDER_BLOCKS_CONNECTED_TEXTURES = "ConnectedTextures";
		public static final String RENDER_BLOCKS_GLOWING_TEXTURES = "GlowingTextures";
		public static final String RENDER_BLOCKS_CONNECTED_GLOWING_TEXTURES = "ConnectedGlowingTextures";
	}
}
