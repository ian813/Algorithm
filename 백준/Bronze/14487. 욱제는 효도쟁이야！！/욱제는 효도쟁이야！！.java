import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 마을 개수
		int village = Integer.parseInt(br.readLine());

		// 누적비용과 최대비용
		int accumulateCost = 0;
		int maxCost = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        
		// 최댓값만 빼고 몽땅 더해주면 됨
		while (village-- > 0) {
			// 현재비용 입력받기
			int curCost = Integer.parseInt(st.nextToken());

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