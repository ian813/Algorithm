import java.util.Scanner;

public class Main {

    // 과목 수, 각 과목의 수업시간 수, 학생 수
    static int subject, period, student;
    // 각 과목의 실제 수업 시간
    static int[][] time;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        subject = sc.nextInt();

        time = new int[subject][52];

        // 각 과목의 시간 정보 입력받기
        for (int i = 0; i < subject; i++) {
            period = sc.nextInt();

            time[i][51] = period;

            for (int j = 0; j < period; j++) {
                int tmp = sc.nextInt();

                time[i][tmp]++;
            }
        }

        student = sc.nextInt();

        // 학생 수만큼 반복해서 각 학생마다 추가할 수 있는 과목 수를 카운팅 해준다.
        for (int i = 0; i < student; i++) {
            // 각 학생의 비어있는 시간 개수 입력받기
            int re = sc.nextInt();
            
            // 비어있는 시간을 입력받을 배열
            int[] tmp = new int[re];
            
            // 입력받기
            for (int j = 0; j < re; j++) {
                tmp[j] = sc.nextInt();
            }

            // 추가 가능한 과목 수 카운팅
            int cnt = 0;

            for (int j = 0; j < subject; j++) {
                // 매 과목마다 들어갈 수 있는지 체크할 불리안
                boolean check = false;
                int tmpCnt = 0;
                for (int k = 0; k < re; k++) {
                    if(time[j][tmp[k]] == 1) { // 만약 시간표에 집어넣을 수 있는 시간이면 카운팅
                        tmpCnt++;
                    }
                    if (tmpCnt == time[j][51]) { // 카운팅 값이 해당 과목의 교시 수만큼 채워졌으면 불리안 true로 바꾸고 break
                        check = true;
                        break;
                    }
                }
                // 들어갈 수 있으면 카운팅
                if (check) cnt++;
            }

            sb.append(cnt + "\n");
        }
        System.out.println(sb);
    }
}
