package com.pommert.jedidiah.connectedtextures.ref;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public final class RefTextures {

	public static final IIcon from(IIconRegister ir, String texture) {
		return ir.registerIcon(with(RefMod.MOD_ID, texture));
	}

	public static final String with(String modId, String texture) {
		return modId + ":" + texture;
	}

	public static final class Blocks {
		public static final String BLOCK_CONNECTED_TEXTURE_GLASS = RefName.Blocks.BLOCK_CONNECTED_TEXTURE_GLASS;
		public static final String BLOCK_CONNECTED_TEXTURE_BRICK = RefName.Blocks.BLOCK_CONNECTED_TEXTURE_BRICK;
		public static final String BLOCK_GLOWING_TILE = RefName.Blocks.BLOCK_GLOWING_TILE;
		public static final String BLOCK_DISCO_FLOOR = RefName.Blocks.BLOCK_DISCO_FLOOR;
	}
}
