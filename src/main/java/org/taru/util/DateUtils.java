package org.taru.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	
	public  static Date toDate(String obj) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return  obj== null ? null :formatter.parse(obj);
	}
	public  static String toString(Date obj) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return  obj== null ? null :formatter.format(obj);
	}

}
