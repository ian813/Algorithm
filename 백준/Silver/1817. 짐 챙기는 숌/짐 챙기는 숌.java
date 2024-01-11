import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 책 개수
		int bookNum = sc.nextInt();

		// 최대 무게
		int maxWeight = sc.nextInt();

		// 박스 개수
		int boxCnt = 0;

		// 현재 무게
		int curWeight = 0;

		while (bookNum-- > 0) {
			// 책 개수만큼 반복
			// 넣으려는 책 무게
			int bookWeight = sc.nextInt();

			// 일단 현재 무게에 누적
			curWeight += bookWeight;

			if (curWeight > maxWeight) {
				// 만약 맥스값보다 커지면
				// 현재 무게를 지금 책 무게로 초기화하고 박스 개수 카운팅
				curWeight = bookWeight;
				boxCnt++;
			}
		}

		// 마지막 박스 카운팅
		if (curWeight > 0) {
			boxCnt++;
		}

		System.out.println(boxCnt);
	}
}