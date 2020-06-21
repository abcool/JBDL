package com.abcool.Library.Management.System.utilities;


import java.text.SimpleDateFormat;
import java.util.Date;


public class StringToDateConverter {

	public static Date stringToDateConverter(String date) {
		try {
		Date date1=new SimpleDateFormat("dd-MM-yyyy").parse(date);
		return date1;
		}catch(Exception e) {
			System.out.println("Exception occured while converting string to date");
			return null;
		}
	}
}
