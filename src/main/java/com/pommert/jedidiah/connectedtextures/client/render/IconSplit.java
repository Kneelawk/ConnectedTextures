package com.pommert.jedidiah.connectedtextures.client.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.IIcon;

/**
 * Divides the icon into 6, 3, or 11 parts depending on if the icon type is
 * CONNECTED_TEXTURE, GLOWING, or GLOWING_CONNECTED_TEXTURE respectively.
 * 
 * @author Kneelawk
 *
 */
@SideOnly(Side.CLIENT)
public class IconSplit implements IIconArray {

	@SideOnly(Side.CLIENT)
	public IIcon icons;

	protected int offset;
	public int currentIndex;
	public int iconCount;

	public IconSplit(IIcon icons, int iconCount) {
		this.icons = icons;
		this.iconCount = iconCount;
	}

	@Override
	public void setCurrentIndex(int currentIndex) {
		this.currentIndex = currentIndex;
		offset = getSingleIconWidth(icons, iconCount) * currentIndex;
	}

	@Override
	public int getCurrentIndex() {
		return currentIndex;
	}

	@Override
	public int getIconCount() {
		return iconCount;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getIconWidth() {
		return getSingleIconWidth(icons, iconCount);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getIconHeight() {
		return icons.getIconHeight();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public float getMinU() {
		return offset + icons.getMinU();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public float getMaxU() {
		return offset + icons.getMaxU();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public float getInterpolatedU(double off) {
		return getMinU() + (getMaxU() - getMinU()) * ((float) off / 16f);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public float getMinV() {
		return icons.getMinV();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public float getMaxV() {
		return icons.getMaxV();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public float getInterpolatedV(double off) {
		return getMinV() + (getMaxV() - getMinV()) * ((float) off / 16f);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public String getIconName() {
		return icons.getIconName();
	}

	@SideOnly(Side.CLIENT)
	public int getIconWidth(int index) {
		setCurrentIndex(index);
		return getIconWidth();
	}

	@SideOnly(Side.CLIENT)
	public int getIconHeight(int index) {
		setCurrentIndex(index);
		return getIconHeight();
	}

	@SideOnly(Side.CLIENT)
	public float getMinU(int index) {
		setCurrentIndex(index);
		return getMinU();
	}

	@SideOnly(Side.CLIENT)
	public float getMaxU(int index) {
		setCurrentIndex(index);
		return getMaxU();
	}

	@SideOnly(Side.CLIENT)
	public float getInterpolatedU(int index, double d) {
		setCurrentIndex(index);
		return getInterpolatedU(d);
	}

	@SideOnly(Side.CLIENT)
	public float getMinV(int index) {
		setCurrentIndex(index);
		return getMinV();
	}

	@SideOnly(Side.CLIENT)
	public float getMaxV(int index) {
		setCurrentIndex(index);
		return getMaxV();
	}

	@SideOnly(Side.CLIENT)
	public float getInterpolatedV(int index, double d) {
		setCurrentIndex(index);
		return getInterpolatedV(d);
	}

	@SideOnly(Side.CLIENT)
	public String getIconName(int index) {
		setCurrentIndex(index);
		return getIconName();
	}

	public static int getSingleIconWidth(IIcon icons, int iconCount) {
		return icons.getIconWidth() / iconCount;
	}
}
