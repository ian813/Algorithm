import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int[] alphabet;
	static int ans;

	static void input() {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		// 알파벳 개수가 26개니까..
		alphabet = new int[26];
		
		for (int i = 0; i < N; i++) {
			// 단어 입력받고
			String str = sc.next();
			// 그 단어의 길이만큼 자릿수를 만들어준다.
			int val = (int) Math.pow(10, str.length() - 1);
			for (int j = 0; j < str.length(); j++) {
				// 단어를 쪼개서 알맞은 알파벳 위치에 그 자릿수를 더해준다.
				alphabet[str.charAt(j) - 'A'] += val;
				// 한 번 더하면 그 다음 수는 자릿수가 감소하므로 10으로 나눠준다.
				val /= 10;
			}
		}

	}

	static void solve() {
		// 오름차순으로 정렬
		Arrays.sort(alphabet);
		
		// 숫자는 0~9인데 가장 큰 수에 가장 큰 수를 곱해주는게 당연하겠지?
		int num = 9;
		// 답을 저장할 변수
		ans = 0;

		for (int idx = 25; idx >= 0; idx--) {
			// 끝에서부터 큰수끼리 곱해주면서 내려오자.
			// 다만 0을 만나면 그 이후로는 필요없으니까 중지
			if (alphabet[idx] == 0) break;
			// 답에 num*자릿수들을 더한 값을 해주고
			ans += num * alphabet[idx];
			// num감소시키기
			num--;
		}

	}

	public static void main(String[] args) {
		input();
		solve();
		
		System.out.println(ans);
	}
}
