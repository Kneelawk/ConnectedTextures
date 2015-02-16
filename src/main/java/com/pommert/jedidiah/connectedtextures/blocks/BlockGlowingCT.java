package com.pommert.jedidiah.connectedtextures.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

import com.pommert.jedidiah.connectedtextures.client.render.IconMulti;
import com.pommert.jedidiah.connectedtextures.client.render.blocks.IConnectedTexture;
import com.pommert.jedidiah.connectedtextures.client.render.blocks.IGlowingTexture;
import com.pommert.jedidiah.connectedtextures.proxy.ProxyCommon;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockGlowingCT extends Block implements IGlowingTexture,
		IConnectedTexture {

	protected String texture;

	public BlockGlowingCT(String p_i45394_1_, Material p_i45394_2_) {
		super(p_i45394_2_);
		texture = p_i45394_1_;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister ir) {
		blockIcon = new IconMulti(new IIcon[] { getIcon(ir, ""),
				getIcon(ir, ".0"), getIcon(ir, ".1"), getIcon(ir, ".2"),
				getIcon(ir, ".3"), getIcon(ir, ".4"), getIcon(ir, ".5"),
				getIcon(ir, ".6"), getIcon(ir, ".7"), getIcon(ir, ".8"),
				getIcon(ir, ".9") });
	}

	@SideOnly(Side.CLIENT)
	protected IIcon getIcon(IIconRegister ir, String suffix) {
		return ir.registerIcon(texture + suffix);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderType() {
		return ProxyCommon.get().specialRenderID;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public String getRenderName() {
		return "ConnectedGlowingTextures";
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean outlineConcaveEdges(IBlockAccess world, int x, int y, int z,
			int meta, int side) {
		return true;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldRenderGlow(IBlockAccess world, int x, int y, int z,
			int meta, int side) {
		return true;
	}

}
