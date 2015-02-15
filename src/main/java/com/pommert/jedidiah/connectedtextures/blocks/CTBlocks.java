package com.pommert.jedidiah.connectedtextures.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.oredict.OreDictionary;

import com.pommert.jedidiah.connectedtextures.ref.RefMod;

import cpw.mods.fml.common.registry.GameRegistry;

public class CTBlocks {
	public static Block blockConnectedTextureGlass;
	public static Block blockConnectedTextureBrick;
	public static Block blockGlowingTile;

	public static void init() {
		blockConnectedTextureGlass = initBlock(
				new BlockConnectedTextureGlass(Material.glass),
				"blockConnectedTextureGlass", CreativeTabs.tabDecorations, true)
				.setStepSound(Block.soundTypeGlass).setLightOpacity(0);
		blockConnectedTextureBrick = initBlock(new BlockConnectedTextureBrick(
				Material.rock), "blockConnectedTextureBrick",
				CreativeTabs.tabBlock, true);
		blockGlowingTile = initBlock(new BlockGlowingTile(Material.glass),
				"blockGlowingTile", CreativeTabs.tabDecorations, true)
				.setLightLevel(0.7F);
	}

	public static Block initBlock(Block block, String name, CreativeTabs tab,
			boolean oredict) {
		block.setBlockName(name);
		block.setBlockTextureName(RefMod.MOD_ID + ":" + name);
		if (!Block
				.isEqualTo(GameRegistry.findBlock(RefMod.MOD_ID, name), block)) {
			GameRegistry.registerBlock(block, name);
		}
		if (oredict) {
			OreDictionary.registerOre(name, block);
		}
		if (tab != null) {
			block.setCreativeTab(tab);
		}
		return block;
	}
}
