import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 답을 담을 스트링빌더
		StringBuilder sb = new StringBuilder();
		
		// 테캐 개수
		int testCase = sc.nextInt();
		
		for(int tc = 1; tc <= testCase; tc++) {
			// 호텔 높이, 너비, 손님 데이터
			int height = sc.nextInt();
			int width = sc.nextInt();
			int visitor = sc.nextInt();
			
			// 방번호(답)
			int ans = 1;
			
			while(true) {
				if(visitor <= height) {
					// 손님이 높이보다 작아지면 100단위로 더해주고
					ans += 100*visitor;
					// 방을 찾았으므로 중단
					break;
				} else {
					// 손님이 높이보다 크면
					// 1단위로 더하고
					ans += 1;
					// 높이만큼 손님데이터를 감소
					visitor -= height;
				}
			}
			
			sb.append(ans + "\n");
		}
		
		sc.close();
		// 출력
		System.out.println(sb);
	}
}
