package org.taru.util;


/**
 * 
 * �ַ���������
 * @author zyx3.2
 *
 */
public class StringUtil {
	/**
	 * �Ѷ���ת�����ַ���
	 * @param obj
	 * @return
	 */
	public static String valueOf(Object obj) {
		if(obj!=null) {
			return obj.toString();
		}
		return null;
	}
	
}
