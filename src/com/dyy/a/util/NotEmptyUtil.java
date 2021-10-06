package com.dyy.a.util;

/**
 * 检查是否为空的工具类
 * @author 
 *
 */
public class NotEmptyUtil {
	
	/**
	 * 检查字符串是否为空
	 * @param str
	 * @return
	 */
	public static boolean StringNotEmpty(String str) {
		if(("".equals(str)) || (str == null)) {
			return false;
		} else {
			return true;
		}
	}
}
