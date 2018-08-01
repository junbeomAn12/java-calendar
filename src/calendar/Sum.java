package calendar;

import java.util.Scanner;

public class Sum {
	public static void main (String[] args) {
		System.out.println("두수를 입력하세요 : ");
		Scanner scanner = new Scanner(System.in); //키보드로 입력 한다는 의미
		String inputValue = scanner.nextLine();
		String[] strNum = inputValue.split(" ");
		int first = Integer.parseInt(strNum[0]);
		int second = Integer.parseInt(strNum[1]);
		System.out.println("두수의 합은 "+ (first + second) + "입니다.");
		
	}
}
