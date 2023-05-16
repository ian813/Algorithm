import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int length, endCondition, step, cnt;
	static int[] durability;
	static boolean[] robot;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		
		length = Integer.parseInt(st.nextToken());
		endCondition = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine().trim());
		
		durability = new int[2*length];
		robot = new boolean[2*length];
		
		for(int i = 0; i < 2*length; i++) {
			durability[i] = Integer.parseInt(st.nextToken());
			robot[i] = false;
		}

		step = 0;
		solve();
		
		System.out.println(step);
	}
	
	static void solve() {
		
		while(true) {			
			cnt = 0;
			boolean flag = false; // 종료조건인지 체크할 불리안
			for(int i = 0; i < durability.length; i++) {
				if(durability[i] == 0) { // 내구성이 0이면 카운트
					cnt++;
				}
				if(cnt >= endCondition) { // 종료 조건을 만족하면
					flag = true; // 종료조건이라고 체크하고 멈추기
					break;
				}
			}
			
			if(flag) break; // 종료조건 달성하면 와일문 빠져나오기
			
			// 첫 단계 : 컨베이어벨트 이동
			int tmp = durability[durability.length-1];
			for(int i = durability.length-1; i > 0; i--) {
				durability[i] = durability[i-1];
			}
			durability[0] = tmp;
			
			
			for (int i = robot.length - 1; i > 0; i--) { // 로봇도 벨트와 같이 회전
                robot[i] = robot[i - 1];
            }
            robot[0] = false; // 벨트가 회전하므로 첫 칸은 무조건 로봇이 없다.

            robot[length - 1] = false; // 마지막 칸에서 로봇을 내려주므로 무조건 로봇이 없다.

            for (int i = length - 1; i > 0; i--) {   // 두 번째 단계 : 로봇 이동가능하면 이동
                if (robot[i - 1] && !robot[i] && durability[i] > 0) { // 로봇이 있고 그 다음칸에 로봇이 없고 내구성도 0보다 크면 이동가능
                    robot[i] = true; // 로봇을 옮겨주고
                    robot[i - 1] = false;
                    durability[i]--; // 내구성 감소시키기
                }
            }
			
			// 세 번째 단계 : 로봇 올리기
			if(durability[0] > 0) { // 올리는 위치의 내구성이 0보다 크면
				robot[0] = true; // 로봇 올리고
				durability[0]--; // 내구성 감소
			}
			
			step++; // 한 사이클 끝났으므로 카운팅
		}
		
	}
}