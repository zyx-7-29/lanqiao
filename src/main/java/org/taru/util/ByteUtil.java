package org.taru.util;

public class ByteUtil {
	public static Byte toByte(Object obj) {
		return  obj== null ? 0 : Byte.valueOf(obj.toString());
	}

}
