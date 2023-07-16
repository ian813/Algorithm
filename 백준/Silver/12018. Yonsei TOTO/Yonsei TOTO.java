import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static int subject, mileage;
    static PriorityQueue<Integer> queue;
    static ArrayList<Integer> mileageInfo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 과목수, 갖고있는 마일리지
        subject = sc.nextInt();
        mileage = sc.nextInt();
        
        // 각 과목을 들으려면 사용해야할 최소 마일리지 정보 (자동으로 오름차순 정렬하기 위해 우선순위큐 사용)
        queue = new PriorityQueue<>();
        
        // 과목 수만큼 정보 받기
        for (int i = 0; i < subject; i++) {
            // 각 과목에 신청한 사람 수, 수강제한인원
            int appliedPeople = sc.nextInt();
            int capacity = sc.nextInt();

            // 각 과목에 사람들이 넣은 마일리지 정보 담을 리스트
            mileageInfo = new ArrayList<>();

            for (int j = 0; j < appliedPeople; j++) {
                // 신청한 사람 수만큼 마일리지 정보 입력받기
                mileageInfo.add(sc.nextInt());
            }
            // 내림차순 정렬
            Collections.sort(mileageInfo, Collections.reverseOrder());

            if (appliedPeople >= capacity) { // 신청한 사람이 제한인원이상이면
                // 제한인원에 걸리는 사람의 마일리지 정보를 받아와서 저장
                int curMileage = mileageInfo.get(capacity-1);
                queue.add(curMileage);
            } else {
                // 제한인원이 더 많으면 마일리지 1만 넣어도 신청가능하므로 1 저장
                queue.add(1);
            }
        }

        // 들을 수 있는 최대 과목 수
        int ans = 0;

        while (!queue.isEmpty()) { // 큐가 빌 때까지 실행
            int cur = queue.poll(); // 현재 마일리지
            mileage -= cur; // 현재 마일리지를 갖고있는 마일리지에서 차감
            if (mileage >= 0) { // 0이상이면 과목 수 카운팅
                ans++;
            } else { // 아니면 바로 멈춰주기
                break;
            }
        }
        System.out.println(ans);


    }
}