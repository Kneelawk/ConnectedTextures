package com.pommert.jedidiah.connectedtextures.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.oredict.OreDictionary;

import com.pommert.jedidiah.connectedtextures.ref.RefMod;
import com.pommert.jedidiah.connectedtextures.ref.RefName;

import cpw.mods.fml.common.registry.GameRegistry;

public class CTBlocks {
	public static Block blockConnectedTextureGlass;
	public static Block blockConnectedTextureBrick;
	public static Block blockGlowingTile;
	public static Block blockDiscoFloor;
	public static Block blockFancyLight;

	public static void init() {
		blockConnectedTextureGlass = initBlock(
				new BlockConnectedTextureGlass(Material.glass),
				RefName.Blocks.BLOCK_CONNECTED_TEXTURE_GLASS,
				CreativeTabs.tabDecorations, true)
				.setStepSound(Block.soundTypeGlass).setLightOpacity(0)
				.setHardness(1F);
		blockConnectedTextureBrick = initBlock(
				new BlockConnectedTextureBrick(Material.rock),
				RefName.Blocks.BLOCK_CONNECTED_TEXTURE_BRICK,
				CreativeTabs.tabBlock, true).setHardness(1F);
		blockGlowingTile = initBlock(new BlockGlowingTile(Material.wood),
				RefName.Blocks.BLOCK_GLOWING_TILE, CreativeTabs.tabDecorations,
				true).setStepSound(Block.soundTypeGlass).setLightLevel(0.8F)
				.setHardness(1F);
		blockDiscoFloor = initBlock(new BlockDiscoFloor(Material.glass),
				RefName.Blocks.BLOCK_DISCO_FLOOR, CreativeTabs.tabDecorations,
				true).setStepSound(Block.soundTypeGlass).setLightLevel(0.7F)
				.setHardness(1F);
		blockFancyLight = initBlock(
				new BlockWithTileEntity(
						RefName.TileEntities.TILE_ENTITY_FANCY_LIGHT, -1,
						Material.glass), RefName.Blocks.BLOCK_FANCY_LIGHT,
				CreativeTabs.tabDecorations, true).setLightLevel(0.7f);
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
