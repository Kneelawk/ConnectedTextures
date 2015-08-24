package com.pommert.jedidiah.connectedtextures.proxy;

import com.pommert.jedidiah.connectedtextures.ConnectedTextures;
import com.pommert.jedidiah.connectedtextures.blocks.CTBlocks;
import com.pommert.jedidiah.connectedtextures.tileentity.CTTileEntities;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ProxyCommon {

	public int specialRenderID = 0;

	public static ProxyCommon get() {
		return (ProxyCommon) ConnectedTextures.proxy;
	}

	public void preInit(FMLPreInitializationEvent event) {
		CTBlocks.init();
		CTTileEntities.init();
	}

	public void init(FMLInitializationEvent event) {
		initRenderIDs();
		CTTileEntities.register();
		initSpecialRenders();
	}

	// only used on client
	public void initRenderIDs() {
	}

	// only used on client
	public void initSpecialRenders() {
	}

	public void postInit(FMLPostInitializationEvent event) {

	}

}
