import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	// 테스트케이스 수
	static int testCase = sc.nextInt();
	// 입력받을 정수
	static int n;
	static int[] numArr;
	
	// 인풋 메서드
	static void input() {
		// 정수 입력받고
		n = sc.nextInt();
		
		// 정수 n까지 인덱스로 사용하기 위해 n+1 크기의 배열 생성
		numArr = new int[n+1];	
	}
	
	static void dp() {
		// 테스트케이스만큼 실행
		for(int tc = 1; tc <= testCase; tc++) {
			// 인풋 받아주고
			input();
			
			// 1, 2, 3 값은 각각 계산해서
			// 직접 넣어준다.
			numArr[1] = 1;
			if(n > 1) {
				// n이 2보다 작으면,, 오류가 생기니까,,
				numArr[2] = 2;
			}
			if(n > 2) {
				// n이 3보다 작으면,, 오류가 생기니까,,
				numArr[3] = 4;
			}
			
			// 인덱스 4부터 시행해주자.
			for(int idx = 4; idx < numArr.length; idx++) {
				// 인덱스가 4부터는 그 인덱스에서 -1 -2 -3한 인덱스에 있는 데이터들의 합과 같다.
				// 왜냐하면 -3한 곳에 있는 데이터들에 +3만 전부 붙여주면 되고,
				// -2한 곳에 있는 데이터들에 +2만 전부 붙여주면 되고,
				// -1한 곳에 있는 데이터들에 +1만 전부 붙여주면 되기 때문에,,
				numArr[idx] = numArr[idx - 3] + numArr[idx - 2] + numArr[idx - 1];
			}
			// 결과값 출력해주면 끝
			System.out.println(numArr[n]);
		}
		
	}
	
	public static void main(String[] args) {
		dp();
	}
}