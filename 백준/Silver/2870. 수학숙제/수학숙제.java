import java.math.BigInteger;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 줄 개수
		int line = sc.nextInt();

		// 우선순위 큐
		PriorityQueue<BigInteger> queue = new PriorityQueue<>();

		// 줄 개수만큼 반복
		while (line-- > 0) {
			// 입력받은 줄을 char로 쪼개기
			char[] str = sc.next().toCharArray();

			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < str.length; i++) {
				if (str[i] >= '0' && str[i] <= '9') {
					// 배열을 돌면서 숫자를 발견하면 추가
					sb.append(str[i]);
				} else {
					// 숫자가 아니면
					if (!sb.toString().equals("")) {
						// 이미 저장된 숫자가 있으면 int로 바꿔서 큐에 저장
						queue.add(new BigInteger(sb.toString()));
						// 답 초기화
						sb = new StringBuilder();
					}
				}
			}

			// 숫자가 남은채로 끝나면 그 숫자도 큐에 넣어주기
			if (!sb.toString().equals("")) {
				queue.add(new BigInteger(sb.toString()));
			}
		}

		StringBuilder sb = new StringBuilder();

		while (!queue.isEmpty()) {
			// 큐가 빌 때까지 숫자 뽑아서 저장
			sb.append(queue.poll()).append("\n");
		}

		// 출력
		System.out.println(sb);
	}
}