import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 재료 개수
		int materialNum = sc.nextInt();

		if (materialNum == 1) {
			System.out.println(0);
			return;
		}

		// 갑옷이 되는 수
		int armor = sc.nextInt();

		// 재료 정보 입력받을 배열
		int[] material = new int[materialNum];

		for (int i = 0; i < materialNum; i++) {
			material[i] = sc.nextInt();
		}

		// 오름차순 정렬
		Arrays.sort(material);

		// 갑옷을 만들 수 있는 경우의 수
		int cnt = 0;

		// 두 포인터가 가리키는 인덱스
		int leftPointer = 0;
		int rightPointer = materialNum - 1;

		// 투 포인터를 이용해 탐색
		while (leftPointer < rightPointer) {
			if (material[leftPointer] + material[rightPointer] < armor) {
				// 두 포인터가 가리키는 재료의 합이 더 작으면
				// 왼쪽 포인터를 늘려서 재료 합을 커지게 해준다.
				leftPointer++;
			} else if (material[leftPointer] + material[rightPointer] > armor) {
				// 두 포인터가 가리키는 재료의 합이 더 크면
				// 오른쪽 포인터를 줄여서 재료 합을 작아지게 해준다.
				rightPointer--;
			} else {
				// 갑옷 제작 가능하면 카운트하고
				// 양쪽 포인터를 조여준다.
				cnt++;
				leftPointer++;
				rightPointer--;
			}
		}

		// 출력
		System.out.println(cnt);
	}
}