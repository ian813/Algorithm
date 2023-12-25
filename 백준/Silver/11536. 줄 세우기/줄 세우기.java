import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 사람 수
		int people = Integer.parseInt(br.readLine());

		// 선수들의 입력정보를 저장할 배열과 그걸 오름차순으로 정렬하기 위한 카피배열
		String[] name = new String[people];
		String[] sortName = new String[people];

		// 정보 입력받기
		for (int i = 0; i < people; i++) {
			name[i] = br.readLine();
			sortName[i] = name[i];
		}

		// 오름차순 정렬
		Arrays.sort(sortName);

		if (isIncreasing(name, sortName)) {
			// 오름차순과 일치하면 INCREASING 출력
			System.out.println("INCREASING");
		} else if (isDecreasing(name, sortName)) {
			// 내림차순과 일치하면 DECREASING 출력
			System.out.println("DECREASING");
		} else {
			// 둘 다 아니면 NEITHER 출력
			System.out.println("NEITHER");
		}
	}

	// 오름차순인지 판단할 메서드
	private static boolean isIncreasing(String[] arr, String[] copyArr) {
		for (int i = 0; i < arr.length; i++) {
			// 비교해서 다른게 나오면 false 리턴
			if (!arr[i].equals(copyArr[i])) {
				return false;
			}
		}
		// 그게 아니면 true 리턴
		return true;
	}

	// 내림차순인지 판단할 메서드
	// 판단 인덱스가 거꾸로인 거 빼고 위의 메서드와 같음
	private static boolean isDecreasing(String[] arr, String[] copyArr) {
		for (int i = 0; i < arr.length; i++) {
			if (!arr[i].equals(copyArr[arr.length - 1 - i])) {
				return false;
			}
		}
		return true;
	}
}