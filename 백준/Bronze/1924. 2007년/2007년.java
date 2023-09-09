import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 월, 일 입력받기
		int month = sc.nextInt();
		int day = sc.nextInt();
		
		sc.close();
		
		int[] days = { 0, 3, 0, 3, 2, 3, 2, 3, 3, 2, 3, 2, 3 };
		
		int cal = 0;
		
		// 해당 월 전까지 더하기
		for(int i = 1; i < month; i++) {
			cal += days[i];
		}
		
		// 일 더하기
		cal += day;
		
		String ans = "";
		
		// 7로 나눈 나머지로 판단
		switch (cal%7) {
		case 1:
			ans = "MON";
			break;
		case 2:
			ans = "TUE";
			break;
		case 3:
			ans = "WED";
			break;
		case 4:
			ans = "THU";
			break;
		case 5:
			ans = "FRI";
			break;
		case 6:
			ans = "SAT";
			break;
		case 0:
			ans = "SUN";
			break;
		}
		
		// 출력
		System.out.println(ans);
	}
}