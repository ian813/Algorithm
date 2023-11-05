import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int H = sc.nextInt();
		int W = sc.nextInt();
		int N = sc.nextInt();
		int M = sc.nextInt();

		// 가로 세로에 앉을 사람 수 카운팅
		int wCnt = 1;
		int hCnt = 1;

		while (1 + (M + 1) * wCnt <= W) {
			// M만큼 간격을 띄우고 앉았을 때 가로로 얼만큼 앉을 수 있는지 세기
			wCnt++;
		}
		while (1 + (N + 1) * hCnt <= H) {
			// N만큼 간격을 띄우고 앉았을 때 세로로 얼만큼 앉을 수 있는지 세기
			hCnt++;
		}

		// 곱해서 출력
		System.out.println(wCnt * hCnt);
	}
}