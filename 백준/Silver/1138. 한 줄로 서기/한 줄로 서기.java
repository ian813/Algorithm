import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		// 사람 정보 입력
		int[] people = new int[N];

		for (int i = 0; i < N; i++) {
			people[i] = sc.nextInt();
		}

		int[] result = new int[N];

		// 1번 애부터 판단
		// 키 큰 애 수만큼 개수 세줘서 해당 인덱스에 넣어주기
		for (int i = 0; i < N; i++) {
			// 키 큰 애 몇 명인지 판단할 변수
			int cnt = people[i];
			// 키 큰 애 카운팅
			int cur = 0;
			for (int j = 0; j < N; j++) {
				if (cnt == cur && result[j] == 0) {
					// 키 큰 애 세준 값과 결과값이 일치하고 비어있는 자리면
					// 결과 인덱스에 사람 번호 넣어주고 break
					result[j] = i + 1;
					break;
				} else if (cnt == cur) {
					// 키 큰 애 세준 값과 결과값이 일치하는데 비어있지 않으면
					while (result[j] != 0) {
						// 비어있는 자리 찾아가서
						j++;
					}
					// 넣어주고 break
					result[j] = i + 1;
					break;
				} else if (result[j] == 0) {
					// 키 큰 애가 들어갈 빈자리가 있으면 카운팅
					cur++;
				}
			}
		}

		// 출력
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			sb.append(result[i] + " ");
		}
		System.out.println(sb);
	}
}