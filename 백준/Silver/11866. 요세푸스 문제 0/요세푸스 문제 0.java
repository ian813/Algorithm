import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int people;
	static int K;

	// 몇 번째 사람인지 세줄 변수
	static int cnt;

	// 빠져나온 순서대로 저장할 배열
	static int[] exitPeople;

	static Queue<Integer> store;

	static void input() {
		Scanner sc = new Scanner(System.in);

		// 사람 수와 K를 입력받기
		people = sc.nextInt();
		K = sc.nextInt();

		store = new LinkedList<>();
	}

	static void josephus() {
		input();

		// 일단 사람들을 큐에 저장해주자.
		for (int person = 1; person <= people; person++) {
			store.add(person);
		}

		// 몇 번째 사람인지 세 줄 변수
		cnt = 1;

		// 빠져나갈 사람이 들어갈 인덱스
		int exitIdx = 0;

		// 빠져나갈 사람들을 저장할 배열
		exitPeople = new int[people];
		
		// 사람 수를 저장할 임시 변수
		int tmpPeople = people;
		
		while (tmpPeople != 0) {
			if (cnt != K) {
				// cnt가 K가 아니면
				// 맨 앞 사람을 빼서
				int tmpPerson = store.remove();
				// 다시 뒤에 넣어준다.
				store.add(tmpPerson);
				// cnt는 하나 증가
				cnt++;
			} else {
				// cnt가 K이면
				// 맨 앞사람을 아예 빼주고
				// 빠져나간 사람 배열에 넣어주고 그 인덱스 증가 시키기
				exitPeople[exitIdx++] = store.remove();

				// 사람 수 감소시키기
				tmpPeople--;

				// cnt는 다시 1로 초기화
				cnt = 1;
			}

		}

	}

	static void print() {
		josephus();

		System.out.print("<");
		for (int idx = 0; idx < people - 1; idx++) {
			System.out.print(exitPeople[idx] + ", ");
		}
		System.out.println(exitPeople[people - 1] + ">");

	}

	public static void main(String[] args) {
		print();
	}
}