import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 포인트 개수
        int N = sc.nextInt();

        int[][] point = new int[N][2];

        // 포인트 정보
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                point[i][j] = sc.nextInt();
            }
        }

        sc.close();
        
        // 정렬
        Arrays.sort(point, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 첫번쨰 열 기준으로 정렬
                if(o1[0] - o2[0] > 0) return 1;
                else if(o1[0] - o2[0] < 0) return -1;
                else {
                    // 첫번쨰 열 값이 같으면 두번쨰 열 값 기준으로 정렬
                    return o1[1]-o2[1];
                }
            }
        });

        StringBuilder sb = new StringBuilder();
        
        // 형식에 맞게 담고 출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                sb.append(point[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}