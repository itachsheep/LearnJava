
package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	static String TAG = MD5.class.getSimpleName();

	private static String createMd5(String str) {
		MessageDigest mMDigest;
		FileInputStream Input;
		File file = new File(str);
		byte buffer[] = new byte[1024];
		int len;
		if (!file.exists())
			return null;
		try {
			mMDigest = MessageDigest.getInstance("MD5");
			Input = new FileInputStream(file);
			while ((len = Input.read(buffer, 0, 1024)) != -1) {
				mMDigest.update(buffer, 0, len);
			}
			Input.close();
		} catch (NoSuchAlgorithmException e) {
			System.out.println("createMd5() NoSuchAlgorithmException = " + e.getMessage());
			e.printStackTrace();
			return null;
		} catch (FileNotFoundException e) {
			System.out.println( "createMd5() FileNotFoundException = " + e.getMessage());
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			System.out.println( "createMd5() IOException = " + e.getMessage());
			e.printStackTrace();
			return null;
		}
		BigInteger mBInteger = new BigInteger(1, mMDigest.digest());
		System.out.println( "create_MD5=" + mBInteger.toString(16));
		return mBInteger.toString(16);

	}

	public static boolean checkMd5(String Md5, String file) {
		String str = createMd5(file);
		System.out.println( "md5sum = " + str);
		if (Md5.compareTo(str) == 0)
			return true;
		else
			return false;
	}

	public static String digest(File file) {
		String value = null;
		FileInputStream in = null;
		try {
			in = new FileInputStream(file);
			// MappedByteBuffer byteBuffer =
			// in.getChannel().map(FileChannel.MapMode.READ_ONLY, 0,
			// file.length());
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] buff = new byte[1024];
			int i = -1;
			while ((i = in.read(buff)) != -1) {
				md5.update(buff, 0, i);
			}
			// md5.update(byteBuffer);
			BigInteger bi = new BigInteger(1, md5.digest());
			value = bi.toString(16);
		} catch (Exception e) {
			System.out.println("digest() Exception = " + e.getMessage());
			e.printStackTrace();
		} finally {
			if (null != in) {
				try {
					in.close();
				} catch (IOException e) {
					System.out.println("digest() IOException = " + e.getMessage());
					e.printStackTrace();
				}
			}
		}
		return value;
	}

	public static String toHexString(byte[] b) {
		final char hexChars[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

		if (b != null) {
			int length = b.length;
			if (length > 0) {
				StringBuilder sb = new StringBuilder(2 * length);

				for (int i = 0; i < length; ++i) {
					byte h = (byte) ((b[i] & 0xF0) >> 4);
					byte l = (byte) (b[i] & 0x0F);

					sb.append(hexChars[h]);
					sb.append(hexChars[l]);
				}

				return sb.toString();
			} else {
				return "";
			}
		}

		return null;
	}

	public static String md5Sum(String str) {
		System.out.println("md5Sum "+",uptimeMillis:" + System.currentTimeMillis()/1000);
		MessageDigest mMDigest;
		FileInputStream Input;
		File file = new File(str);
		byte buffer[] = new byte[1024];
		int len;
		if (!file.exists())
			return null;
		try {
			mMDigest = MessageDigest.getInstance("MD5");
			Input = new FileInputStream(file);
			while ((len = Input.read(buffer, 0, 1024)) != -1) {
				mMDigest.update(buffer, 0, len);
			}
			Input.close();
		} catch (NoSuchAlgorithmException e) {
			System.out.println("md5Sum() NoSuchAlgorithmException = " + e.getMessage());
			e.printStackTrace();
			return null;
		} catch (FileNotFoundException e) {
			System.out.println("md5Sum() FileNotFoundException = " + e.getMessage());
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			System.out.println( "md5Sum() IOException = " + e.getMessage());
			e.printStackTrace();
			return null;
		}
		System.out.println("md5Sum tohexstring , uptimeMillis:" + System.currentTimeMillis() /1000 );
		String res = toHexString(mMDigest.digest());
		System.out.println("md5Sum res:"+res+", uptimeMillis:" + System.currentTimeMillis() /1000 );
		return res;
	}
}
