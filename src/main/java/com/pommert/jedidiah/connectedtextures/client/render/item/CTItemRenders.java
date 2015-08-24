package com.pommert.jedidiah.connectedtextures.client.render.item;

import com.pommert.jedidiah.connectedtextures.blocks.CTBlocks;
import com.pommert.jedidiah.connectedtextures.client.render.ref.RefRes;

import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

public class CTItemRenders {
	public static void init() {
		MinecraftForgeClient.registerItemRenderer(Item
				.getItemFromBlock(CTBlocks.blockFancyLight),
				new ItemRenderBlock(RefRes.Models.LOC_FANCY_LIGHT,
						RefRes.Textures.LOC_FANCY_LIGHT_ITEM));
	}
}
