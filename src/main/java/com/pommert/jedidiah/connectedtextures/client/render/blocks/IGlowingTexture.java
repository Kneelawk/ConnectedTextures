package com.pommert.jedidiah.connectedtextures.client.render.blocks;

import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public interface IGlowingTexture extends IUseSpecialRender {

	/**
	 * Should the renderer render this side with the extra glow texture? Params
	 * are: world, x, y, z, meta, side.
	 * 
	 * @param world
	 * @param x
	 * @param y
	 * @param z
	 * @param meta
	 * @param side
	 * @return
	 */
	@SideOnly(Side.CLIENT)
	public abstract boolean shouldRenderGlow(IBlockAccess world, int x, int y,
			int z, int meta, int side);
}
