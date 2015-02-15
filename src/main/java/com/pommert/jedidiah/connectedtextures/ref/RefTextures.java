package com.pommert.jedidiah.connectedtextures.ref;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public final class RefTextures {
	@SideOnly(Side.CLIENT)
	public static final IIcon from(IIconRegister ir, String texture) {
		return ir.registerIcon(with(RefMod.MOD_ID, texture));
	}

	public static final String with(String modId, String texture) {
		return modId + ":" + texture;
	}

	public static final class Blocks {
		public static final String BLOCK_CONNECTED_TEXTURE_GLASS = "blockConnectedTextureGlass";
		public static final String BLOCK_CONNECTED_TEXTURE_BRICK = "blockConnectedTextureBrick";
		public static final String BLOCK_GLOWING_TILE = "blockGlowingTile";
	}
}
