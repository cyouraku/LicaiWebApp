package com.costuary.util;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.TimeZone;

public class DateUtil_backup {

	/*
	 * Get specify date in ISO_DATE format
	 * return java.sql.Date
	 */
	public static Date getDateFormatted(String specifyDate){
//		String specifyDate = "2017-06-30";
		DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;//"YYYY-MM-dd"
		LocalDate formatted = LocalDate.parse(specifyDate,formatter);
//		System.out.println(formatted.toString());
		Date date = Date.valueOf(formatted);
		return date;
	}

	/*
	 * parse string "yyyy-mm-dd" to Date in Java7
	 * return java.sql.Date
	 */
//	public static Date getDateFormatted(String specifyDate) throws ParseException{
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		Date date = (Date) sdf.parse(specifyDate);
//		return date;
//	}

	/*
	 * parse java.sql.Date to String in pattern "yyyy-mm-dd"
	 * return java.sql.Date
	 */
	public static String parseSqlDateToStringFmt(java.sql.Date date){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(date);
	}

	/**
	 * parse string with pattern "dd/MM/yyyy" to ISO date pattern "yyyy-MM-dd"
	 * @param dateStr
	 * @return
	 */
	public static String parseToISOtimeFomart(String dateStr){
		String dateISO = "";
		//get day
		String m = dateStr.substring(0,dateStr.indexOf("/"));//substring(0,2)
		//get month
		String d = dateStr.substring(dateStr.indexOf("/") + 1,dateStr.indexOf("/") + 3);//substring(3,5)
		//get year
		String y = dateStr.substring(dateStr.indexOf("/") + 4,dateStr.indexOf("/") + 8);//substring(6,10)
		dateISO = y + "-" + m + "-" + d;
		return dateISO;
	}


