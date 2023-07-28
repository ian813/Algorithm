import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 투 포인터로 풀어보자
 * 하단 링크 참고
 * https://lotuslee.tistory.com/30?category=963570
 */

public class Main {
    static int N, S;
    static long cnt;
    static int[] arr;
    static ArrayList<Integer> leftList, rightList;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 수열 크기, 목표하는 합
        N = sc.nextInt();
        S = sc.nextInt();

        // 수열정보
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        // 주어진 배열을 반으로 나눠서
        // 왼쪽에서 나올 수 있는 모든 부분수열의 합을 담을 leftList와
        // 오른쪽에서 나올 수 있는 모든 부분수열의 합을 담을 rightList
        leftList = new ArrayList<>();
        rightList = new ArrayList<>();

        makeSum(0, 0, N/2, leftList); //왼쪽 모든 합 구하기
        makeSum(0, N/2, N, rightList); //오른쪽 모든 합 구하기

        //오름차순 정렬 (그래야 투포인터로 양쪽에서 조여오면서 계산 가능)
        Collections.sort(leftList);
        Collections.sort(rightList);

        // 개수 카운팅
        twoPointer();

        // S가 0이면 1뺴주기 (투포인터에서 모든 부분수열의 합 구하면 부분집합 개수 처럼 2^N개가 나오는데 이때 공집합 포함되듯이 0이 포함된다.)
        // 양쪽에 모두 0이 포함되어 있으므로 S가 0인 경우가 중복 계산된다.
        if(S == 0) cnt-=1;

        System.out.println(cnt);
    }

    static void twoPointer() {
        // 포인터 두개를 지정
        int pointL = 0;
        int pointR = rightList.size()-1;
        while(pointL < leftList.size() && pointR >= 0) { // 포인터가 각각의 리스트 범위 안인 동안에만 반복
            int valL = leftList.get(pointL);
            int valR = rightList.get(pointR);

            if(valL + valR == S) { // 두 포인터에 해당하는 값의 합이 S와 같아지면
                long cntL = 0;
                long cntR = 0;

                // 왼쪽리스트에서 현재 pointL에 해당하는 값과 같은 값 찾기
                while(pointL < leftList.size() && valL == leftList.get(pointL)) {
                    cntL++;
                    pointL++;
                }
                // 오른쪽리스트에서 현재 pointR에 해당하는 값과 같은 값 찾기
                while(pointR >= 0 && valR == rightList.get(pointR)) {
                    cntR++;
                    pointR--;
                }
                // 카운팅
                cnt += cntL*cntR;
            } else if(valL + valR < S) { // 합이 S보다 작으면 L쪽 포인터 증가
                pointL++;
            } else { // 합이 S보다 크면 R쪽 포인터 감소
                pointR--;
            }
        }
    }

    static void makeSum(int sum, int start, int end, ArrayList<Integer> list) {
        if (start == end) { // 시작점과 끝점이 같아지면
            list.add(sum); // 그때의 합을 리스트에 넣어주기
            return;
        }

        // 부분집합처럼
        makeSum(sum, start+1, end, list); // start지점의 수를 sum에 더해주지 않고 넘기고
        makeSum(sum + arr[start], start+1, end, list); // start지점의 수를 sum에 더해주고 넘기고
    }

}
