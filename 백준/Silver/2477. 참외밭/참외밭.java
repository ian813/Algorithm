import java.util.Scanner;

public class Main {

	static void solve() {
		Scanner sc = new Scanner(System.in);
		
		// 과일 개수 입력받기
		int fruit = sc.nextInt();
		
		// 방향과 길이를 받을 2차원 배열 생성

		int[][] plane = new int [2][6];
		
		// 1행에 방향을 담고
		// 2행에 그 방향으로 갈 길이를 담자.
		for(int col = 0; col < 6; col++) {
			plane[0][col] = sc.nextInt();
			plane[1][col] = sc.nextInt();
		}
		

		// 목적 : 최대 넓이 - 빠지는 넓이
		// 최대 가로, 세로를 구해서 최대 넓이를 구해보자.
		// 최대넓이, 최대 가로, 최대 세로를 담을 변수
		int maxArea = 0;
		int maxHorizon = 0;
		int maxVertical = 0;
		
		// 배열 돌면서 탐색
		for(int idx = 0; idx < 6; idx++) {

			if(plane[0][idx] == 1) {
				// 동쪽방향으로 가는 것만 찾아서
				// 최대 가로를 구해보자.
				maxHorizon += plane[1][idx];
			} else if(plane[0][idx] == 3) {
				// 남쪽방향으로 가는 것만 찾아서
				// 최대 세로를 구해보자.
				maxVertical += plane[1][idx];
			}
			
		}
		
		// 최대 넓이 구하기
		maxArea = maxHorizon * maxVertical;
		
		// 빠지는 넓이 구하기
		int minusArea = 0;
		
		int minusHorizon = 0;
		int minusvertial = 0;
		
		// 배열 돌면서 빠질 넓이의 가로 세로를 구해보자.
		// 각각의 모양에 따른 빠질 넓이는
	    // 한 변을 기준으로 앞 뒤 변의 길이의 합이 최대길이와 같다면 파인 지점
		// ex) 한 변을 기준으로 앞 뒤 변의 길이의 합이 최대 높이와 같으면 그 변이 파인 변의 가로길이이다.
		// 이를 이용해 파인 부분의 가로 세로 길이를 구해보자.

	    for (int idx = 0; idx < 6; idx++) {
	    	// 바로 앞 뒤의 인덱스의 합을 구해서 최대가로와 같으면 그 인덱스는 빼줄 세로이고
	    	// 바로 앞 뒤의 인덱스의 합을 구해서 최대세로와 같으면 그 인덱스는 빼줄 가로이다.
	    	// 그런데 이렇게 하면,,, 인덱스가 배열의 범위를 초과할 수 있으므로,,,
	    	// 나머지 연산을 통해 구현한다.
	    	if (maxHorizon == plane[1][(idx + 5) % 6] + plane[1][(idx + 1) % 6]) {
	            minusvertial = plane[1][idx];
	            }
	    	if (maxVertical == plane[1][(idx + 5) % 6] + plane[1][(idx + 1) % 6]) {
	    		minusHorizon = plane[1][idx];
	            }
	    }
	    
	    minusArea = minusHorizon * minusvertial;
		
		// 넓이를 빼주고 재배 가능한 과일 수 곱해주기
		System.out.println((maxArea - minusArea)*fruit);
		
	}
		
	
	
	public static void main(String[] args) {
		solve();
	}
}