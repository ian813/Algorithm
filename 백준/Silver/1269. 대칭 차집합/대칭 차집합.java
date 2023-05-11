import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 집합 A, B의 원소 개수, 답
		int A = sc.nextInt();
		int B = sc.nextInt();	
		int ans = A+B; // 전체 원소 개수에서 중복되는 개수를 빼줘서 구한다.
		
		// 원소 포함 여부 체크
		boolean[] check = new boolean[100000001]; // 1억을 넘지 않는다고 문제에서 주어짐.
		
		for(int i = 0; i < A; i++) {
			check[sc.nextInt()] = true;
		}
		
		int cnt = 0; // 중복된 원소 개수 세줄 변수
		
		for(int j = 0; j < B; j++) {
			if(check[sc.nextInt()]) cnt++; // 중복되어 있으면 카운팅
		}
		
		ans -= 2*cnt; // 중복된 원소는 두 번 빼줘야 올바른 개수가 나온다.
		
		System.out.println(ans);
	}
}