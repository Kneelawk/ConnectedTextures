package com.pommert.jedidiah.connectedtextures.client.render.texture;

import java.awt.image.BufferedImage;
import java.awt.image.RasterFormatException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

import javax.imageio.ImageIO;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.resources.IResource;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.data.AnimationFrame;
import net.minecraft.client.resources.data.AnimationMetadataSection;
import net.minecraft.client.resources.data.TextureMetadataSection;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.util.IIcon;
import net.minecraft.util.ReportedException;
import net.minecraft.util.ResourceLocation;

import org.apache.logging.log4j.Level;

import com.google.common.collect.Lists;
import com.pommert.jedidiah.connectedtextures.log.CTLog;
import com.pommert.jedidiah.connectedtextures.ref.RefMod;

/*
 * A Large amount of this code was copied from CovertJaguar's RailCraft's TextureAtlasSheet.
 * Github Site URL: https://github.com/CovertJaguar/Railcraft
 * Github File URL: https://github.com/CovertJaguar/Railcraft/blob/master/src/main/java/mods/railcraft/client/util/textures/TextureAtlasSheet.java
 * License URL: https://github.com/CovertJaguar/Railcraft/blob/master/LICENSE.md
 */
public class TextureAtlasUnstitched extends TextureAtlasSprite {

	public static final String BASE_NAME_BLOCKS = "textures/blocks";
	public static final String BASE_NAME_ITEMS = "textures/items";

	public static TextureAtlasUnstitched registerIcon(IIconRegister ir,
			String name, String baseName, int index, int cols, int rows) {
		TextureAtlasUnstitched tex = new TextureAtlasUnstitched(name, baseName,
				index, cols, rows, useAnisotropicFiltering(ir));
		((TextureMap) ir).setTextureEntry(name, tex);
		return tex;
	}

	protected static boolean useAnisotropicFiltering(IIconRegister ir) {
		try {
			Field f = TextureMap.class.getDeclaredField("anisotropicFiltering");
			f.setAccessible(true);
			return f.getFloat(ir) > 1.0f;
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static IIcon[] registerIcons(IIconRegister ir, String name,
			String baseName, int cols, int rows) {
		int numIcons = rows * cols;
		IIcon[] icons = new IIcon[numIcons];
		for (int i = 0; i < numIcons; i++) {
			String texName = name + "." + i;
			IIcon texture = registerIcon(ir, texName, baseName, i, cols, rows);
			icons[i] = texture;
		}
		return icons;
	}

	public static IIcon[] registerIcons(IIconRegister ir, String name,
			String baseName, int numIcons) {
		return registerIcons(ir, name, baseName, numIcons, 1);
	}

	protected boolean useAnisotropicFiltering;

	protected int index;
	protected int cols;
	protected int rows;

	protected String baseName;

	public TextureAtlasUnstitched(String name, String baseName, int index,
			int cols, int rows, boolean useAnisotropicFiltering) {
		super(name);
		this.index = index;
		this.cols = cols;
		this.rows = rows;
		this.baseName = baseName;

		this.useAnisotropicFiltering = useAnisotropicFiltering;
	}

	public boolean hasCustomLoader(IResourceManager manager,
			ResourceLocation location) {
		return true;
	}

	public boolean load(IResourceManager manager, ResourceLocation location) {
		location = new ResourceLocation(location.getResourceDomain(), location
				.getResourcePath().replace("." + index, ""));
		int split = location.getResourcePath().indexOf(':');
		if (split != -1)
			location = new ResourceLocation(location.getResourceDomain(),
					location.getResourcePath().substring(0, split));
		location = new ResourceLocation(location.getResourceDomain(),
				"textures/blocks/" + location.getResourcePath() + ".png");

		BufferedImage image;
		IResource resource = null;
		AnimationMetadataSection animateMeta = null;
		TextureMetadataSection textureMeta = null;
		try {
			resource = manager.getResource(location);
			image = ImageIO.read(resource.getInputStream());
			animateMeta = (AnimationMetadataSection) resource
					.getMetadata("animation");
			textureMeta = (TextureMetadataSection) resource
					.getMetadata("texture");
		} catch (IOException ex) {
			CTLog.log(Level.WARN, "Failed to load sub-texture from {0}: {1}",
					location.getResourcePath(), ex.getLocalizedMessage());
			return true;
		} finally {
			if (resource != null)
				try {
					resource.getInputStream().close();
				} catch (IOException e) {
				}
		}

		int mipmapLevels = Minecraft.getMinecraft().gameSettings.mipmapLevels;

		int height = image.getHeight() / rows;
		int width = image.getWidth() / cols;
		int x = index % cols;
		int y = index / cols;

		BufferedImage[] subImages = new BufferedImage[mipmapLevels + 1];
		try {
			subImages[0] = image.getSubimage(x * width, y * height, width,
					height);
		} catch (RasterFormatException ex) {
			CTLog.log(Level.WARN,
					"Failed to load sub-texture from {0} - {1}x{2}: {3}",
					location.getResourcePath(), image.getWidth(),
					image.getHeight(), ex.getLocalizedMessage());
			return true;
		}

		if (textureMeta != null) {
			List list = textureMeta.getListMipmaps();
			for (Object o : list) {
				int i = ((Integer) o).intValue();
				if (i > 0 && i < subImages.length - 1 && subImages[i] == null) {
					ResourceLocation mipmapLoc = completeResourceLocation(
							location, i);
					try {
						image = ImageIO.read(manager.getResource(mipmapLoc)
								.getInputStream());
						subImages[i] = image.getSubimage(x * width, y * height,
								width, height);
					} catch (IOException e) {
						CTLog.log(Level.WARN,
								"Unable to load mipmap level {} from {}", i,
								mipmapLoc, e);
					}
				}
			}
		}

		loadSprite(subImages, animateMeta, useAnisotropicFiltering);
		return false;
	}

	protected ResourceLocation completeResourceLocation(
			ResourceLocation p_147634_1_, int p_147634_2_) {
		return p_147634_2_ == 0 ? new ResourceLocation(
				p_147634_1_.getResourceDomain(), String.format("%s/%s%s",
						new Object[] { baseName, p_147634_1_.getResourcePath(),
								".png" })) : new ResourceLocation(
				p_147634_1_.getResourceDomain(), String.format(
						"%s/mipmaps/%s.%d%s",
						new Object[] { baseName, p_147634_1_.getResourcePath(),
								Integer.valueOf(p_147634_2_), ".png" }));
	}
}
