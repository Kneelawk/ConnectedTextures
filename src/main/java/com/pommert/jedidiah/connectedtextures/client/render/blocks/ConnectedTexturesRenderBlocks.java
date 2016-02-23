package com.pommert.jedidiah.connectedtextures.client.render.blocks;

import net.minecraft.block.Block;
import net.minecraft.util.IIcon;
import net.minecraftforge.common.util.ForgeDirection;

import com.pommert.jedidiah.connectedtextures.client.render.IIconArray;
import com.pommert.jedidiah.connectedtextures.client.render.IconSplit;
import com.pommert.jedidiah.connectedtextures.util.BitUtils;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ConnectedTexturesRenderBlocks extends BaseRenderBlocks {

	@Override
	public void renderFaceYNeg(Block block, double x, double y, double z,
			IIcon texture) {
		if (hasOverrideBlockTexture())
			texture = overrideBlockTexture;

		if (texture instanceof IIconArray) {
			IIconArray tex = (IIconArray) texture;
			if (tex.getIconCount() < 6)
				return;

			boolean oc = true;
			if (block instanceof IConnectedTexture)
				((IConnectedTexture) block).outlineConcaveEdges(blockAccess,
						(int) x, (int) y, (int) z, currentMeta, 0);
			int[] face = createFace(ForgeDirection.NORTH, ForgeDirection.WEST,
					ForgeDirection.DOWN, (int) x, (int) y, (int) z, oc);
			tex.setCurrentIndex(face[0] + 1);
			renderFace(tex, x, y, z, ForgeDirection.DOWN, new double[] { 0.5D,
					0D, 0.5D, 8D, 8D }, new double[] { 0.5D, 0D, 0D, 8D, 0D },
					new double[] { 1D, 0D, 0D, 16D, 0D }, new double[] { 1D,
							0D, 0.5D, 16D, 8D });
			tex.setCurrentIndex(face[1] + 1);
			renderFace(tex, x, y, z, ForgeDirection.DOWN, new double[] { 0D,
					0D, 0.5D, 0D, 8D }, new double[] { 0D, 0D, 0D, 0D, 0D },
					new double[] { 0.5D, 0D, 0D, 8D, 0D }, new double[] { 0.5D,
							0D, 0.5D, 8D, 8D });
			tex.setCurrentIndex(face[2] + 1);
			renderFace(tex, x, y, z, ForgeDirection.DOWN, new double[] { 0.5D,
					0D, 1D, 8D, 16D }, new double[] { 0.5D, 0D, 0.5D, 8D, 8D },
					new double[] { 1D, 0D, 0.5D, 16D, 8D }, new double[] { 1D,
							0D, 1D, 16D, 16D });
			tex.setCurrentIndex(face[3] + 1);
			renderFace(tex, x, y, z, ForgeDirection.DOWN, new double[] { 0D,
					0D, 1D, 0D, 16D }, new double[] { 0D, 0D, 0.5D, 0D, 8D },
					new double[] { 0.5D, 0D, 0.5D, 8D, 8D }, new double[] {
							0.5D, 0D, 1D, 8D, 16D });
			tex.setCurrentIndex(0);
		} else
			super.renderFaceYNeg(block, x, y, z, texture);
	}

	@Override
	public void renderFaceYPos(Block block, double x, double y, double z,
			IIcon texture) {
		if (hasOverrideBlockTexture())
			texture = overrideBlockTexture;

		if (texture instanceof IIconArray) {
			IIconArray tex = (IIconArray) texture;
			if (tex.getIconCount() < 6)
				return;

			boolean oc = true;
			if (block instanceof IConnectedTexture)
				((IConnectedTexture) block).outlineConcaveEdges(blockAccess,
						(int) x, (int) y, (int) z, currentMeta, 0);
			int[] face = createFace(ForgeDirection.NORTH, ForgeDirection.WEST,
					ForgeDirection.UP, (int) x, (int) y, (int) z, oc);
			tex.setCurrentIndex(face[0] + 1);
			renderFace(tex, x, y, z, ForgeDirection.UP, new double[] { 1D, 1D,
					0.5D, 16D, 8D }, new double[] { 1D, 1D, 0D, 16D, 0D },
					new double[] { 0.5D, 1D, 0D, 8D, 0D }, new double[] { 0.5D,
							1D, 0.5D, 8D, 8D });
			tex.setCurrentIndex(face[1] + 1);
			renderFace(tex, x, y, z, ForgeDirection.UP, new double[] { 0.5D,
					1D, 0.5D, 8D, 8D }, new double[] { 0.5D, 1D, 0D, 8D, 0D },
					new double[] { 0D, 1D, 0D, 0D, 0D }, new double[] { 0D, 1D,
							0.5D, 0D, 8D });
			tex.setCurrentIndex(face[2] + 1);
			renderFace(tex, x, y, z, ForgeDirection.UP, new double[] { 1D, 1D,
					1D, 16D, 16D }, new double[] { 1D, 1D, 0.5D, 16D, 8D },
					new double[] { 0.5D, 1D, 0.5D, 8D, 8D }, new double[] {
							0.5D, 1D, 1D, 8D, 16D });
			tex.setCurrentIndex(face[3] + 1);
			renderFace(tex, x, y, z, ForgeDirection.UP, new double[] { 0.5D,
					1D, 1D, 8D, 16D }, new double[] { 0.5D, 1D, 0.5D, 8D, 8D },
					new double[] { 0D, 1D, 0.5D, 0D, 8D }, new double[] { 0D,
							1D, 1D, 0D, 16D });
			tex.setCurrentIndex(0);
		} else
			super.renderFaceYPos(block, x, y, z, texture);
	}

	@Override
	public void renderFaceZNeg(Block block, double x, double y, double z,
			IIcon texture) {
		if (hasOverrideBlockTexture())
			texture = overrideBlockTexture;

		if (texture instanceof IIconArray) {
			IIconArray tex = (IIconArray) texture;
			if (tex.getIconCount() < 6)
				return;

			boolean oc = true;
			if (block instanceof IConnectedTexture)
				((IConnectedTexture) block).outlineConcaveEdges(blockAccess,
						(int) x, (int) y, (int) z, currentMeta, 0);
			int[] face = createFace(ForgeDirection.UP, ForgeDirection.EAST,
					ForgeDirection.NORTH, (int) x, (int) y, (int) z, oc);
			tex.setCurrentIndex(face[0] + 1);
			renderFace(tex, x, y, z, ForgeDirection.NORTH, new double[] { 0D,
					0.5D, 0D, 16D, 8D }, new double[] { 0D, 1D, 0D, 16D, 0D },
					new double[] { 0.5D, 1D, 0D, 8D, 0D }, new double[] { 0.5D,
							0.5D, 0D, 8D, 8D });
			tex.setCurrentIndex(face[1] + 1);
			renderFace(tex, x, y, z, ForgeDirection.NORTH, new double[] { 0.5D,
					0.5D, 0D, 8D, 8D }, new double[] { 0.5D, 1D, 0D, 8D, 0D },
					new double[] { 1D, 1D, 0D, 0D, 0D }, new double[] { 1D,
							0.5D, 0D, 0D, 8D });
			tex.setCurrentIndex(face[2] + 1);
			renderFace(tex, x, y, z, ForgeDirection.NORTH, new double[] { 0D,
					0D, 0D, 16D, 16D }, new double[] { 0D, 0.5D, 0D, 16D, 8D },
					new double[] { 0.5D, 0.5D, 0D, 8D, 8D }, new double[] {
							0.5D, 0D, 0D, 8D, 16D });
			tex.setCurrentIndex(face[3] + 1);
			renderFace(tex, x, y, z, ForgeDirection.NORTH, new double[] { 0.5D,
					0D, 0D, 8D, 16D }, new double[] { 0.5D, 0.5D, 0D, 8D, 8D },
					new double[] { 1D, 0.5D, 0D, 0D, 8D }, new double[] { 1D,
							0D, 0D, 0D, 16D });
			tex.setCurrentIndex(0);
		} else
			super.renderFaceZNeg(block, x, y, z, texture);
	}

	@Override
	public void renderFaceZPos(Block block, double x, double y, double z,
			IIcon texture) {
		if (hasOverrideBlockTexture())
			texture = overrideBlockTexture;

		if (texture instanceof IIconArray) {
			IIconArray tex = (IIconArray) texture;
			if (tex.getIconCount() < 6)
				return;

			boolean oc = true;
			if (block instanceof IConnectedTexture)
				((IConnectedTexture) block).outlineConcaveEdges(blockAccess,
						(int) x, (int) y, (int) z, currentMeta, 0);
			int[] face = createFace(ForgeDirection.UP, ForgeDirection.WEST,
					ForgeDirection.SOUTH, (int) x, (int) y, (int) z, oc);
			tex.setCurrentIndex(face[0] + 1);
			renderFace(tex, x, y, z, ForgeDirection.SOUTH, new double[] { 1D,
					0.5D, 1D, 16D, 8D }, new double[] { 1D, 1D, 1D, 16D, 0D },
					new double[] { 0.5D, 1D, 1D, 8D, 0D }, new double[] { 0.5D,
							0.5D, 1D, 8D, 8D });
			tex.setCurrentIndex(face[1] + 1);
			renderFace(tex, x, y, z, ForgeDirection.SOUTH, new double[] { 0.5D,
					0.5D, 1D, 8D, 8D }, new double[] { 0.5D, 1D, 1D, 8D, 0D },
					new double[] { 0D, 1D, 1D, 0D, 0D }, new double[] { 0D,
							0.5D, 1D, 0D, 8D });
			tex.setCurrentIndex(face[2] + 1);
			renderFace(tex, x, y, z, ForgeDirection.SOUTH, new double[] { 1D,
					0D, 1D, 16D, 16D }, new double[] { 1D, 0.5D, 1D, 16D, 8D },
					new double[] { 0.5D, 0.5D, 1D, 8D, 8D }, new double[] {
							0.5D, 0D, 1D, 8D, 16D });
			tex.setCurrentIndex(face[3] + 1);
			renderFace(tex, x, y, z, ForgeDirection.SOUTH, new double[] { 0.5D,
					0D, 1D, 8D, 16D }, new double[] { 0.5D, 0.5D, 1D, 8D, 8D },
					new double[] { 0D, 0.5D, 1D, 0D, 8D }, new double[] { 0D,
							0D, 1D, 0D, 16D });
			tex.setCurrentIndex(0);
		} else
			super.renderFaceZPos(block, x, y, z, texture);
	}

	@Override
	public void renderFaceXNeg(Block block, double x, double y, double z,
			IIcon texture) {
		if (hasOverrideBlockTexture())
			texture = overrideBlockTexture;

		if (texture instanceof IIconArray) {
			IIconArray tex = (IIconArray) texture;
			if (tex.getIconCount() < 6)
				return;

			boolean oc = true;
			if (block instanceof IConnectedTexture)
				((IConnectedTexture) block).outlineConcaveEdges(blockAccess,
						(int) x, (int) y, (int) z, currentMeta, 0);
			int[] face = createFace(ForgeDirection.UP, ForgeDirection.NORTH,
					ForgeDirection.WEST, (int) x, (int) y, (int) z, oc);
			tex.setCurrentIndex(face[0] + 1);
			renderFace(tex, x, y, z, ForgeDirection.WEST, new double[] { 0D,
					0.5D, 1D, 16D, 8D }, new double[] { 0D, 1D, 1D, 16D, 0D },
					new double[] { 0D, 1D, 0.5D, 8D, 0D }, new double[] { 0D,
							0.5D, 0.5D, 8D, 8D });
			tex.setCurrentIndex(face[1] + 1);
			renderFace(tex, x, y, z, ForgeDirection.WEST, new double[] { 0D,
					0.5D, 0.5D, 8D, 8D },
					new double[] { 0D, 1D, 0.5D, 8D, 0D }, new double[] { 0D,
							1D, 0D, 0D, 0D }, new double[] { 0D, 0.5D, 0D, 0D,
							8D });
			tex.setCurrentIndex(face[2] + 1);
			renderFace(tex, x, y, z, ForgeDirection.WEST, new double[] { 0D,
					0D, 1D, 16D, 16D }, new double[] { 0D, 0.5D, 1D, 16D, 8D },
					new double[] { 0D, 0.5D, 0.5D, 8D, 8D }, new double[] { 0D,
							0D, 0.5D, 8D, 16D });
			tex.setCurrentIndex(face[3] + 1);
			renderFace(tex, x, y, z, ForgeDirection.WEST, new double[] { 0D,
					0D, 0.5D, 8D, 16D },
					new double[] { 0D, 0.5D, 0.5D, 8D, 8D }, new double[] { 0D,
							0.5D, 0D, 0D, 8D }, new double[] { 0D, 0D, 0D, 0D,
							16D });
			tex.setCurrentIndex(0);
		} else
			super.renderFaceXNeg(block, x, y, z, texture);
	}

	@Override
	public void renderFaceXPos(Block block, double x, double y, double z,
			IIcon texture) {
		if (hasOverrideBlockTexture())
			texture = overrideBlockTexture;

		if (texture instanceof IIconArray) {
			IIconArray tex = (IIconArray) texture;
			if (tex.getIconCount() < 6)
				return;

			boolean oc = true;
			if (block instanceof IConnectedTexture)
				((IConnectedTexture) block).outlineConcaveEdges(blockAccess,
						(int) x, (int) y, (int) z, currentMeta, 0);
			int[] face = createFace(ForgeDirection.UP, ForgeDirection.SOUTH,
					ForgeDirection.EAST, (int) x, (int) y, (int) z, oc);
			tex.setCurrentIndex(face[0] + 1);
			renderFace(tex, x, y, z, ForgeDirection.EAST, new double[] { 1D,
					0.5D, 0D, 16D, 8D }, new double[] { 1D, 1D, 0D, 16D, 0D },
					new double[] { 1D, 1D, 0.5D, 8D, 0D }, new double[] { 1D,
							0.5D, 0.5D, 8D, 8D });
			tex.setCurrentIndex(face[1] + 1);
			renderFace(tex, x, y, z, ForgeDirection.EAST, new double[] { 1D,
					0.5D, 0.5D, 8D, 8D },
					new double[] { 1D, 1D, 0.5D, 8D, 0D }, new double[] { 1D,
							1D, 1D, 0D, 0D }, new double[] { 1D, 0.5D, 1D, 0D,
							8D });
			tex.setCurrentIndex(face[2] + 1);
			renderFace(tex, x, y, z, ForgeDirection.EAST, new double[] { 1D,
					0D, 0D, 16D, 16D }, new double[] { 1D, 0.5D, 0D, 16D, 8D },
					new double[] { 1D, 0.5D, 0.5D, 8D, 8D }, new double[] { 1D,
							0D, 0.5D, 8D, 16D });
			tex.setCurrentIndex(face[3] + 1);
			renderFace(tex, x, y, z, ForgeDirection.EAST, new double[] { 1D,
					0D, 0.5D, 8D, 16D },
					new double[] { 1D, 0.5D, 0.5D, 8D, 8D }, new double[] { 1D,
							0.5D, 1D, 0D, 8D }, new double[] { 1D, 0D, 1D, 0D,
							16D });
			tex.setCurrentIndex(0);
		} else
			super.renderFaceXPos(block, x, y, z, texture);
	}

	private boolean matches(int x, int y, int z) {
		Block block = blockAccess.getBlock(x, y, z);
		int meta = blockAccess.getBlockMetadata(x, y, z);
		return Block.isEqualTo(currentBlock, block) && currentMeta == meta;
	}

	private int[] createFace(ForgeDirection up, ForgeDirection left,
			ForgeDirection out, int x, int y, int z, boolean outlineConcave) {
		int[] face = { 0x1, 0x1, 0x1, 0x1 };

		ForgeDirection down = up.getOpposite(), right = left.getOpposite();

		// sides

		if (matches(right.offsetX + x, right.offsetY + y, right.offsetZ + z)
				&& !(outlineConcave && matches(right.offsetX + out.offsetX + x,
						right.offsetY + out.offsetY + y, right.offsetZ
								+ out.offsetZ + z))) {
			face[0] = 0x3;
			face[2] = 0x3;
		}

		if (matches(left.offsetX + x, left.offsetY + y, left.offsetZ + z)
				&& !(outlineConcave && matches(left.offsetX + out.offsetX + x,
						left.offsetY + out.offsetY + y, left.offsetZ
								+ out.offsetZ + z))) {
			face[1] = 0x3;
			face[3] = 0x3;
		}

		if (matches(up.offsetX + x, up.offsetY + y, up.offsetZ + z)
				&& !(outlineConcave && matches(up.offsetX + out.offsetX + x,
						up.offsetY + out.offsetY + y, up.offsetZ + out.offsetZ
								+ z))) {
			face[0] = BitUtils.set0(face[0], 0x1);
			face[0] = BitUtils.set1(face[0], 0x4);
			face[1] = BitUtils.set0(face[1], 0x1);
			face[1] = BitUtils.set1(face[1], 0x4);
		}

		if (matches(down.offsetX + x, down.offsetY + y, down.offsetZ + z)
				&& !(outlineConcave && matches(down.offsetX + out.offsetX + x,
						down.offsetY + out.offsetY + y, down.offsetZ
								+ out.offsetZ + z))) {
			face[2] = BitUtils.set0(face[2], 0x1);
			face[2] = BitUtils.set1(face[2], 0x4);
			face[3] = BitUtils.set0(face[3], 0x1);
			face[3] = BitUtils.set1(face[3], 0x4);
		}

		// corners

		if (BitUtils.getb(face[0], 0x6)) {
			if (matches(right.offsetX + up.offsetX + x, right.offsetY
					+ up.offsetY + y, right.offsetZ + up.offsetZ + z)
					&& !(outlineConcave && matches(right.offsetX + up.offsetX
							+ out.offsetX + x, right.offsetY + up.offsetY
							+ out.offsetY + y, right.offsetZ + up.offsetZ
							+ out.offsetZ + z))) {
				face[0] = 0x0;
			} else {
				face[0] = 0x2;
			}
		}

		if (BitUtils.getb(face[1], 0x6)) {
			if (matches(left.offsetX + up.offsetX + x, left.offsetY
					+ up.offsetY + y, left.offsetZ + up.offsetZ + z)
					&& !(outlineConcave && matches(left.offsetX + up.offsetX
							+ out.offsetX + x, left.offsetY + up.offsetY
							+ out.offsetY + y, left.offsetZ + up.offsetZ
							+ out.offsetZ + z))) {
				face[1] = 0x0;
			} else {
				face[1] = 0x2;
			}
		}

		if (BitUtils.getb(face[2], 0x6)) {
			if (matches(right.offsetX + down.offsetX + x, right.offsetY
					+ down.offsetY + y, right.offsetZ + down.offsetZ + z)
					&& !(outlineConcave && matches(right.offsetX + down.offsetX
							+ out.offsetX + x, right.offsetY + down.offsetY
							+ out.offsetY + y, right.offsetZ + down.offsetZ
							+ out.offsetZ + z))) {
				face[2] = 0x0;
			} else {
				face[2] = 0x2;
			}
		}

		if (BitUtils.getb(face[3], 0x6)) {
			if (matches(left.offsetX + down.offsetX + x, left.offsetY
					+ down.offsetY + y, left.offsetZ + down.offsetZ + z)
					&& !(outlineConcave && matches(left.offsetX + down.offsetX
							+ out.offsetX + x, left.offsetY + down.offsetY
							+ out.offsetY + y, left.offsetZ + down.offsetZ
							+ out.offsetZ + z))) {
				face[3] = 0x0;
			} else {
				face[3] = 0x2;
			}
		}

		return face;
	}
}
