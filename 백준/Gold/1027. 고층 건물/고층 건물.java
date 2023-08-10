import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 빌딩 개수
		int building = sc.nextInt();

		// 포인트 개수 (i번째 빌딩의 높이)
		long[] point = new long[building + 1];

		for (int i = 1; i <= building; i++) {
			point[i] = sc.nextLong();
		}

		sc.close();

		// 최댓값 변수
		int max = 0;

		for (int i = 1; i <= building; i++) {
			// 빌딩 전부 돌면서 판단
			// 해당 빌딩에 대해 판단해서 보이는 개수 카운팅할 변수
			int judge = 0;
			for (int j = i + 1; j <= building; j++) {
				// i번째 빌딩에 대해 j번째 빌딩이 보일지 판단 (i보다 오른쪽에 있는 빌딩에 대해 카운팅)
				boolean visible = true; // 보이는지 판단할 불리안
				for (int k = j - 1; k > i; k--) {
					// i번째와 j번쨰 빌딩 사이에 있는 빌딩들을 상대로 판단해보자.
					// 주의 : 일반적인 기울기 구하는 연산 처럼 (point[j] - point[i]) / (j - i) * ... 이런식으로 쓰면
					// 나누기 시 소수점을 버리고 몫만 취해서 값에 영향을 주기 때문에 곱 연산으로만 만들어서 판단
					// 단, 이렇게 곱 연산으로만 사용할 경우 int 범위를 벗어나는 경우가 생기므로
					// point 배열을 long 자료형을 받을 수 있는 배열로 바꾼다.
					if ((point[j] - point[i]) * (k - i) - (point[k] - point[i]) * (j - i) <= 0) {
						// 직선의 방정식으로 판단해서 k번째 빌딩이 직선에 접하거나 위에 있으면
						// 안 보이므로 안 보인다고 체크하고 멈추기
						visible = false;
						break;
					}
				}
				// 만약 j번째 빌딩이 보이면 카운팅
				if (visible)
					judge++;
			}

			// i보다 왼쪽에 있는 빌딩에 대해서도 위와 같이 판단해서 카운팅
			for (int j = i - 1; j > 0; j--) {
				boolean visible = true;
				for (int k = j + 1; k < i; k++) {
					if ((point[j] - point[i]) * (k - i) - (point[k] - point[i]) * (j - i) >= 0) {
						visible = false;
						break;
					}
				}
				if (visible)
					judge++;
			}

			// 최댓값 갱신
			max = Math.max(max, judge);
		}
		// 출력
		System.out.println(max);
	}
}