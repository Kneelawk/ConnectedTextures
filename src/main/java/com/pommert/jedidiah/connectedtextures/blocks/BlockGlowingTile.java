package com.pommert.jedidiah.connectedtextures.blocks;

import com.pommert.jedidiah.connectedtextures.ref.RefMod;
import com.pommert.jedidiah.connectedtextures.ref.RefTextures;

import net.minecraft.block.material.Material;

public class BlockGlowingTile extends BlockGlowing {

	protected BlockGlowingTile(Material p_i45394_2_) {
		super(RefTextures.with(RefMod.MOD_ID,
				RefTextures.Blocks.BLOCK_GLOWING_TILE), p_i45394_2_);
	}

}
