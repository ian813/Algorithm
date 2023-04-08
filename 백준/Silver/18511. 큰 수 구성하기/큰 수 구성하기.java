import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static String N, tempAns;
	static int num, K, ans, length;
	static String[] numArr, result;
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		
		N = sc.next(); // 비교할 숫자
		K = sc.nextInt(); // numArr의 원소 개수
		numArr = new String[K]; // 원소 담아줄 배열
		length = N.length(); // 숫자의 자릿수를 나타낼 변수
		result = new String[length]; // 재귀를 이용한 결과를 담아줄 배열
		
		for(int idx = 0; idx < K; idx++) {
			numArr[idx] = sc.next();
		}
		// N을 정수로 바꿔주기
		num = Integer.parseInt(N);
		// numArr를 오름차순 정렬
		Arrays.sort(numArr);
		
	}
	
	static void recursion(int depth) {
		if(depth == length) {
			// 답을 담아줄 빈 문자열 생성
			tempAns = "";
			for(int i = 0; i < length; i++) {
				// 결과문자열을 전부 더해준 뒤
				tempAns += result[i];
			}
			if(Integer.parseInt(tempAns) <= num) { // 정수로 바꿔서 비교
				// num보다 작으면 최댓값 갱신
				ans = Math.max(ans, Integer.parseInt(tempAns));
			}
			return;
		}
		// 재귀를 이용해서 모든 경우의 수 탐색
		for(int i = 0; i < K; i++) {
			result[depth] = numArr[i];
			recursion(depth+1);
		}
		
	}
	
	public static void main(String[] args) {
		input();
		ans = 0;
		recursion(0);
		// 만약 같은 자릿수 중에 만족하는 값이 없으면 ans이 갱신이 안되고
		// 0으로 남아있게 된다.
		// 그럼 자릿수를 하나 낮춘 다음 numArr에 제일 끝에 들어있는
		// 제일 큰 원소로만 구성된 수를 만들어주면 그게 가장 큰 수가 된다.
		if(ans == 0) {
			tempAns = "";
			for(int idx = 0; idx < length-1; idx++) {
				// 자릿수 하나 낮춰서 제일 큰 원소로 더해주기
				tempAns += numArr[K-1];
			}
			// ans 갱신
			ans = Integer.parseInt(tempAns);
		}
		System.out.println(ans);
	}
}
