package com.pommert.jedidiah.connectedtextures;

import codechicken.lib.vec.Rotation;
import codechicken.lib.vec.Vector3;

import com.pommert.jedidiah.connectedtextures.proxy.ProxyCommon;
import com.pommert.jedidiah.connectedtextures.ref.RefMod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = RefMod.MOD_ID)
public class ConnectedTextures {

	@SidedProxy(clientSide = "com.pommert.jedidiah.connectedtextures.proxy.ProxyClient", serverSide = "com.pommert.jedidiah.connectedtextures.proxy.ProxyServer")
	public static ProxyCommon proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.preInit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}
}
