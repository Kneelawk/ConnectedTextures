package com.pommert.jedidiah.connectedtextures.client.render.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public interface IUseSpecialRender {
	
	@SideOnly(Side.CLIENT)
	public abstract String getRenderName();
}
