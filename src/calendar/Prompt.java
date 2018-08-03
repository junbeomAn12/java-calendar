package calendar;

import java.text.ParseException;
import java.util.Scanner;

public class Prompt {

	public void printMenu() {
		System.out.println("+------------------------+");
		System.out.println("| 1. 일정 등록");
		System.out.println("| 2. 일정 검색");
		System.out.println("| 3. 달력 보기");
		System.out.println("| h. 도움말   q. 종료");
		System.out.println("+------------------------+");
	}

	public int parseDay(String weekday) {
		if (weekday.equals("su"))
			return 0;
		else if (weekday.equals("mo"))
			return 1;
		else if (weekday.equals("tu"))
			return 2;
		else if (weekday.equals("we"))
			return 3;
		else if (weekday.equals("th"))
			return 4;
		else if (weekday.equals("fr"))
			return 5;
		else if (weekday.equals("sa"))
			return 6;
		else
			return 0;
	}

	public void runPrompt() throws ParseException {

		printMenu();
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();

		while (true) {
			System.out.println("메뉴선택 (1, 2, 3, h, q)");
			String cmd = scanner.next();
			if (cmd.equals("1"))
				cmdRegister(scanner, cal);
			else if (cmd.equals("2"))
				cmdSearch(scanner, cal);
			else if (cmd.equals("3"))
				cmdCal(scanner, cal);
			else if (cmd.equals("h"))
				printMenu();
			else if (cmd.equals("q"))
				break;
		}
		System.out.println("Thank you!!");
		scanner.close();
	}

	private void cmdCal(Scanner scanner, Calendar cal) {
		System.out.println("연도를 입력하세요 : ");
		int year = 0;
		int month = 0;
		System.out.println("YEAR> ");
		year = scanner.nextInt();
		if (year == -1) {
			System.out.println("종료합니다.");
			return;
		}
		System.out.println("월을 입력하세요 : ");
		System.out.println("MONTH> ");
		month = scanner.nextInt();
		if (month == -1) {
			System.out.println("종료합니다.");
			return;
		}

		cal.printSampleCalendar(year, month);
		System.out.println();
	}

	private void cmdRegister(Scanner scanner, Calendar cal) throws ParseException {
		System.out.println("[새 일정 등록]");
		System.out.println("날짜를 입력해 주세요 (yyyy-MM-dd).");
		String date = scanner.next();
		String text = "";
		System.out.println("일정을 입력해 주세요.");
		while (true) {
			String word = scanner.next();
			text += word + " ";
			if (word.endsWith(";")) {
				break;
			}
		}
		cal.registerPlan(date, text);
	}

	private void cmdSearch(Scanner scanner, Calendar cal) {
		System.out.println("[일정 검색]");
		System.out.println("날짜를 입력해 주세요 (yyyy-MM-dd).");
		String date = scanner.next();
		String plan = "";
		try {
			plan = cal.searchDate(date);
		} catch (ParseException e) {
			e.printStackTrace();
			System.err.println("오류발생");
		}
		System.out.println(plan);
	}

	public static void main(String[] args) throws ParseException {
		Prompt p = new Prompt();
		p.runPrompt();

	}
}
