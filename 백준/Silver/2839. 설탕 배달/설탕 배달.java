import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 숫자 입력받기
        int num = sc.nextInt();
		
        // num의 범위가 5000까지이므로,,
        // 인덱스 5000까지 가지도록 배열 생성
		int[] numOfBag = new int[5001];
		
        // 1~7까지 봉지 개수는 손쉽게 구할 수 있다.
        numOfBag[3] = numOfBag[5] = 1;
        numOfBag[4] = numOfBag[7] = -1;
        numOfBag[6] = 2;
		
		// 그 이상 무게에서의 봉지개수는
        // 일단 정수형의 최대값으로 다 넣어준다.
        for (int idx = 8; idx <= num; idx++) {
            numOfBag[idx] = Integer.MAX_VALUE;
        }
        
		// 배열에 알맞은 봉지의 개수를 넣어보자.
        for (int idx = 8; idx <= num; idx++) {

            if (numOfBag[idx-3] != -1 && numOfBag[idx-5] != -1) {
            	// 구하려는 인덱스에 -3 -5를 각각 했을 때 봉지 개수가
            	// 둘 다 -1이 아니면
            	// 일단 가능한 경우이고
            	// 그 2개에서의 봉지 개수 + 1한 값 중 최솟값에 +1한 값이
            	// 현재 인덱스의 봉지 개수이다.
            	numOfBag[idx] = Math.min(numOfBag[idx-3], numOfBag[idx-5]) + 1;
            } else if (numOfBag[idx-3] != -1) {
            	// 만약 -3 한 인덱스의 봉지 개수만
            	// -1이 아니면
            	// 그 봉지 개수에 +1한 값이
            	// 현재 인덱스의 봉지 개수이다.
                numOfBag[idx] = numOfBag[idx-3] +1;
            } else if (numOfBag[idx-5] != -1) {
            	// 만약 -5 한 인덱스의 봉지 개수만
            	// -1이 아니면
            	// 그 봉지 개수에 +1한 값이
            	// 현재 인덱스의 봉지 개수이다.
                numOfBag[idx] = numOfBag[idx-5] +1;
            } else {
            	// -3, -5한 값이 모두 -1이면
            	// 현재 인덱스 역시 불가능하므로
            	// -1을 저장해준다.
                numOfBag[idx] = -1;
            }

        }
        System.out.println(numOfBag[num]);
	}
}