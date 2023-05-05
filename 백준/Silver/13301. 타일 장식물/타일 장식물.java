import java.util.Scanner;

public class Main {
	static int N; // 타일 개수
	static long sum; // 총 둘레길이
	static long[] length; // 새로 생긴 사각형의 한변 길이
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		length = new long[N+1]; // 타일이 N개일 때 N번째 타일의 한 변의 길이를 저장
		
		sum = 0; // 둘레의 길이
		
		sc.close();

		cal();
		
		System.out.println(sum);
		
	}
	
	// 둘레 길이 계산해줄 메서드
	static void cal() {
		length[0] = 0; // 0일 때는 0으로
		length[1] = 1; // 1일 때는 1로
		
		sum = 4; // N이 1일 때 둘레 길이	

		// N이 2이상이면 for문이 동작
		for(int i = 2; i <= N; i++) {
			// 변의 길이는 그 전 두 타일의 변의 길이의 합과 같다.
			length[i] = length[i-1] + length[i-2];
			
			// 증가하는 둘레의 길이는 새롭게 추가된 타일의 변 두개의 합을 더해준 것과 같다.
			sum += length[i] * 2;
		}
		
	}
}