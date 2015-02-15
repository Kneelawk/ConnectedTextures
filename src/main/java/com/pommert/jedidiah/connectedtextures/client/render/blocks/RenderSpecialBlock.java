package com.pommert.jedidiah.connectedtextures.client.render.blocks;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;

import com.pommert.jedidiah.connectedtextures.client.render.RenderUtils;
import com.pommert.jedidiah.connectedtextures.proxy.ProxyCommon;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSpecialBlock implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block block, int meta, int modelId,
			RenderBlocks render) {
		RenderUtils.renderInventoryBlock(block, meta, render);
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
			Block block, int modelId, RenderBlocks render) {
		return RenderBlocksControl.renderWorldBlock(world, x, y, z, block,
				modelId, render);
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return true;
	}

	@Override
	public int getRenderId() {
		return ProxyCommon.get().specialRenderID;
	}

}
