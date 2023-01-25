import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// N 입력받기
		int N = sc.nextInt();
		
		// 공백없는 N개의 숫자를 문자열로 받아줌
		String num = sc.next();
		
		// 구하려는 값
		int sum = 0;
		
		// 문자열을 char 단위로 아스키코드로 반환
		// ex) num = 1 -> num.charAt(0) = 49
		for(int i = 0; i < N; i++) {
			sum += num.charAt(i) - 48;
		}
		System.out.println(sum);
	}
}