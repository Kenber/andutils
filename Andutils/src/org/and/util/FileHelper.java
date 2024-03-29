/*
 * Copyright (C) 2012 The Health Platform Project
 *
 * 中民康寿网络科技发展有限公司. All rights reserved.
 */
package org.and.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * TODO: 用一句话描述这个类(接口)的作用
 *
 * @author dai.rui.lin
 * @date 2012-7-31 上午11:22:52
 */
public class FileHelper {
	
	public static String getSuffix(File file) {
		final String path = file.getAbsolutePath();
		int lastDot = path.lastIndexOf('.');

		return (lastDot >= 0) ? path.substring(lastDot+1) : "";
	}

	public static String getSuffix(String filename) {
		if ((filename != null) && (filename.length() > 0)) {
			int dot = filename.lastIndexOf('.');
			if ((dot > -1) && (dot < (filename.length() - 1))) {
				return filename.substring(dot + 1);
			}
		}
		return filename;
	}
	/**
	 * 文件名字编码,采用SHA-1加密方式加密
	 * */
	public static String enFileName(String objName){
		MessageDigest mDigest = null;
		try {
			mDigest = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		mDigest.update(objName.getBytes());
		return StringHelper.bytesToHexString(mDigest.digest());
	}

}
