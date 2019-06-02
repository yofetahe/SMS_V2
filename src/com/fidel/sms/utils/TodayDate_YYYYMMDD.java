package com.fidel.sms.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.fidel.sms.utils.DateConvertor;

public class TodayDate_YYYYMMDD {
	
	public static String getToday(){
		
		// SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = new GregorianCalendar();
		cal.setTime(new Date());

		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int year = cal.get(Calendar.YEAR);

		String curDate = year + "-" + (month + 1) + "-" + day;
		
		return curDate;
	}
	
	public static String getTodayDayMonthYearFormat(){
		
		Calendar cal = new GregorianCalendar();
		cal.setTime(new Date());

		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int year = cal.get(Calendar.YEAR);

		String curDate = day + "-" + month + "-" + year;
		
		return curDate;
	}
	
	public static String getTodayDayMonthYearWithMonthNameFormat(){
		
		String[] g_months = new String[]{"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
		
		Calendar cal = new GregorianCalendar();
		cal.setTime(new Date());

		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int year = cal.get(Calendar.YEAR);

		String curDate = day + "-" + g_months[month] + "-" + year;
		
		return curDate;
	}
	
	public static String getDayMonthYearFormat(){
		
		Calendar cal = new GregorianCalendar();
		cal.setTime(new Date());

		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int year = cal.get(Calendar.YEAR);

		String curDate = day + "-" + (month+1) + "-" + year;
		
		return curDate;
	}
	
	public static String getDayMonthYearFormat(String date){
		
		String curDate = "";
		
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date dt = sdf.parse(date);
			Calendar cal = new GregorianCalendar();
			cal.setTime(dt);
	
			int month = cal.get(Calendar.MONTH);
			int day = cal.get(Calendar.DAY_OF_MONTH);
			int year = cal.get(Calendar.YEAR);
	
			curDate = day + "-" + (month+1) + "-" + year;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return curDate;
	}
	
	public static String getHour(){
		String time = "";
		
		Calendar cal = new GregorianCalendar();
		cal.setTime(new Date());
		
		String hour = String.valueOf(cal.get(Calendar.HOUR));
		String min = cal.get(Calendar.MINUTE) > 10?String.valueOf(cal.get(Calendar.MINUTE)):"0"+String.valueOf(cal.get(Calendar.MINUTE));
		String sec = cal.get(Calendar.SECOND) > 10?String.valueOf(cal.get(Calendar.SECOND)):"0"+String.valueOf(cal.get(Calendar.SECOND));
		int tzone = cal.get(Calendar.AM_PM);
		String t_zone = "";

		if(tzone == 0){ 
			t_zone = " AM";
		} else if(tzone == 1){
			t_zone = " PM";
		}
		
		time = hour + ":" + min + ":" + sec + t_zone;
		
		return time;
	}
	
	public static String getNameOfDay(String date){
		String dayName = "";
		String pdate = date;
		
		DateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		Date dt = new Date();
		try {
			dt = sdf.parse(pdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar cal = new GregorianCalendar();
		cal.setTime(dt);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		
		switch(dayOfWeek){
			case 1: dayName = "Sunday";
			break;
			case 2: dayName = "Monday";
			break;
			case 3: dayName = "Tuesday";
			break;
			case 4: dayName = "Wednesday";
			break;
			case 5: dayName = "Thursday";
			break;
			case 6: dayName = "Friday";
			break;
			case 7: dayName = "Saturday";
			break;			
		}
		
		return dayName;
	}

	public static String getCurrentEthiopianYear() {
		
		//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
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
