import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 마을 개수
		int village = sc.nextInt();

		// 누적비용과 최대비용
		int accumulateCost = 0;
		int maxCost = 0;

		// 최댓값만 빼고 몽땅 더해주면 됨
		while (village-- > 0) {
			// 현재비용 입력받기
			int curCost = sc.nextInt();

			// 비용 누적
			accumulateCost += curCost;

			// 최대비용 갱신
			maxCost = Math.max(maxCost, curCost);
		}

		// 총 누적비용에서 최대비용 빼기
		accumulateCost -= maxCost;

		// 출력
		System.out.println(accumulateCost);
	}
}