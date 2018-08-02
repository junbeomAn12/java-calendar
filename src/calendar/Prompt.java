package calendar;

import java.util.Scanner;

public class Prompt {
	public int parseDay(String weekday) {
		if(weekday.equals("su")) return 0;
		else if(weekday.equals("mo")) return 1;
		else if(weekday.equals("tu")) return 2;
		else if(weekday.equals("we")) return 3;
		else if(weekday.equals("th")) return 4;
		else if(weekday.equals("fr")) return 5;
		else if(weekday.equals("sa")) return 6;
		else return 0;
	}

	public void runPrompt() {
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
		
		int year = 0;
		int month = 0;
		
		
		while (true) {
			System.out.println("연도를 입력하세요 : ");
			System.out.println("YEAR> ");
			year = scanner.nextInt();
			if (year == -1) {
				System.out.println("종료합니다.");
				break;
			}
			System.out.println("월을 입력하세요 : ");
			System.out.println("MONTH> ");
			month = scanner.nextInt();
			if (month == -1) {
				System.out.println("종료합니다.");
				break;
			}

			cal.printSampleCalendar(year, month);

		}
		scanner.close();
	}

	public static void main(String[] args) {
		Prompt p = new Prompt();
		p.runPrompt();

	}
}
