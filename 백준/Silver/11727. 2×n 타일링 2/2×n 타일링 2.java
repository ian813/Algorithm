
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	
	static int[] rectangular;
	
	static int size;
	
	static int ans;
	
	static void input() {
		// 사이즈 입력받고
		size = sc.nextInt();
		
		// 사이즈+1만큼 크기로 배열 생성
		rectangular = new int[size+1];
		
	}
	
	static void dp() {
		input();
		// 1일 때는 직접 계산
		rectangular[1] = 1;
		
		if(size >= 2) {
			// 사이즈가 2보다 크면
			// 2도 직접 계산해서 넣어주기
			rectangular[2] = 3;
		}
		
		for(int idx = 3; idx <= size; idx++) {
			// 3부터는 이전 개수 2개를 더해주면 된다.
			// -2 한 거에 세로로 추가하는 경우는 -1한 경우에 포함되어 있으므로,,
			// -2 한 거에 가로로 추가하는 경우와 2*2짜리 추가하는 경우 -1한 경우에 세로로 추가해주는 경우가
			// 현재 인덱스 거와 같으므로
			// -2 한 거 *2 + -1 한 거 해주면 됨
			rectangular[idx] = (rectangular[idx - 1] % 10007) + ((2 * rectangular[idx - 2]) % 10007);
			
		}
		
		// 10007로 나눈 나머지 구하기!
		ans = rectangular[size] % 10007;
		
	}
	
	public static void main(String[] args) {
		dp();
		
		// 출력해주면 끝
		System.out.println(ans);
	}
}
