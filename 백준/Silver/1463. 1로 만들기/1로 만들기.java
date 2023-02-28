import java.util.Scanner;

public class Main {
	static int num;
	static Scanner sc = new Scanner(System.in);
	static int[] numArr;

	// input 메서드
	static void input() {
		// 숫자 입력받고
		num = sc.nextInt();
		// 그 숫자까지 인덱스로 사용하도록
		// 배열 생성
		numArr = new int[num + 1];

		// 1 값은 직접 지정
		numArr[1] = 0;
	}

	static void dp() {
		input();
		
		// 숫자 2부터 Num까지는 다음과 같은 규칙으로 횟수를 세주면 된다.
		for (int idx = 2; idx <= num; idx++) {
			if (idx % 2 == 0 && idx % 3 == 0) {
				// 인덱스가 2, 3의 배수일 때는
				// 인덱스를 2로 나눴을 때와 3으로 나눴을 때, -1을 했을 때의 값들 중 최솟값에 +1 해준 값이다.
				int tmpMin = Math.min(numArr[idx / 2], numArr[idx / 3]);
				
				numArr[idx] = Math.min(numArr[idx-1], tmpMin) + 1;
			} else if (idx % 2 == 0) {
				// 인덱스가 2의 배수일 때는
				// 인덱스를 2로 나눴을 때와 -1을 했을 때의 값 중 최솟값에 +1 해준 값이다.
				numArr[idx] = Math.min(numArr[idx-1], numArr[idx / 2]) + 1;
			} else if (idx % 3 == 0) {
				// 인덱스가 3의 배수일 때는
				// 인덱스를 3으로 나눴을 때와 -1을 했을 때의 값 중 최솟값에 +1 해준 값이다.
				numArr[idx] = Math.min(numArr[idx-1], numArr[idx / 3]) + 1;
			} else {
				// 그 외에는
				// -1 했을 때의 값에 +1 해주면 된다.
				numArr[idx] = numArr[idx - 1] + 1;
			}

		}
		// 구한 값 출력하기
		System.out.println(numArr[num]);
	}

	public static void main(String[] args) {
		dp();
	}
}