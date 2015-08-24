package com.pommert.jedidiah.connectedtextures.proxy;

import com.pommert.jedidiah.connectedtextures.client.render.blocks.RenderBlocksControl;
import com.pommert.jedidiah.connectedtextures.client.render.blocks.RenderSpecialBlock;
import com.pommert.jedidiah.connectedtextures.client.render.item.CTItemRenders;
import com.pommert.jedidiah.connectedtextures.client.render.tileentity.CTTileEntityRenders;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ProxyClient extends ProxyCommon {
	public void initRenderIDs() {
		RenderBlocksControl.init();
		specialRenderID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(new RenderSpecialBlock());
	}

	@Override
	public void initSpecialRenders() {
		CTTileEntityRenders.init();
		CTItemRenders.init();
	}
}
