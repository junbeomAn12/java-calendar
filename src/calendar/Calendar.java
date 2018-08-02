package calendar;

//import java.util.Scanner;

public class Calendar {
	private static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	private static final int[] LEAP_MAX_DAYS = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public boolean isLeapYear(int year) {
		return year % 4 == 0 ? (year % 100 != 0 || year % 400 == 0) : false;

	}

	public int getMaxDaysOfMonth(int year, int month) {
		if (isLeapYear(year)) {
			return LEAP_MAX_DAYS[month - 1];
		}
		return MAX_DAYS[month - 1];
	}

	public int getFirstDayOfMonth(int year, int month) {
		
		int result = (year - 1)*365 + ((year - 1)/4 - (year - 1)/100 + (year - 1)/400);
		for (int i = 1; i < month; i++) {

			result = result + getMaxDaysOfMonth(year, i);
		}

		result++;
		return result % 7;
	}

	public void printSampleCalendar(int year, int month) {
		Calendar cal = new Calendar();
		int maxDays = cal.getMaxDaysOfMonth(year, month);
		int weekday = cal.getFirstDayOfMonth(year, month);
		int count = 7 - weekday;
		int delim = count < 7 ? count : 0;
		// get weekday automatically

		System.out.println("  일    월    화    수    목    금    토");
		System.out.println("--------------------");
		// print blank space
		for (int i = 0; i < weekday; i++) {
			System.out.print("   ");
		}
		// print first line
		for (int i = 1; i <= count; i++) {
			System.out.printf("%3d", i);
		}
		System.out.println();
		count++;
		for (int i = count; i <= maxDays; i++) {
			System.out.printf("%3d", i);
			if (i % 7 == delim) {
				System.out.println();
			}
		}
		System.out.println();
	}

}