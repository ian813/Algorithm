import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 현재 주파수, 타깃 주파수
		int curHz = sc.nextInt();
		int targetHz = sc.nextInt();

		// 노가다로 타깃으로 가는 버튼 클릭 수
		int min = Math.abs(targetHz - curHz);

		// 즐겨찾기한 주파수 개수
		int bookmarkNum = sc.nextInt();

		for (int i = 0; i < bookmarkNum; i++) {
			// 즐겨찾기 등록한 주파수 입력받기
			int bookmark = sc.nextInt();

			// 즐겨찾기 등록한 주파수에서 타깃으로 노가다로 가는 버튼 클릭 수
			int tmp = Math.abs(bookmark - targetHz);

			// 최솟값 갱신 (즐겨찾기로 갈 때 한번 클릭하므로 +1 해주기)
			min = Math.min(tmp + 1, min);
		}

		System.out.println(min);
	}
}