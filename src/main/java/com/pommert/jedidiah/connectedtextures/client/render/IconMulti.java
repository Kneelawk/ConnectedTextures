package com.pommert.jedidiah.connectedtextures.client.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.IIcon;

@SideOnly(Side.CLIENT)
public class IconMulti implements IIcon {

	@SideOnly(Side.CLIENT)
	public IIcon[] icons;

	public int currentType;

	public IconMulti(IIcon[] icons) {
		this.icons = icons;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getIconWidth() {
		return icons[currentType].getIconWidth();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getIconHeight() {
		return icons[currentType].getIconHeight();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public float getMinU() {
		return icons[currentType].getMinU();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public float getMaxU() {
		return icons[currentType].getMaxU();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public float getInterpolatedU(double d) {
		return getMinU() + (getMaxU() - getMinU()) * ((float) d / 16f);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public float getMinV() {
		return icons[currentType].getMinV();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public float getMaxV() {
		return icons[currentType].getMaxV();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public float getInterpolatedV(double d) {
		return getMinV() + (getMaxV() - getMinV()) * ((float) d / 16f);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public String getIconName() {
		return icons[currentType].getIconName();
	}

	@SideOnly(Side.CLIENT)
	public int getIconWidth(int type) {
		currentType = type;
		return getIconWidth();
	}

	@SideOnly(Side.CLIENT)
	public int getIconHeight(int type) {
		currentType = type;
		return getIconHeight();
	}

	@SideOnly(Side.CLIENT)
	public float getMinU(int type) {
		currentType = type;
		return getMinU();
	}

	@SideOnly(Side.CLIENT)
	public float getMaxU(int type) {
		currentType = type;
		return getMaxU();
	}

	@SideOnly(Side.CLIENT)
	public float getInterpolatedU(int type, double d) {
		currentType = type;
		return getInterpolatedU(d);
	}

	@SideOnly(Side.CLIENT)
	public float getMinV(int type) {
		currentType = type;
		return getMinV();
	}

	@SideOnly(Side.CLIENT)
	public float getMaxV(int type) {
		currentType = type;
		return getMaxV();
	}

	@SideOnly(Side.CLIENT)
	public float getInterpolatedV(int type, double d) {
		currentType = type;
		return getInterpolatedV(d);
	}

	@SideOnly(Side.CLIENT)
	public String getIconName(int type) {
		currentType = type;
		return getIconName();
	}
}
