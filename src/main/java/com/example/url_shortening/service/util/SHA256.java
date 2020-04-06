package com.example.url_shortening.service.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256 {
	final private static String ALGORITHM = "SHA-256";

	public String encode(byte[] param) throws NoSuchAlgorithmException {
		MessageDigest messageDigest;
		String endcoding = null;
		try {
			messageDigest = MessageDigest.getInstance(ALGORITHM);

			byte[] hash = messageDigest.digest(param);
			StringBuffer sb = new StringBuffer();

			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if (hex.length() == 1) {
					sb.append('0');
				}
				sb.append(hex);
			}
			endcoding = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			throw new NoSuchAlgorithmException(ALGORITHM + " is not a proper algorithm.");
		}
		return endcoding;
	}
}
