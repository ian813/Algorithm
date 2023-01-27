import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 숫자 2개 입력받기
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		// 뒤집은 숫자를 저장할 변수 생성
		int newNum1 = 0;
		int newNum2 = 0;
		
		// num1 뒤집기
		while(num1 != 0) {
			newNum1 = newNum1 * 10 + num1 % 10;
			num1 /= 10;
		}
		
		// num2 뒤집기
		while(num2 != 0) {
			newNum2 = newNum2 * 10 + num2 % 10;
			num2 /= 10;
		}
		
		// newNum1과 newNum2 크기 비교해서 출력
		if(newNum1 > newNum2) {
			System.out.println(newNum1);
		} else if(newNum1 < newNum2) {
			System.out.println(newNum2);
		}
	}
}
