package com.pommert.jedidiah.connectedtextures.client.render.ref;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import com.pommert.jedidiah.connectedtextures.ref.RefMod;

public class RefRes {
	public static class Models {
		public static final String LOC_FANCY_LIGHT = "models/FancyLight.obj";
		public static final ResourceLocation RES_FANCY_LIGHT = new ResourceLocation(
				RefMod.MOD_ID, LOC_FANCY_LIGHT);
		public static final IModelCustom MODEL_FANCY_LIGHT = AdvancedModelLoader
				.loadModel(RES_FANCY_LIGHT);
	}

	public static class Textures {
		public static final String LOC_FANCY_LIGHT_ITEM = "textures/models/blockFancyLight_item.png";
		public static final String LOC_FANCY_LIGHT_BACKGROUND = "textures/models/blockFancyLight_background.png";
		public static final String LOC_FANCY_LIGHT_OVERLAY = "textures/models/blockFancyLight_overlay.png";
		public static final ResourceLocation RES_FANCY_LIGHT_ITEM = new ResourceLocation(
				RefMod.MOD_ID, LOC_FANCY_LIGHT_ITEM);
		public static final ResourceLocation RES_FANCY_LIGHT_BACKGROUND = new ResourceLocation(
				RefMod.MOD_ID, LOC_FANCY_LIGHT_BACKGROUND);
		public static final ResourceLocation RES_FANCY_LIGHT_OVERLAY = new ResourceLocation(
				RefMod.MOD_ID, LOC_FANCY_LIGHT_OVERLAY);
	}
}
