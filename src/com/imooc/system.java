package com.imooc;

public class system {

	public static Byte[] a = new Byte[4];

	public static Byte[] int2byte(int own) {
		for (int i = 0; i < 4; i++) {
			a[i] = (byte) (int) (own >> i * 8 & 0xff);
			System.out.println(a[i]);
		}
		return null;
	}

	public static int byte2int(Byte[] own) {
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			sum += ((int) own[i] & 0xff) << i * 8;
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k = 500;
		System.out.println(Integer.toBinaryString(k));
		System.out.println(Integer.toHexString(k));
		System.out.println(Integer.toOctalString(k));

		int2byte(k);

		System.out.println(byte2int(a));

		System.out.println(Integer.toBinaryString(a[0] & 0xff));
	}

}
