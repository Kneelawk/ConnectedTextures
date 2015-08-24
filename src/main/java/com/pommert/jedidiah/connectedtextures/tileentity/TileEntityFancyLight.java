package com.pommert.jedidiah.connectedtextures.tileentity;

import java.util.Random;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagIntArray;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityFancyLight extends TileEntity {
	/**
	 * The number of ticks between client/server re-syncs. Update once every 10
	 * minutes.
	 */
	private static final int MAX_UPDATE_WAIT = 12000;

	public static Random rng = new Random();

	public float ri = -0.01f, gi = -0.01f, bi = -0.01f;
	public float r = 1f, g = 1f, b = 1f;
	private int lastUpdate = 0;

	public TileEntityFancyLight() {
	}

	@Override
	public void updateEntity() {
		if (!worldObj.isRemote) {
			if (lastUpdate <= 0) {
				worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
				lastUpdate = MAX_UPDATE_WAIT;
			} else {
				lastUpdate--;
			}
		}
		r += ri;
		g += gi;
		b += bi;
		if (r <= 0) {
			r = 0;
			ri = Math.abs(ri);
		} else if (r >= 1) {
			r = 1;
			ri = -Math.abs(ri);
		}
		if (g <= 0) {
			g = 0;
			gi = Math.abs(gi);
		} else if (g >= 1) {
			g = 1;
			gi = -Math.abs(gi);
		}
		if (b <= 0) {
			b = 0;
			bi = Math.abs(bi);
		} else if (b >= 1) {
			b = 1;
			bi = -Math.abs(bi);
		}
	}

	@Override
	public void validate() {
		if (!worldObj.isRemote) {
			ri = (rng.nextFloat() * 0.03f + 0.001f)
					* (rng.nextBoolean() ? 1 : -1);
			gi = (rng.nextFloat() * 0.03f + 0.001f)
					* (rng.nextBoolean() ? 1 : -1);
			bi = (rng.nextFloat() * 0.03f + 0.001f)
					* (rng.nextBoolean() ? 1 : -1);
			r = rng.nextFloat();
			g = rng.nextFloat();
			b = rng.nextFloat();
		}
		super.validate();
	}

	@Override
	public void readFromNBT(NBTTagCompound root) {
		super.readFromNBT(root);
		readData(root);
	}

	@Override
	public void writeToNBT(NBTTagCompound root) {
		super.writeToNBT(root);
		writeData(root);
	}

	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound root = new NBTTagCompound();
		writeData(root);
		return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 0, root);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		readData(pkt.func_148857_g());
	}

	protected void writeData(NBTTagCompound root) {
		int[] colors = new int[] { Float.floatToIntBits(ri),
				Float.floatToIntBits(gi), Float.floatToIntBits(bi),
				Float.floatToIntBits(r), Float.floatToIntBits(g),
				Float.floatToIntBits(b) };
		root.setIntArray("C", colors);
	}

	protected void readData(NBTTagCompound root) {
		int[] colors = root.getIntArray("C");
		ri = Float.intBitsToFloat(colors[0]);
		gi = Float.intBitsToFloat(colors[1]);
		bi = Float.intBitsToFloat(colors[2]);
		r = Float.intBitsToFloat(colors[3]);
		g = Float.intBitsToFloat(colors[4]);
		b = Float.intBitsToFloat(colors[5]);
	}
}
