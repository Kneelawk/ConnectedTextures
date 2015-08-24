package com.pommert.jedidiah.connectedtextures.client.render.tileentity;

import java.util.HashMap;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

import com.pommert.jedidiah.connectedtextures.ref.RefName;
import com.pommert.jedidiah.connectedtextures.tileentity.CTTileEntities;

import cpw.mods.fml.client.registry.ClientRegistry;

public class CTTileEntityRenders {
	private static HashMap<String, TileEntitySpecialRenderer> renders = new HashMap<String, TileEntitySpecialRenderer>();

	/**
	 * <b>Warning: Must be initialized <u>AFTER</u> CTTileEntities!</b>
	 */
	public static void init() {
		register(RefName.TileEntities.TILE_ENTITY_FANCY_LIGHT,
				new RenderFancyLight());
	}

	public static void register(String name, TileEntitySpecialRenderer render) {
		renders.put(name, render);
		ClientRegistry.bindTileEntitySpecialRenderer(
				CTTileEntities.getTileClass(name), render);
	}
}
