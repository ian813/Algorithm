import java.util.Scanner;

public class Main {
	
	// N, M, L 변수 생성
	static int numPerson; // N
	static int receiveCnt; // M
	static int receivePerson; // L
	
	// 각 사람이 몇 번 받았는지 저장할 배열
	static int[] cntArr;

	// 던지는 횟수의 총합을 셀 변수
	static int sum;
	
	// input 메서드
	static void input() {
		Scanner sc = new Scanner(System.in);
		
		// 변수에 값 입력받기
		numPerson = sc.nextInt();
		receiveCnt = sc.nextInt();
		receivePerson = sc.nextInt();
		
		// 배열을 numPerson크기로 생성
		cntArr = new int[numPerson];
		
		sc.close();
		
	}
	
	static void count()	{
		
		// input메서드로 값 입력받은 후 그 값들 이용
		input();
		
		// 처음엔 무조건 1번자리 사람이 받으므로
		cntArr[0] = 1;
		
		// 처음 시작하는 위치
		int idx = 0;
		
		// 공던지기를 조건을 만족할 때까지 무한반복 해보자.
		// 목적 : 던지기를 반복하면서 던지는 위치를 newIdx로 계속 업데이트 해주고
		// 받는 사람의 위치는 idx를 찾듯이 찾는다.
		while(true) {
			
			// 만약 한 번 받으면 끝나는 경우면
			// 이미 1번이 한 번 받았으므로 바로 끝.
			if(receiveCnt == 1) {
				break;
			}
			

			if(cntArr[idx] % 2 == 0) {
				// 짝수일 때 반시계방향으로 던지기
				if(idx - receivePerson < 0) {
					// 반시계방향으로 던질 때 받는 사람의 인덱스가 0보다 작아질 경우
					int newIdx = numPerson + idx - receivePerson;
					
					// 받은 사람의 인덱스에 값을 ++
					cntArr[newIdx]++;
					
					idx = newIdx;
					
					// 받는 목표치에 도달하면 break
					if(cntArr[newIdx] == receiveCnt) {
						break;
					}
				} else {
					// 반시계방향으로 던질 때 받는 사람의 인덱스가 0보다 작지 않은 경우
					int newIdx = idx - receivePerson;
					
					// 위와 같은 식으로...
					cntArr[newIdx]++;
					
					idx = newIdx;
					
					if(cntArr[newIdx] == receiveCnt) {
						break;
					}
				}
				
				
				
			} else {
				// 홀수일 때 시계방향으로 던지기
				if(idx + receivePerson < numPerson) {
					// 시계방향으로 던질 때 받는 사람의 인덱스가 numPerson보다 작은 경우
					int newIdx = idx + receivePerson;
					
					// 위와 같은 식으로...
					cntArr[newIdx]++;
					
					idx = newIdx;
					
					if(cntArr[newIdx] == receiveCnt) {
						break;
					}
				} else {
					// 시계방향으로 던질 때 받는 사람의 인덱스가 numPerson보다 크거나 같은 경우
					int newIdx = idx + receivePerson - numPerson;
					
					// 위와 같은 식으로...
					cntArr[newIdx]++;
					
					idx = newIdx;
					
					if(cntArr[newIdx] == receiveCnt) {
						break;
					}
				}
			}
			
			
		}
		
	}
	
	static void sumCount() {
		// count 메서드 쓰기
		count();
		
		// 위의 배열은 공을 받는 값들을 저장했는데 우리가 원하는 건
		// 던지는 횟수이므로 -1로 시작
		sum = -1;
		
		// 배열 돌면서 합 구하기
		for(int idx = 0; idx < numPerson; idx++) {
			sum += cntArr[idx];
			
		}
		
	}
	
	public static void main(String[] args) {
		// sumCount 메서드 사용
		sumCount();
		
		// 출력
		System.out.println(sum);
		
		
	}
}