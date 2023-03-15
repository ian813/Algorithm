import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static int N;
	static ArrayList<Integer> numList = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		// N값 입력받기
		N = sc.nextInt();
		
		// N개의 숫자 입력받기
		for(int idx = 0; idx < N; idx++) {
			numList.add(sc.nextInt());
		}
		
		sc.close();
	}
	
	static void sort() {
		input();
		
		// 내장함수 통해 정렬
		Collections.sort(numList);
		
		// foreach문으로 값 뽑아서 스트링빌더에 추가
		for(int num : numList) {
			// 개행도 꼭 같이 입력받기
			sb.append(num).append("\n");
		}
	}
	
	public static void main(String[] args) {
		sort();
		// 출력
		System.out.println(sb);
	}
}