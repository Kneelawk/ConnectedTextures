package com.pommert.jedidiah.connectedtextures.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

import com.pommert.jedidiah.connectedtextures.client.render.IconMulti;
import com.pommert.jedidiah.connectedtextures.client.render.blocks.IGlowingTexture;
import com.pommert.jedidiah.connectedtextures.proxy.ProxyCommon;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockGlowing extends Block implements IGlowingTexture {

	protected String texture;

	protected BlockGlowing(String p_i45394_1_, Material p_i45394_2_) {
		super(p_i45394_2_);
		texture = p_i45394_1_;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderType() {
		return ProxyCommon.get().specialRenderID;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public String getRenderName() {
		return "GlowingTextures";
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldRenderGlow(IBlockAccess world, int x, int y, int z,
			int meta, int side) {
		return true;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister ir) {
		blockIcon = new IconMulti(new IIcon[] { getIcon(ir, ""),
				getIcon(ir, ".0"), getIcon(ir, ".1") });
	}

	@SideOnly(Side.CLIENT)
	protected IIcon getIcon(IIconRegister ir, String suffix) {
		return ir.registerIcon(texture + suffix);
	}
}