package com.pommert.jedidiah.connectedtextures.client.render.item;

import org.lwjgl.opengl.GL11;

import com.pommert.jedidiah.connectedtextures.ref.RefMod;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class ItemRenderBlock implements IItemRenderer {

	private ResourceLocation texture;
	private IModelCustom model;

	public ItemRenderBlock(String model, String texture) {
		this.model = AdvancedModelLoader.loadModel(new ResourceLocation(
				RefMod.MOD_ID, model));
		this.texture = new ResourceLocation(RefMod.MOD_ID, texture);
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,
			ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		switch (type) {
		case ENTITY:
			render(-0.5f, -0.1f, -0.5f);
			return;
		case EQUIPPED:
			render(0f, 0.3f, 0f);
			return;
		case EQUIPPED_FIRST_PERSON:
			render(0f, 0.5f, 0f);
			return;
		case INVENTORY:
			render(-1f, -0.8f, -1f);
			return;
		case FIRST_PERSON_MAP:
			return;
		}
	}

	private void render(float x, float y, float z) {
		GL11.glPushMatrix();
		GL11.glScalef(1f, 1f, 1f);
		GL11.glTranslatef(x, y - (1f / 8f), z);

		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		model.renderAll();

		GL11.glPopMatrix();
	}
}
