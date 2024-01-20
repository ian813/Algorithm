import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 두 포인터로 풀어보자!!
		int N = sc.nextInt();

		// 왼쪽, 오른쪽 포인터 설정
		int leftPointer = 1;
		int rightPointer = 1;

		// 초기 합 구하기
		int sum = 1;

		// N을 나타낼 방법 수 저장할 변수
		int cnt = 0;

		while (leftPointer <= rightPointer) {
			// rightPointer가 leftPointer이상일때까지만 실행
			if (sum < N) {
				// N이 더 크면 rightPointer를 늘리고 합도 누적
				rightPointer++;
				sum += rightPointer;
			} else if (sum > N) {
				// sum이 더 크면 leftPointer 값을 빼고 leftPointer 늘리기
				sum -= leftPointer;
				leftPointer++;
			} else {
				// 같으면 카운팅하고 leftPointer를 뺴줘서 계속 진행
				cnt++;
				sum -= leftPointer;
				leftPointer++;
			}
		}

		// 출력
		System.out.println(cnt);
	}
}