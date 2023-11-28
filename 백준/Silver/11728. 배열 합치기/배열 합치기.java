import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 배열 크기 두개 입력받기
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 두 배열은 정렬되어 있으므로 두 포인터를 써보자.
		int[] A = new int[N];
		int[] B = new int[M];

        st = new StringTokenizer(br.readLine());
		// 두 배열 입력받기
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

        st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		// 포인터 두개 설정
		int pointerA = 0;
		int pointerB = 0;

		StringBuilder sb = new StringBuilder();

		// 두 포인터 모두 배열 안에 있을 때 실행
		while (pointerA < N && pointerB < M) {
			if (A[pointerA] <= B[pointerB]) {
				// A배열 값이 작거나 같으면 A배열 값을 저장
				sb.append(A[pointerA++] + " ");
			} else {
				// B배열 값이 더 작으면 B배열 값을 저장
				sb.append(B[pointerB++] + " ");
			}
		}

		// 두 배열 중 하나의 포인터가 끝까지 도달 못한 쪽이 존재하므로
		// 나머지 값을 저장해준다.
		if (pointerA == N) {
			// A의 포인터가 끝까지 갔으면
			// B의 포인터가 끝까지 갈 때까지 B배열 값 저장
			while (pointerB < M) {
				sb.append(B[pointerB++] + " ");
			}
		} else {
			// 반대면 반대로 실행
			while (pointerA < N) {
				sb.append(A[pointerA++] + " ");
			}
		}

		// 출력
		System.out.println(sb);
	}
}