import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
             
        // 배열의 길이를 입력받고 1을 더해주자.
        // why?
        // 이유는 밑에...
        int arrayLength = sc.nextInt() + 1;
            
        // 입력받은 크기+1만큼의 배열을 생성하고
        int[] testArray = new int[arrayLength];
             
        // 그 안에 값을 입력받자. (맨 첫 항은 0으로 고정시킨다.)
        // 따라서 idx = 1부터 시작
        // why?
        // 이유는 밑에..
 
        for(int idx = 1; idx < arrayLength; idx++) {
            testArray[idx] = sc.nextInt();
        }
             
        // 배열의 크기를 늘리고 맨 첫 항을 0으로 고정시키는 이유
        // 왜냐하면 크기가 1인 배열은 무조건 길이가 1인 부분 증가 수열을 갖는데
        // 이 때는 비교할 대상이 없기 때문에 for문으로 돌리기 힘듦.
        // 따라서 testArray 크기를 1 늘리고 첫 항에 0을 무조건 넣어서
        // 원래 첫 번째 항에 있던 값을 0과 비교해서 크기 때문에 부분 증가 수열의 크기가 1이다.
        // 라는 식으로 풀고 싶다.
             
        // 각 인덱스까지의 증가 부분 수열의 가장 큰 크기를 변수로 받을 배열 생성
        int[] maxArray = new int [arrayLength];
             
        // 목적 : 최장 증가 부분 수열 찾기
        // 인덱스가 0일 때의 값은 0으로 고정시켰으므로
        // 인덱스가 1일 때부터 탐색
        for(int startIdx = 1; startIdx < testArray.length; startIdx++) {
                 
            // startIdx보다 인덱스가 작은 idx에 대해
            for(int idx = 0 ; idx < startIdx; idx++) {
                     
                // testArray[idx] < testArray[startIdx]이면
                // testArray[idx] 뒤에 testArray[startIdx]를 붙여 줄 수 있다.
                // 즉 부분 증가 수열이 성립한다.
                     
                // 그때의 증가 부분 수열의 크기를 비교했을 때 
                // maxArray[startIdx] <= maxArray[idx]라면
                // maxArray[startIdx] 값을 maxArray[idx] + 1으로 갱신해주고
                // 이를 startIdx가 될 때까지 반복한다.
                if(testArray[idx] < testArray[startIdx]) {
                	if(maxArray[startIdx] <= maxArray[idx]) {
                        maxArray[startIdx] = maxArray[idx] + 1;
                	}
                }
                 
            }
        }
             
        // 각 인덱스에서의 최장 증가 부분 수열 값을 찾았으므로
        // 그 중 최댓값을 찾으면 된다.
        // max값을 담을 변수 생성
        int max = 0;
             
        // maxArray배열을 돌면서 최댓값 탐색
        for(int idx = 0; idx < maxArray.length; idx++) {
            if(max < maxArray[idx]) {
                max = maxArray[idx];
            }
        }
             
        // 출력해보자.
        System.out.println(max);
  
    }                       
}
