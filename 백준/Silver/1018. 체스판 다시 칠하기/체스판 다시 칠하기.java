import java.util.Scanner;

public class Main {

	// 전역변수 선언
	static int n;
	static int m;
	
	// 배열의 최대 크기만큼 생성
	static char[][] inputArr = new char[50][50];
	
	// 답을 담을 변수(절대 나올 수 없는 최댓값으로 지정)
	static int ans = 65;

	// 배열에 값 입력받기
	static void inputProblem() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		for (int y = 0; y < n; y++) {
			String tmpInput = sc.next();
			for (int x = 0; x < m; x++) {
				inputArr[y][x] = tmpInput.charAt(x);
			}
		}
	}

	// 만들려는 배열을 생성해서 입력받은 배열과 비교
	// 비교를 스타트하는 지점을 파라미터로 받는다.
	static int compareBarr(int startY, int startX) {
		// 임시 정답
		int tmpAns = 0;
		// 만들려는 배열
		char[][] bArr = { { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }, { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
				{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }, { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
				{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }, { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
				{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }, { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' } };
		
		// 입력받은 배열과 만들려는 배열을 비교
		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				// 8*8로 잘라서 비교
				// 스타트 지점만 옮겨주면 된다.
				if (inputArr[y + startY][x + startX] != bArr[y][x]) {
					// 비교해서 다르면 tmpAns++
					tmpAns++;
				}
			}
		}
		return tmpAns;
	}

	// compareBarr과 같은 방식으로 진행
	static int compareWarr(int startY, int startX) {
		int tmpAns = 0;
		char[][] wArr = { { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
				{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
				{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
				{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' } };
		
		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				if (inputArr[y + startY][x + startX] != wArr[y][x]) {
					tmpAns++;
				}
			}
		}

		return tmpAns;
	}

	// 솔루션을 찾는 메서드
	static void solve() {
		// 배열이 8*8이므로 n-7까지만 탐색해주면 된다.
		for (int y = 0; y < n - 7; y++) {
			for (int x = 0; x < m - 7; x++) {
				// compareWarr(y, x), compareBarr(y, x) 중에 최소값을 ans로 변환
				ans = Math.min(ans, compareWarr(y, x));
				ans = Math.min(ans, compareBarr(y, x));
			}
		}
	}
	
	// 답 찾아서 print
	public static void main(String[] args) {
		inputProblem();
		solve();
		System.out.println(ans);
	}
}