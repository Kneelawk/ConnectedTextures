package com.pommert.jedidiah.connectedtextures.client.render;

import net.minecraft.util.IIcon;

public interface IIconArray extends IIcon {
	public abstract void setCurrentIndex(int currentIndex);

	public abstract int getCurrentIndex();

	public abstract int getIconCount();
}
