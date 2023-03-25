import java.util.Scanner;

public class Main {
	static int num;
	static int[] numArr;
	static int[] operator;
	
	static final int plus = 0;
	static final int minus = 1;
	static final int multiple = 2;
	static final int divisor = 3;
	
	static int max;
	static int min;
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		
		num = sc.nextInt();
		
		numArr = new int[num];

		for(int idx = 0; idx < num; idx++) {
			numArr[idx] = sc.nextInt(); // 수 입력받기
		}
		
		operator = new int[4];
		
		for(int idx = 0; idx < 4; idx++) {
			operator[idx] = sc.nextInt(); // 연산자 개수 입력받기
		}
		
		sc.close();
	}
	
	static void search(int result, int idx) {
		if(idx == num) { // 수를 전부 사용했으면
			// 최대 최소값 갱신 후 return
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}
		
		for(int op = 0; op < 4; op++) {
			if(operator[op] != 0) { // 남은 연산자가 존재할 때
				switch(op) { // 연산자에 따라 맞춰서 시행
				case plus : // 플러스면 더해주고 플러스 연산자 개수 감소
//					result += numArr[idx]; 이런 식으로 계산해주고 재귀 호출하면 오류 발생...
					// 왜냐하면 재귀를 끝내고 되돌아왔을 때 원래 값을 써야되는데 계산된 값을 써주므로...
					operator[op]--;
					// 그 다음 재귀함수 호출
					search(result + numArr[idx], idx + 1);
					break;
				case minus : // 마이너스면 빼주고 마이너스 연산자 개수 감소
//					result -= numArr[idx];
					operator[op]--;
					// 그 다음 재귀함수 호출
					search(result - numArr[idx], idx + 1);
					break;
				case multiple : // 곱하기면 곱해주고 곱하기 연산자 개수 감소
//					result *= numArr[idx];
					operator[op]--;
					// 그 다음 재귀함수 호출
					search(result * numArr[idx], idx + 1);
					break;
				case divisor : // 나누기면 나눠주고 나누기 연산자 개수 감소
					 // 음수를 나눠주는 거면 양수로 변환 후 나눠주고 다시 음수로 바꿔줘야 하는데 그냥 나눠줘도 잘 실행되네..?
//					result /= numArr[idx];
					operator[op]--;
					// 그 다음 재귀함수 호출
					search(result / numArr[idx], idx + 1);
					break;
				}
				// 재귀함수가 복귀하면 연산자 사용했던 거 원상복구
				operator[op]++;
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		input();
		// 최대, 최소 초기화
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
		// 0번 인덱스에 있는 수는 이미 써줬으니
		// 인덱스 1부터 시작하자.
		search(numArr[0], 1);
		
		System.out.println(max);
		System.out.println(min);
	}
	
}
