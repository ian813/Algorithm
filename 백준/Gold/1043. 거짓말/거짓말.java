import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int people, party, truePerson; // 사람수, 파티수, 진실아는 사람수
	static int[] truePeople, p; // 진실아는 사람 번호, 대표를 저장할 배열
	static ArrayList<ArrayList<Integer>> participant; // 참가자 정보
	static boolean[] check; // 대표자가 같은지 확인할 배열
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		people = sc.nextInt();
		party = sc.nextInt();
		truePerson = sc.nextInt();
		
		check = new boolean[people+1];
		
		truePeople = new int[truePerson];
		for(int idx = 0; idx < truePerson; idx++) {
			int tempPerson = sc.nextInt();
			truePeople[idx] = tempPerson;
			check[tempPerson] = true; // 진실아는지 여부 체크
		}
		
		p = new int[people+1]; // 사람 수만큼 생성
		
		// 대표를 자기자신으로 설정
		for(int i = 1; i <= people; i++) {
			p[i] = i;
		}
		
		participant = new ArrayList<>();
		
		for(int i = 0; i < party; i++) {
			// 각 파티의 참가자 수 입력받고
			int size = sc.nextInt();
			// 임시 리스트 생성
			ArrayList<Integer> temp = new ArrayList<>();
			for(int j = 0; j < size; j++) {				
				// 참가자 수 만큼 임시 리스트에 값 입력 받기
				temp.add(sc.nextInt());
			}
			// 임시리스트를 차례대로 참가자 정보 리스트에 추가
			participant.add(temp);
		}
		
		sc.close();
	}
	
	// 대표자가 같은지 체크할 메서드
	static int findSet(int x) {
		if(x != p[x]) {
			p[x] = findSet(p[x]);
		}
		
		return p[x];
	}
	
	// 대표자를 통일할 메서드
	static void union(int x, int y) {
		p[findSet(y)] = findSet(x);
	}
	
	public static void main(String[] args) {
		input();
		
		for(int i = 0; i < party; i++) {
			if(participant.get(i).size()>=2) { // 같은 파티에 참석하는 참가자들을 탐색
				for(int j = 0; j < participant.get(i).size()-1; j++) {
					int x = participant.get(i).get(j);
					int y = participant.get(i).get(j+1);
					
					if(findSet(x) != findSet(y)) { // 대표자가 다르면 합쳐준다.
						union(x, y);
					}
				}
			}
		}

		// 진실을 알고 있는 사람과 같은 대표를 공유하면 그 사람도 진실을 알고 있다고 체크
		for(int i = 0; i < truePerson; i++) {
			for(int j = 1; j <= people; j++) {
				if(findSet(truePeople[i]) == findSet(j)) {
					check[j] = true;
				}
				
			}
		}
		
		int ans = 0; // 거짓말 할 파티 수를 세줄 변수
		
		for(int i = 0; i < party; i++) { // 파티를 돌면서 거짓말할 수 있는지 체크해보자
			boolean flag = false; // 거짓말 여부 체크할 불리안
			for(int person : participant.get(i)) { // i번째 파티에 있는 사람들을 확인
				if(check[person]) { // 진실 알고 있는 사람 있으면
					flag = true; // 거짓말 못한다고 표시하고 멈춤
					break;
				}
			}
			if(!flag) ans++; // 거짓말 할 수 있으면 카운트
		}
		System.out.println(ans);
	}
}