import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    // 학생 수, 사랑관계 수
    static int student, loveRelation;
    static int[] p; // 대표자
    static ArrayList<Love> loveList; // 사랑관계 담을 리스트

    // 사랑관계 나타낼 클래스 (학생 2명, 애정도, 애정도 순 내림차순 정렬)
    static class Love implements Comparable<Love>{
        int student1, student2, affection;

        Love(int student1, int student2, int affection) {
            this.student1 = student1;
            this.student2 = student2;
            this.affection = affection;
        }

        @Override
        public int compareTo(Love o) { // 내림차순 정렬
            return o.affection - this.affection;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        student = Integer.parseInt(st.nextToken());
        loveRelation = Integer.parseInt(st.nextToken());

        loveList = new ArrayList<>();

        // makeSet
        p = new int[student+1];
        for(int i = 1; i <= student; i++) {
            p[i] = i;
        }
        // 포기시킬 애정도
        int minAffection = 0;

        int pick = 0;

        // 사랑정보 입력받고 리스트에 추가
        for(int i = 0; i < loveRelation; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int student1 = Integer.parseInt(st.nextToken());
            int student2 = Integer.parseInt(st.nextToken());
            int affection = Integer.parseInt(st.nextToken());
            int isTrue = Integer.parseInt(st.nextToken());

            Love l = new Love(student1, student2, affection);
            
            minAffection += affection; // 모든 애정도를 일단 더해주기

            // 이미 성사된 관계는 union, 카운팅
            if(isTrue == 1) {
                union(student1, student2);
                pick++;
                minAffection -= affection; // 성사된 관계의 애정도는 빼주기
            } else { // 성사 안 된 관계들만 리스트에 담아주기
                loveList.add(l);
            }
        }
        // 내림차순 정렬(큰 거를 연결시켜줘서 작은 거를 남겨줘야 한다.)
        Collections.sort(loveList);
        

        for(int i = 0; i < loveList.size(); i++) { // 리스트를 전부 돌면서
            Love l = loveList.get(i);

            if (findSet(l.student1) != findSet(l.student2)) { // 대표자 다르면 카운팅, 유니온
                pick++;
                union(l.student1, l.student2);
                minAffection -= l.affection; // 관계가 성사되었으므로 애정도 빼주기
            }

            if (pick == student - 1) break; // 원하는 만큼 뽑았으므로 중단
        }
        // 출력
        System.out.println(minAffection);
    }
    // findSet
    static int findSet(int x) {
        if(x == p[x]) return x;
        return p[x] = findSet(p[x]);
    }

    // union
    static void union(int x, int y) {
        p[findSet(y)] = findSet(x);
    }
}
