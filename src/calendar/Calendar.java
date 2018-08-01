package calendar;

import java.util.Scanner;

public class Calendar {
	public static void main(String[] args) {
//		System.out.println("일  월  화  수  목  금  토");
//		System.out.println("----------------");
//		System.out.println("1 2 3 4 5 6 7");
//		System.out.println("8 9 10 11 12 13 14");
//		System.out.println("15 16 17 18 19 20 21");
//		System.out.println("22 23 24 25 26 27 28");
		System.out.println("월을 입력하세요 : ");
		Scanner scanner = new Scanner(System.in);
		int month = scanner.nextInt();
		int result;
		if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			result = 31;
		} else {
			result = 30;
		}
		System.out.println(month + "월은 " + result + "일까지 있습니다.");
		scanner.close();
	}
}