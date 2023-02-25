import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 케이크 수, 사람 수 입력받기
		int cakeLength = sc.nextInt();
		int people = sc.nextInt();

		// 케이크를 받을 첫 인덱스와 끝 인덱스
		int startIdx = 0;
		int endIdx = 0;

		// 케이크길이보다 +1해서 배열 생성(인덱스가 cakeLength까지 있어야 하므로)
		int[] cake = new int[cakeLength + 1];

		// 가장 많은 조각을 받을 것으로 기대되는 방청객의 번호를 구하기 위해
		// 입력 숫자의 차가 가장 큰(endIdx-startIdx) 사람을 골라줘야 한다.
		int tmpMax = -1;
		int maxPerson = -1;

		int realMax = -1;
		
		// 실제 최대로 받은 사람을 받을 변수
		int realMaxPerson = -1;

		for (int person = 1; person <= people; person++) {
			// 시작과 끝 인덱스 입력받고
			startIdx = sc.nextInt();
			endIdx = sc.nextInt();

			// 최대인 사람을 찾기 위해 번호를 세줄 변수
			int tmpCnt = 0;

			for (int idx = startIdx; idx <= endIdx; idx++) {
				if (cake[idx] == 0) {
					// 배열의 데이터가 0이면
					// 방청객의 번호를 해당 인덱스에 넣어준다.
					cake[idx] = person;

					// 한번 받을 때마다 카운트
					tmpCnt++;
				}

			}

			if ((endIdx - startIdx) > tmpMax) {
				// 입력받은 값이 최대일 때
				// 그 때의 사람을 저장해주자.
				tmpMax = endIdx - startIdx;
				maxPerson = person;
			}
			if (tmpCnt > realMax) {
				realMax = tmpCnt;
				realMaxPerson = person;
			}

		}

		System.out.println(maxPerson);
		System.out.println(realMaxPerson);

	}

}