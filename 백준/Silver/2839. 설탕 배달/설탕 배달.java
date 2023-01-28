import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 무게 입력받기
		int weight = sc.nextInt();
		
		// 봉지 개수를 담을 변수 생성
		int numOfBag = 0;
		
		while(weight>0) {
			if(weight % 5 == 0) {
				weight -= 5;
				numOfBag++;
			}
			else if(weight % 3 == 0) {
				weight -= 3;
				numOfBag++;
			}
			else {
				weight -= 5;
				numOfBag++;
			}
		}
		
		if (weight == 0) {
			System.out.println(numOfBag);
		} else {
			System.out.println(-1);
		}
		
	}
}