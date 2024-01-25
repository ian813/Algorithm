import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 학생 정보 입력받을 배열
		int[] student = new int[31];

		// 학생 번호 입력받아서 기록하기
		for (int i = 0; i < 28; i++) {
			int cur = sc.nextInt();

			student[cur]++;
		}

		for (int i = 1; i <= 30; i++) {
			if (student[i] == 0) {
				// 과제 안 냈으면 출력
				System.out.println(i);
			}
		}
	}
}