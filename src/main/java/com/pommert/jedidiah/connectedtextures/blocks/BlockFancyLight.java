package com.pommert.jedidiah.connectedtextures.blocks;

import com.pommert.jedidiah.connectedtextures.client.render.texture.TextureAtlasUnstitched;
import com.pommert.jedidiah.connectedtextures.ref.RefMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockFancyLight extends BlockWithTileEntity {

	protected IIcon[] icons;

	public BlockFancyLight(String tileEntityName, int renderType,
			Material p_i45386_1_) {
		super(tileEntityName, renderType, p_i45386_1_);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister ir) {
		icons = TextureAtlasUnstitched.registerIcons(ir, RefMod.MOD_ID
				+ ":blockFancyLight", TextureAtlasUnstitched.BASE_NAME_BLOCKS,
				2);
	}

	@Override
	public IIcon getIcon(int side, int meta) {
		return side == 0 || side == 1 ? icons[0] : icons[1];
	}
}
