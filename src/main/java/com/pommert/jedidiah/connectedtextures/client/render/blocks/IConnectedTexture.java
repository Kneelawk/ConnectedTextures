package com.pommert.jedidiah.connectedtextures.client.render.blocks;

import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public interface IConnectedTexture extends IUseSpecialRender {

	/**
	 * Should the renderer render this side of this block with outlined concave
	 * edges? Params are: world, x, y, z, meta, side.
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
	public abstract boolean outlineConcaveEdges(IBlockAccess world, int x,
			int y, int z, int meta, int side);
}
