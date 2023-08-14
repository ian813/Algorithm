public class Main {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();

		// 셀프넘버인지 체크할 배열
		boolean[] check = new boolean[10001];

		// 10000이하인 자연수에 대해 시행
		for (int i = 1; i <= 10000; i++) {
			// 현재 수 저장
			int cur = i;
			// tmp에도 저장 => tmp는 n과 n의 각 자리수를 더한 최종 값
			int tmp = cur;

			while (cur > 0) {
				// cur을 10으로 나눈 나머지를 더해주고
				// 10으로 나눈 몫으로 업데이트
				tmp += cur % 10;
				cur /= 10;
			}

			if (tmp <= 10000) {
				// 생성자를 갖고 있는 숫자를 true로 업데이트
				check[tmp] = true;
			}
		}

		// 체크를 돌면서 셀프넘버인지 확인해서 스트링빌더에 담기
		for (int i = 1; i <= 10000; i++) {
			if (!check[i])
				sb.append(i + "\n");
		}

		// 출력
		System.out.println(sb);
	}
}