package com.pommert.jedidiah.connectedtextures.tileentity.factory;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.pommert.jedidiah.connectedtextures.tileentity.TileEntityFancyLight;

public class TileEntityFancyLightFactory implements ITileEntityFactory {

	@Override
	public TileEntity createTileEntity(World world, int meta) {
		return new TileEntityFancyLight();
	}

	@Override
	public Class<? extends TileEntity> getTileEntityClass() {
		return TileEntityFancyLight.class;
	}

}
