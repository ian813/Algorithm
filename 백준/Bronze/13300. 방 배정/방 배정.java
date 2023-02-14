import java.util.Scanner;

public class Main {
	
	// 학생수 변수
	static int studentNum;
	
	// 한 방의 정원 변수
	static int roomLimit;
	
	// 성별, 학년 변수
	static int gender;
	
	static int grade;
	
	// 학생의 정보를 받을 배열
	static int[][] student;
	
	// 필요한 방의 개수를 셀 변수
	static int roomCnt;
	
	// input 메서드
	static void input() {
		Scanner sc = new Scanner(System.in);
		
		// 학생 수, 방 정원 입력받기
		studentNum = sc.nextInt();
		
		roomLimit = sc.nextInt();
		
		// 배열 생성
		student = new int [2][6];
		
		// 성별, 학년 입력받고
		// 알맞은 배열의 위치에 학생 수 올려주기
		for(int num = 0; num < studentNum; num++) {
			gender = sc.nextInt();
			grade = sc.nextInt();
			
			student[gender][grade-1]++;
			
		}
	
		sc.close();
		
	}
	
	static void room() {
		input();
		
		// 방 개수 세기
		roomCnt = 0;
		
		// 배열을 돌면서
		for(int row = 0; row < 2; row++) {
			
			for(int col = 0; col < 6; col++) {
				
				// 학생 수가 없으면 continue
				if(student[row][col] == 0) {
					continue;
				} else if ((student[row][col] <= roomLimit)) {
					// 정원보다 작거나 같은 학생수가 있으면 방 개수 더해주기
					roomCnt++;
				} else {
					// 정원보다 큰 학생 수가 있으면
					// 학생수를 방 정원으로 나눈 수만큼 더해주고
					// 나누어 떨어지지 않으면 한 번 더 더해주기
					roomCnt += student[row][col] / roomLimit;
					if(student[row][col] % roomLimit != 0) {
						roomCnt++;
					}
				}
				
			}

		}
		
		System.out.println(roomCnt);
		
	}
	
	
	public static void main(String[] args) {
		room();
	}
}