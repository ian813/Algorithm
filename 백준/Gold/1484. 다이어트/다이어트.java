import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int G = sc.nextInt();

        // 두 포인터
        long leftPointer = 1;
        long rightPointer = 1;

        StringBuilder sb = new StringBuilder();

        // 가능한 몸무게가 있는지 판단할 불리안
        boolean flag = false;

        while (rightPointer < 100000) {
            // G 범위가 100000이하이므로 범위 설정
            // ans 구하기
            long ans = rightPointer * rightPointer - leftPointer * leftPointer;

            // ans와 G 비교해서 포인터값 알맞게 조정
            if (ans < G) rightPointer++;
            else if (ans > G) leftPointer++;
            else {
                // 만약 같으면 가능한 몸무게이므로 flag = true
                flag = true;
                // rightPointer 저장 후 +1
                sb.append(rightPointer++).append("\n");
            }
        }

        if (flag) {
            // 가능한 몸무게 있으면 스트링빌더 출력
            System.out.println(sb);
        } else {
            // 가능한 몸무게 없으면 -1 출력
            System.out.println(-1);
        }
    }
}