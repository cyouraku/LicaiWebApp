package com.costuary.util;

public class DateUtilTestor {

	public static void main(String[] args) {


		System.out.println(DateUtil.getCurrentQuarterStartTime());

		String temp = "";

		temp = DateUtil.getFirstDayOfCurrentYear();
		System.out.println("当年的开始日期: " + temp);

		temp = DateUtil.getLastDayOfCurrentYear();
		System.out.println("当年的结束日期: " + temp);

		temp = DateUtil.getFirstDayOfCurrentQuater();
		System.out.println("当前季度的开始日期: " + temp);

		temp = DateUtil.getLastDayOfCurrentQuater();
		System.out.println("当前季度的结束日期: " + temp);

		temp = DateUtil.getFirstDayOfCurrentMonth();
		System.out.println("当月的开始日期: " + temp);

		temp = DateUtil.getLastDayOfCurrentMonth();
		System.out.println("当月的结束日期: " + temp);

		temp = DateUtil.getFistDayOfCurrentWeek();
		System.out.println("本周的开始日期: " + temp);

		temp = DateUtil.getLastDayOfCurrentWeek();
		System.out.println("本周的结束日期: " + temp);

		temp = DateUtil.getDateStrNow();
		System.out.println("今天日期: " + temp);

	}

}
