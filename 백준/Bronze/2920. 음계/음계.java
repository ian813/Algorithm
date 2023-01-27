import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 숫자 받을 배열 생성
		int[] input = new int[8];
		// 숫자 입력받기
		for(int idx = 0; idx < input.length; idx++) {
			input[idx] = sc.nextInt();
		}
		
		// 결과값을 받을 문자열 생성
		String result = "";
		
		// 오름차순인 경우, 내림차순인 경우, 섞인 경우를 나눠서 결과 출력
		// 오름차순이 끝까지 유지되면 ascending, 중간에 섞이면 mixed 출력
		// 내림차순이 끝까지 유지되면 descending, 중간에 섞이면 mixed 출력
		for(int i = 0; i < input.length - 1; i++) {
			if(input[i] + 1 == input[i+1]) {
				result = "ascending";
			} else if(input[i] - 1 == input[i+1]) {
				result = "descending";
			} else {
				result = "mixed";
				break;
			}
		}
		
		System.out.println(result);
	}
}