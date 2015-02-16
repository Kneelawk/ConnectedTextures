package com.pommert.jedidiah.connectedtextures.blocks;

import net.minecraft.block.material.Material;

import com.pommert.jedidiah.connectedtextures.ref.RefMod;
import com.pommert.jedidiah.connectedtextures.ref.RefTextures;

public class BlockDiscoFloor extends BlockGlowingCT {
	public BlockDiscoFloor(Material p_i45394_1_) {
		super(RefTextures.with(RefMod.MOD_ID,
				RefTextures.Blocks.BLOCK_DISCO_FLOOR), p_i45394_1_);
	}
}
