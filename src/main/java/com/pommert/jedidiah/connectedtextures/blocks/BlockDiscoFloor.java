package com.pommert.jedidiah.connectedtextures.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

import com.pommert.jedidiah.connectedtextures.client.render.IconMulti;
import com.pommert.jedidiah.connectedtextures.client.render.IconSplit;
import com.pommert.jedidiah.connectedtextures.ref.RefMod;
import com.pommert.jedidiah.connectedtextures.ref.RefTextures;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockDiscoFloor extends BlockGlowingCT {
	public BlockDiscoFloor(Material p_i45394_1_) {
		super(RefTextures.with(RefMod.MOD_ID,
				RefTextures.Blocks.BLOCK_DISCO_FLOOR), p_i45394_1_);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister ir) {
		blockIcon = new IconMulti(ir.registerIcon(textureName + "_item"),
				getIcon(ir, "_background", 5), getIcon(ir, "_overlay", 5));
	}
}
