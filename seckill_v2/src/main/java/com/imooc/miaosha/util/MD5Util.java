package com.imooc.miaosha.util;

import org.apache.commons.codec.digest.DigestUtils;

public abstract class MD5Util {
	
	public static String md5(String src) {
		return DigestUtils.md5Hex(src);
	}
	
	private static final Character[] SALT = {'1','a','2','b','3','c','4','d'};
	
	public static String inputPassToFormPass(String inputPass) {
		String str = SALT[0] + SALT[2] + inputPass + SALT[5] + SALT[4];
		return md5(str);
	}
	
	public static String formPassToDBPass(String formPass, String salt) {
		String str = salt.charAt(0) + salt.charAt(2) + formPass + salt.charAt(5) + salt.charAt(4);
		return md5(str);
	}
	
	public static String inputPassToDbPass(String inputPass, String saltDB) {
		String formPass = inputPassToFormPass(inputPass);
		return formPassToDBPass(formPass, saltDB);
	}
	
	public static void main(String[] args) {
		System.out.println(inputPassToFormPass("123456"));//d3b1294a61a07da9b49b6e22b2cbd7f9
//		System.out.println(formPassToDBPass(inputPassToFormPass("123456"), "1a2b3c4d"));
//		System.out.println(inputPassToDbPass("123456", "1a2b3c4d"));//b7797cce01b4b131b433b6acf4add449
	}
	
}
