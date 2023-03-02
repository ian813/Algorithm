import java.util.Scanner;

public class Main {
	// 시험장 개수
	static int testPlace;
	// 각 시험장의 학생수
	static int[] student;
	// 총감독관이 감시할 수 있는 인원
	static int monitor;
	// 부감독관이 감시할 수 있는 인원
	static int monitor2;
	// 필요한 감독관 수
	static long supervisor;
	
	// 인풋 메서드
	static void input() {
		Scanner sc = new Scanner(System.in);
		
		testPlace = sc.nextInt();
		
		// 시험장 개수만큼 배열 생성
		student = new int[testPlace];
		
		for(int idx = 0; idx < testPlace; idx++) {
			// 각 시험장별 학생 수
			student[idx] = sc.nextInt();
		}
		
		// 감시 가능 인원수
		monitor = sc.nextInt();
		monitor2 = sc.nextInt();
		
	}
	
	static void place() {
		input();
		// 감독관 수 0으로 초기화
		supervisor = 0;
		
		for(int idx = 0; idx < testPlace; idx++) {
			// 총감독관을 각 시험장 별로 배치해주고
			student[idx] -= monitor;
			// 감독관 수 카운팅
			supervisor++;
			
			if(student[idx] > 0) {
				// 학생수가 0보다 크면
				// 부감독관을 계속 배치시켜줘야 하는데,,
				if(student[idx] % monitor2 == 0) {
					// 부감독관이 감시할 수 있는 학생 수로 나눠떨어지면
					// 그 몫만큼 부감독관을 추가시키면 된다.
					supervisor += student[idx] / monitor2;
				} else {
					// 나눠떨어지지 않으면
					// 몫 + 1만큼 추가해준다.
					supervisor += student[idx] / monitor2 + 1;
				}
			}
			
		}
		// 감독관 수 출력하기
		System.out.println(supervisor);
	}
	
	public static void main(String[] args) {
		place();
	}
}