package com.pommert.jedidiah.connectedtextures.blocks;

import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import com.pommert.jedidiah.connectedtextures.client.render.IconSplit;
import com.pommert.jedidiah.connectedtextures.proxy.ProxyCommon;
import com.pommert.jedidiah.connectedtextures.ref.RefMod;
import com.pommert.jedidiah.connectedtextures.ref.RefTextures;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockConnectedTextureGlass extends BlockBreakableCT {

	public BlockConnectedTextureGlass(Material material) {
		super(RefTextures.with(RefMod.MOD_ID,
				RefTextures.Blocks.BLOCK_CONNECTED_TEXTURE_GLASS), material,
				false);
	}
}
