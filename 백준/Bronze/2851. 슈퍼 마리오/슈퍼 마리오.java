import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 버섯 점수를 담을 배열 생성
		int[] scores = new int[10];
		
		// 배열에 버섯 점수 담기
		for(int idx = 0; idx < scores.length; idx++) {
			scores[idx] = sc.nextInt();
		}
		
		// 먹은 버섯 점수의 합 담을 변수 생성
		int totalScore = 0;
		
		for(int idx = 0; idx < scores.length; idx++) {
			// 배열을 돌면서 점수를 더하자.
			totalScore += scores[idx];
			
			if(totalScore == 100) {
				// 더한 점수가 100이 되면 totalScore 출력하고 break
				System.out.println(totalScore);
				break;
			} else if(totalScore > 100) {
				// 더한 점수가 100이 넘으면..
				// 현재 totalScore를 출력할지
				// scores[idx]를 더하기 직전의 totalScore를 출력할지 판단해야 한다.
				// 둘 중 어느 값이 100에 가까운지 판단(거리가 같으면 큰 값 출력)
				if (totalScore - 100 <= 100 - (totalScore - scores[idx])) {
					// 현재 totalScore가 더 100에 가깝다.
					// 출력 후 break
					System.out.println(totalScore);
					break;
				} else {
					// 직전 totalScore가 더 100에 가깝다.
					// 직전 totalScore를 출력 후 break
					System.out.println(totalScore - scores[idx]);
					break;
				}
				
			}
		}
		// 예외 경우가 하나 또 있다.
		// 끝까지 다 더했는데 100이 안됐을 때...
		if(totalScore < 100) {
			System.out.println(totalScore);	
		}
	}
}
