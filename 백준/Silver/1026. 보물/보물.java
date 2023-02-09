import java.util.Scanner;

public class Main {
	// 목적 : 최소 합 구하기 => (A의 i번째 작은수 * B의 i번째 큰수)의 합을 구하면 된다.
	
	
	// 배열 크기 N, 두 배열 A, B
	// 배열에 순위를 메길 두 배열 rankA, rankB
	// 최소합을 담을 minSum
	static int N;
	
	static int[] A;
	
	static int[] B;
	
	static int[] rankA;
	
	static int[] rankB;
	
	static int minSum;
	
	
	// 입력 받아주는 메서드 생성
	static void input() {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		// N의 크기만큼 A, B 배열 생성
		A = new int[N];
		B = new int[N];
		
		// A, B에 데이터 입력받기
		for(int idx = 0; idx < N; idx++) {
			A[idx] = sc.nextInt();
		}
		
		for(int idx = 0; idx < N; idx++) {
			B[idx] = sc.nextInt();
		}
		
	}
	
	// 작은게 1등으로 rank매기기
	static int[] ascendingRank(int[] arr) {
		// rankA배열 생성
		rankA = new int[N];
		
		for(int idx1 = 0; idx1 < N; idx1++) {
			// 배열을 돌면서
			
			int rank = 1;
			// rank값은 1로 계속 초기화
			for(int idx2 = 0; idx2 < N; idx2++) {
				
				if(arr[idx1] > arr[idx2]) {
					// 크면 등수가 떨어지도록 한다. (작은게 1등!)
					rank++;
				} else if(arr[idx1] == arr[idx2]) {
					// 만약 중복된 수가 나오면
					// 둘 중에 하나의 순위를 강제적으로 떨군다.
					// 굳이 두 경우로 나눠준 이유는 전체를 탐색하기 때문에
					// 크거나 같다로 하면 중복된 수 양쪽 다 순위가 올라가서
					// 예외가 발생
					if(idx1 < idx2) {
						rank++;
					}
				}
			}
			// 계산된 rank값을 배열에 넣어준다.
			rankA[idx1] = rank;
		}
		return rankA;
	}
	
	// 값이 큰 게 1등
	// ascendingRank와 방법은 같고
	// 첫 조건절에 if문의 부등호 방향만 다르다.
	static int[] descendingRank(int[] arr) {
		rankB = new int[N];
		
		for(int idx1 = 0; idx1 < N; idx1++) {
			
			int rank = 1;
			
			for(int idx2 = 0; idx2 < N; idx2++) {
				
				if(arr[idx1] < arr[idx2]) {
					// 여기만 다름.
					rank++;
					
				} else if(arr[idx1] == arr[idx2]) {
					
					if(idx1 < idx2) {
						rank++;
					}
				}
			}
			rankB[idx1] = rank;
		}
		return rankB;
	}
	
	// 최소합을 구하는 메서드(목적에서 썼던 방식을 구현해보자.)
	static int minimumSum(int[] arrA, int[] arrB) {
		// 최소합을 0으로 선언
		minSum = 0;
		
		// 위의 두 메소드를 적용해서 rank 배열 2개를 반환한다.
		ascendingRank(arrA);
		descendingRank(arrB);
		
		for(int idx1 = 0; idx1 < N; idx1++) {
			// 배열을 돌면서
			for(int idx2 = 0; idx2 < N; idx2++) {
				// 두 배열의 값이 같다면
				// (한 쪽은 큰 수부터 순위고 다른 한 쪽은 작은 수부터 순위이므로
				// i번째로 큰 수와 i번쨰로 작은 수를 찾아주었다는 뜻이다.)
				if(rankA[idx1] == rankB[idx2]) {
					
					// 그 때의 index를 각각 넣어줘서 계산해준다.
					minSum += arrA[idx1] * arrB[idx2];
				}
			}
		}
		
		return minSum;
	}
	
	public static void main(String[] args) {
		// 필요한 메서드들 차례로 실행
		input();
		
		minimumSum(A, B);
		
		System.out.println(minSum);
		
	}
}
