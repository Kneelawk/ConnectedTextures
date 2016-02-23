package com.pommert.jedidiah.connectedtextures.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

import com.pommert.jedidiah.connectedtextures.client.render.IconMulti;
import com.pommert.jedidiah.connectedtextures.client.render.IconSplit;
import com.pommert.jedidiah.connectedtextures.client.render.blocks.IConnectedTexture;
import com.pommert.jedidiah.connectedtextures.client.render.texture.TextureAtlasUnstitched;
import com.pommert.jedidiah.connectedtextures.proxy.ProxyCommon;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCT extends Block implements IConnectedTexture {

	protected BlockCT(String p_i45394_1_, Material p_i45394_2_) {
		super(p_i45394_2_);
		textureName = p_i45394_1_;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderType() {
		return ProxyCommon.get().specialRenderID;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister ir) {
		blockIcon = new IconMulti(TextureAtlasUnstitched.registerIcons(ir,
				textureName, TextureAtlasUnstitched.BASE_NAME_BLOCKS, 6));
	}

	@SideOnly(Side.CLIENT)
	protected IIcon getIcon(IIconRegister ir, String suffix, int numIcons) {
		return new IconMulti(TextureAtlasUnstitched.registerIcons(ir,
				textureName + suffix, TextureAtlasUnstitched.BASE_NAME_BLOCKS,
				numIcons));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean outlineConcaveEdges(IBlockAccess world, int x, int y, int z,
			int meta, int side) {
		return true;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public String getRenderName() {
		return "ConnectedTextures";
	}
}
