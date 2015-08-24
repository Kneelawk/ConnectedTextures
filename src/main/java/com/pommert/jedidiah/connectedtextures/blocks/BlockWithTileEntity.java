package com.pommert.jedidiah.connectedtextures.blocks;

import com.pommert.jedidiah.connectedtextures.tileentity.CTTileEntities;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockWithTileEntity extends BlockContainer {

	protected String tileEntityName;
	protected int renderType;

	public BlockWithTileEntity(String tileEntityName, int renderType,
			Material p_i45386_1_) {
		super(p_i45386_1_);
		this.tileEntityName = tileEntityName;
		this.renderType = renderType;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return CTTileEntities.create(tileEntityName, world, meta);
	}

	@Override
	public int getRenderType() {
		return renderType;
	}
}
