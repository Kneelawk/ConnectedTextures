package com.pommert.jedidiah.connectedtextures.util;

public class BitUtils {
	public static int set0(int x, int bit) {
		return x & ~bit;
	}

	public static int set1(int x, int bit) {
		return x | bit;
	}

	public static int get(int x, int bit) {
		return x & bit;
	}

	public static boolean getb(int x, int bit) {
		return get(x, bit) == bit;
	}
}
