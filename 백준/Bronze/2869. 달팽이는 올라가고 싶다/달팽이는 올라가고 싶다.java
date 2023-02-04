import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 올라가는 거리, 내려가는 거리, 높이 변수 생성
		int ascending = sc.nextInt();
		int descending = sc.nextInt();
		int height = sc.nextInt();
		
		int day = (height - descending) / (ascending - descending);
		
		if(!((height - descending) % (ascending - descending) == 0)) {
			day++;
		}
		
		System.out.println(day);
	}
}