import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// M, N을 받아줌.
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		// 완전제곱수를 더한 값과 범위 안의 완전제곱수 최솟값을 받을 변수 생성
		int sum = 0;
		int min = 0;
		
		// 1부터 N의 제곱근까지의 i에 대해 브루트포스 알고리즘 적용
		// i*i가 범위 안에 있을 때 더해줌.
		for(int i = 1; i <= Math.sqrt(N); i++) {
			if(i*i >= M && i*i <=N) {
				sum += i*i;
				// min은 첫번째로 나온 i*i로 설정
				if(min == 0) {
					min += i*i;
				}
			}
		}
		
		// 예외 처리
		// 범위 안에 수가 없어서 sum=0일 때 -1
		if(sum > 0) {
			System.out.println(sum);
			System.out.println(min);
		} else {
			System.out.println(-1);
		}		
	}
}