package com.pommert.jedidiah.connectedtextures.tileentity.factory;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public interface ITileEntityFactory {
	public TileEntity createTileEntity(World world, int meta);

	public Class<? extends TileEntity> getTileEntityClass();
}
