import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 구슬 개수
		int bead = sc.nextInt();

		// 구슬의 수 최대 최소값 설정
		int max = 0;
		int min = 1000000001;

		while (bead-- > 0) {
			// 구슬 개수만큼 번호 입력받기
			int curBead = sc.nextInt();

			// 최대 최소값 갱신
			max = Math.max(max, curBead);
			min = Math.min(min, curBead);
		}

		// 팔찌 길이는 최대 최소 번호의 길이의 두배
		int bracelet = (max - min) * 2;

		// 출력
		System.out.println(bracelet);
	}
}