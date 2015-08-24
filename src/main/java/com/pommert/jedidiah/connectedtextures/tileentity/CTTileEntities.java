package com.pommert.jedidiah.connectedtextures.tileentity;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.pommert.jedidiah.connectedtextures.ref.RefName;
import com.pommert.jedidiah.connectedtextures.tileentity.factory.ITileEntityFactory;
import com.pommert.jedidiah.connectedtextures.tileentity.factory.TileEntityFancyLightFactory;

import cpw.mods.fml.common.registry.GameRegistry;

public class CTTileEntities {
	private static HashMap<String, ITileEntityFactory> factories = new HashMap<String, ITileEntityFactory>();

	public static void init() {
		add(new TileEntityFancyLightFactory(),
				RefName.TileEntities.TILE_ENTITY_FANCY_LIGHT);
	}

	private static void add(ITileEntityFactory factory, String name) {
		factories.put(name, factory);
	}

	public static void register() {
		Set<Entry<String, ITileEntityFactory>> entries = factories.entrySet();
		for (Entry<String, ITileEntityFactory> ent : entries) {
			GameRegistry.registerTileEntity(
					ent.getValue().getTileEntityClass(), ent.getKey());
		}
	}

	public static TileEntity create(String name, World world, int meta) {
		if (!factories.containsKey(name))
			return null;
		return factories.get(name).createTileEntity(world, meta);
	}

	public static Class<? extends TileEntity> getTileClass(String name) {
		if (!factories.containsKey(name))
			return null;
		return factories.get(name).getTileEntityClass();
	}
}
