package com.pommert.jedidiah.connectedtextures.proxy;

import com.pommert.jedidiah.connectedtextures.client.render.blocks.RenderBlocksControl;
import com.pommert.jedidiah.connectedtextures.client.render.blocks.RenderSpecialBlock;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ProxyClient extends ProxyCommon {
	public void initRenderIDs() {
		RenderBlocksControl.init();
		specialRenderID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(new RenderSpecialBlock());
	}
}
