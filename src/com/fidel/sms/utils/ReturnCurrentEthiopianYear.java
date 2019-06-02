package com.fidel.sms.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ReturnCurrentEthiopianYear {

	public static String getCurrentEthiopianYear() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = new GregorianCalendar();
		cal.setTime(new Date());

		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int year = cal.get(Calendar.YEAR);

		String curDate = day + "-" + month + "-" + year;
		String yr = DateConvertor.dateConvertor(curDate);
		
		if(month > 5 && month < 8){
			yr = String.valueOf(Integer.parseInt(yr) + 1);
		}
		
		return yr;
	}
	
	public static String getActualCurrentEthiopianYear() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = new GregorianCalendar();
		cal.setTime(new Date());

		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int year = cal.get(Calendar.YEAR);

		String curDate = day + "-" + month + "-" + year;
		String yr = DateConvertor.dateConvertor(curDate);
		
		return yr;
	}

}
