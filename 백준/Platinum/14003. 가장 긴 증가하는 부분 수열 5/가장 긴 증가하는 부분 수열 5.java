import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] seq = new int[N];
		int[] LIS = new int[N];
		int[] index = new int[N];

		// 수열정보 입력받기
		for (int i = 0; i < N; i++) {
			seq[i] = sc.nextInt();
		}

		sc.close();

		// LIS 초기 값으로 첫 번째 수열의 값을 갖는다.
		LIS[0] = seq[0];

		// 수열 길이 저장할 변수
		int lengthOfLIS = 1;

		for (int i = 1; i < N; i++) {
			// 현재 수열의 수를 키값으로!
			int key = seq[i];

			boolean check = false;

			// 만약 key가 LIS의 마지막 값보다 클 경우 추가해준다.
			if (LIS[lengthOfLIS - 1] < key) {
				lengthOfLIS++;
				LIS[lengthOfLIS - 1] = key;
				// 해당 키값이 들어간 인덱스를 인덱스 배열에 저장해준다.
				index[i] = lengthOfLIS - 1;
			} else {
				// 아니라면
				// Lower Bound 이분탐색을 진행한다.
				int lo = 0;
				int hi = lengthOfLIS;
				while (lo < hi) {
					int mid = (lo + hi) / 2;

					if (LIS[mid] < key) {
						lo = mid + 1;
					} else {
						hi = mid;
					}

				}
				/*
				 *  lo가 LIS에서 대치 될 원소의 위치가 될 것이고
				 *  해당 위치에 key값으로 원소를 바꿔준다.
				 *  해당 위치값을 인덱스배열에 저장해준다.
				 */

				LIS[lo] = key;
				index[i] = lo;
			}
		}

		// 위 과정을 통해 나온 LIS의 길이를 담아준다.
		StringBuilder sb = new StringBuilder();
		sb.append(lengthOfLIS).append("\n");

		// LIS를 만족하는 수열도 출력해야 한다.
		// 이 때 각 원소가 어떤 인덱스에 들어갔는지 저장해줬으므로
		// 끝에서부터 역으로 찾으면서 만족하는 인덱스가 나왔을 때마다 뽑아주면 된다.
		Stack<Integer> stack = new Stack<>();

		// 뽑아준 값을 스택에 하나씩 저장해주자 (끝 수부터 나오므로)
		for (int i = N - 1; i >= 0; i--) {
			if (index[i] == lengthOfLIS - 1) {
				stack.push(seq[i]);
				lengthOfLIS--;
			}
			// 다 찾아줬으면 멈추기
			if (lengthOfLIS < 0)
				break;
		}

		// 스택이 빌 때까지 뽑아서 담아주기
		while (!stack.isEmpty()) {
			sb.append(stack.pop() + " ");
		}

		// 출력
		System.out.println(sb);
	}
}