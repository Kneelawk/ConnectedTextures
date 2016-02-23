package com.pommert.jedidiah.connectedtextures.client.render;

import net.minecraft.util.IIcon;

public class IconMulti implements IIconArray {

	public int index;
	public IIcon[] icons;

	public IconMulti(IIcon... icons) {
		this.icons = icons;
	}

	@Override
	public int getIconWidth() {
		return icons[index].getIconWidth();
	}

	@Override
	public int getIconHeight() {
		return icons[index].getIconHeight();
	}

	@Override
	public float getMinU() {
		return icons[index].getMinU();
	}

	@Override
	public float getMaxU() {
		return icons[index].getMaxU();
	}

	@Override
	public float getInterpolatedU(double off) {
		return getMinU() + (getMaxU() - getMinU()) * ((float) off / 16f);
	}

	@Override
	public float getMinV() {
		return icons[index].getMinV();
	}

	@Override
	public float getMaxV() {
		return icons[index].getMaxV();
	}

	@Override
	public float getInterpolatedV(double off) {
		return getMinV() + (getMaxV() - getMinV()) * ((float) off / 16f);
	}

	@Override
	public String getIconName() {
		return icons[index].getIconName();
	}

	@Override
	public void setCurrentIndex(int currentIndex) {
		int i = 0;
		for (; i < icons.length && currentIndex >= 0; i++) {
			IIcon icon = icons[i];
			if (icon instanceof IIconArray) {
				IIconArray ia = (IIconArray) icon;
				if (ia.getIconCount() > currentIndex) {
					ia.setCurrentIndex(currentIndex);
					currentIndex = -1;
				} else {
					currentIndex -= ia.getIconCount();
				}
			} else {
				currentIndex--;
			}
		}
		i -= 1;
		if (i >= 0)
			this.index = i;
	}

	@Override
	public int getCurrentIndex() {
		return index;
	}

	@Override
	public int getIconCount() {
		int count = 0;
		for (IIcon icon : icons) {
			if (icon instanceof IIconArray) {
				count += ((IIconArray) icon).getIconCount();
			} else {
				count++;
			}
		}
		return count;
	}

}