	//Parse sql.timestamp.getTime() to java.util.Date and then set to "Asia/Tokyo" timezone and save as String
	public static String parseTimeFormat(java.sql.Timestamp sqlTime){
		String dateStrTmp = "";
		java.util.Date timeDate = new java.util.Date(sqlTime.getTime());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));
		dateStrTmp = dateFormat.format(timeDate);
		return dateStrTmp;
	}

	/*
	 * Get specify date in ISO_DATE format
	 * return java.sql.Date
	 */
	public static java.sql.Date getDateNow(){
		DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;//"YYYY-MM-dd"
		formatter.format(LocalDate.now());//获取当前时间
		LocalDate formatted = LocalDate.parse(formatter.format(LocalDate.now()).toString());
		System.out.println(formatted.toString());
		java.sql.Date date = java.sql.Date.valueOf(formatted);
		return date;
	}

	/*
	 * Get timestamp
	 * return java.sql.Date
	 */
	public static Timestamp getTimestamp(){
		Calendar cal = Calendar.getInstance();
		java.util.Date date = cal.getTime();
		Timestamp timestamp = new Timestamp(date.getTime());
		return timestamp;
	}


	/**
	 * Get today in ISO pattern
	 * @return
	 */
	public static String getDateStrNow(){
		Calendar calendar = Calendar.getInstance();
		int year =calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		return year + "-" + month + "-" + day;
	}

	/**
	 * Get yyyy-01-01,2017-01-01,OK DATE >=
	 * @return
	 */
	public static String getFirstDayOfCurrentYear(){
		Calendar calendar = Calendar.getInstance();
		int year =calendar.get(Calendar.YEAR);
		return year + "-01" + "-01";
	}

	/**
	 * Get yyyy-01-01,2018-01-01,OK DATE <
	 * @return
	 */
	public static String getLastDayOfCurrentYear(){
		Calendar calendar = Calendar.getInstance();
		int year =calendar.get(Calendar.YEAR) + 1;
		return year + "-01" + "-01";
	}

	/**
	 * Get yyyy-mm-01,2017-08-01,OK DATE >=
	 * @return
	 */
	public static String getFirstDayOfCurrentMonth(){
		Calendar calendar = Calendar.getInstance();
		int year =calendar.get(Calendar.YEAR);
		int month =calendar.get(Calendar.MONTH) + 1;
		return year + "-" + month + "-01";
	}

	/**
	 * Get yyyy-mm-01,2018-09-01,OK DATE <
	 * @return
	 */
	public static String getLastDayOfCurrentMonth(){
		Calendar calendar = Calendar.getInstance();
		int year =calendar.get(Calendar.YEAR);
		int month =calendar.get(Calendar.MONTH) + 2;
		return year + "-" + month + "-01";
	}

    // 获得本周一0点时间
    public static java.util.Date getTimesWeekmorning() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return cal.getTime();
    }

    // 获得本周日24点时间
    public static java.util.Date getTimesWeeknight() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getTimesWeekmorning());
        cal.add(Calendar.DAY_OF_WEEK, 7);
        return cal.getTime();
    }

	/**
	 * 获得本周一日期,2018-08-21,OK DATE >=
	 * @return
	 */
    public static String getFistDayOfCurrentWeek(){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
       	calendar.setTime(getTimesWeekmorning());
       	int month = calendar.get(Calendar.MONTH) +1;
       	int day  = calendar.get(Calendar.DAY_OF_MONTH);
		return year + "-" + month + "-" + day;
    }

	/**
	 * 获得下周一日期,2018-08-28,OK DATE <
	 * @return
	 */
    public static String getLastDayOfCurrentWeek(){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
       	calendar.setTime(getTimesWeekmorning());
       	int month = calendar.get(Calendar.MONTH) + 1;
       	int day  = calendar.get(Calendar.DAY_OF_MONTH) + 7;
		return year + "-" + month + "-" + day;
    }

	/**
	 * 获得当前季度的开始日期,OK!
	 * @return
	 */
	public static String getFirstDayOfCurrentQuater(){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
       	calendar.setTime(getCurrentQuarterStartTime());
       	int month = calendar.get(Calendar.MONTH)  + 3;
       	int day  = calendar.get(Calendar.DAY_OF_MONTH);
		return year + "-" + month + "-" + day;
	}

	/**
	 * 获得当前季度的结束日期,2017-04-01，OK! DATE >=
	 * @return
	 */
	public static String getLastDayOfCurrentQuater(){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
       	calendar.setTime(getCurrentQuarterStartTime());
       	int month = calendar.get(Calendar.MONTH) + 6;
       	int day  = calendar.get(Calendar.DAY_OF_MONTH);
		return year + "-" + month + "-" + day;
	}

	/**
	 * 获得本季度开始日期时间,2017-07-01，OK! DATE <
	 * @return
	 */
    public static java.util.Date getCurrentQuarterStartTime() {
        Calendar c = Calendar.getInstance();
        int currentMonth = c.get(Calendar.MONTH) + 1;
        SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date now = null;
        try {
            if (currentMonth >= 1 && currentMonth <= 3)
                c.set(Calendar.MONTH, 0);
            else if (currentMonth >= 4 && currentMonth <= 6)
                c.set(Calendar.MONTH, 3);
            else if (currentMonth >= 7 && currentMonth <= 9)
                c.set(Calendar.MONTH, 4);
            else if (currentMonth >= 10 && currentMonth <= 12)
                c.set(Calendar.MONTH, 9);
            c.set(Calendar.DATE, 1);
            now = longSdf.parse(shortSdf.format(c.getTime()) + " 00:00:00");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    /**
     * 当前季度的结束日期时间
     *
     * @return
     */
    public static java.util.Date getCurrentQuarterEndTime() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getCurrentQuarterStartTime());
        cal.add(Calendar.MONTH, 3);
        return cal.getTime();
    }

    /**
     * 当年的开始日期时间
     *
     * @return
     */
    public static java.util.Date getCurrentYearStartTime() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.MONTH, cal.getActualMinimum(Calendar.MONTH));
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.MONTH));
        return cal.getTime();
    }

    /**
     * 当年的结束日期时间
     *
     * @return
     */
    public static java.util.Date getCurrentYearEndTime() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getCurrentYearStartTime());
        cal.add(Calendar.YEAR, 1);
        return cal.getTime();
    }

    /**
     * 上一年的开始日期时间
     *
     * @return
     */
    public static java.util.Date getLastYearStartTime() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getCurrentYearStartTime());
        cal.add(Calendar.YEAR, -1);
        return cal.getTime();
    }

}
