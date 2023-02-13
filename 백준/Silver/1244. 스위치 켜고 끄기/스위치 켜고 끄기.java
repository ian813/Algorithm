import java.util.Scanner;

public class Main {
	
	// 스위치 개수를 담을 변수, 스위치 값을 담을 배열, 학생수, 성별, 할당된 자연수를 받을 변수들 생성
	static int numOfSwitch;
	
	static int[] switchArr;
	
	static int student;
	
	static int gender;
	
	static int num;
	
	static void solution() {
		Scanner sc = new Scanner(System.in);
		
		// 스위치 개수 입력받기
		numOfSwitch = sc.nextInt();
		
		// 스위치 개수를 크기로 하는 배열 생성
		switchArr = new int[numOfSwitch];
		
		// 배열에 값 입력받기
		for(int idx = 0; idx < numOfSwitch; idx++) {
			
			switchArr[idx] = sc.nextInt();
			
		}
		
		// 학생 수 입력받기
		student = sc.nextInt();
		
		// 학생수만큼 성별과 할당된 자연수 입력받고 
		// 배열을 탐색해보자.
		for(int st = 0; st < student; st++) {
			gender = sc.nextInt();
			
			num = sc.nextInt();
			
			// 성별이 남자면
			if(gender == 1) {
				
				for(int idx = 0; idx < numOfSwitch; idx++) {
					// 배열의 index값이 num으로 나눠지면
					// (idx는 0부터 시작이고 문제에서는 인덱스를 1부터 시작으로 지정했으므로 +1을 해줘서 비교)
					if((idx+1) % num == 0) {
						// 0은 1로, 1은 0으로 변경
						if(switchArr[idx] == 0) {
							switchArr[idx] = 1;
						} else {
							switchArr[idx] = 0;
						}
					}
					
				}
			} else {
				// 성별이 여자면
				
				// 양의 방향, 음의 방향을 담을 변수 생성
				int plusRow = 1;
				int minusRow = -1;
				
				
				// -1 해주는 이유는 배열의 인덱스를 문제에서 1부터 시작으로 명시했기 때문
				int idx = num - 1;
				
				// 자기 자신부터 일단 바꿔주자.
				// 1이면 0으로, 0이면, 1로
				if(switchArr[idx] == 0) {
					switchArr[idx] = 1;
				} else {
					switchArr[idx] = 0;
				}
				
				for(int ns = 1; ns < numOfSwitch; ns++) {
					// idx 주변인덱스 탐색
					int newPlusIdx = idx + plusRow * ns;
					int newMinusIdx = idx + minusRow * ns;	
					
					// 새 인덱스들이 배열의 범위를 넘어가면 continue!
					if(newMinusIdx < 0 || newPlusIdx >= numOfSwitch) {
						continue;
					} else {
					// 배열의 범위 안이라면
							
						if(switchArr[newPlusIdx] == switchArr[newMinusIdx]) {
							// 좌우의 스위치 값이 같으면 그 값을 0이면 1, 1이면 0으로 바꿔주자.
							if(switchArr[newPlusIdx] == 0) {
								switchArr[newPlusIdx] = 1;
								switchArr[newMinusIdx] = 1;
							} else {
								switchArr[newPlusIdx] = 0;
								switchArr[newMinusIdx] = 0;
							}
							
						} else {
							// 좌우 스위치 값이 다르면 바로 탐색 중지
							break;
						}
					}
						
				}
			}
		}
	}	

	
	public static void main(String[] args) {
		// 위의 메서드로 올바른 스위치 배열을 구하자.
		solution();
		
		// 스위치 배열을 출력!
		// 출력하기 까다롭네...
		for(int idx = 0; idx < numOfSwitch; idx++) {
			
			// 20의 배수번째 스위치가 아니거나 마지막 스위치가 아니면
			// 출력하고 공백 주기
			if((idx+1) % 20 != 0 && idx != numOfSwitch -1) {
				System.out.print(switchArr[idx] + " ");
			} else if ((idx+1) % 20 == 0) {
				// 20의 배수번째 스위치면 출력하고 개행
				System.out.println(switchArr[idx]);
			} else {
				// 마지막 스위치면 그냥 출력
				System.out.print(switchArr[idx]);
			}
		}

	}
}