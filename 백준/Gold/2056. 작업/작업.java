import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int workNum;
	static int[] inDegree, workTime, result; // 진입차수, 작업시간, 누적 작업시간
	static List<Integer>[] adjList; // 인접행렬

	static void input() {
		Scanner sc = new Scanner(System.in);

		workNum = sc.nextInt();

		inDegree = new int[workNum + 1];
		workTime = new int[workNum + 1];
		result = new int[workNum + 1];
		
		adjList = new ArrayList[workNum + 1];

		for (int idx = 1; idx <= workNum; idx++) {
			// 인접 정보를 담을 바구니
			adjList[idx] = new ArrayList<>();
		}

		for (int idx = 1; idx <= workNum; idx++) {
			// 각 작업에 걸리는 시간 저장
			workTime[idx] = sc.nextInt();
			// result 배열에도 똑같이 저장
			result[idx] = workTime[idx];
			// 선행작업 개수 입력받기
			int precede = sc.nextInt();
			for (int i = 0; i < precede; i++) {
				int temp = sc.nextInt(); // 선행작업 번호
				adjList[temp].add(idx); // 인접 정보 저장
				inDegree[idx]++; // 진입차수 카운팅
			}
		}

		sc.close();
	}

	static void topologicalSort() {
		Queue<Integer> queue = new LinkedList<>();

		// 진입차수 0인거 전부 큐에 넣어주기
		for (int idx = 1; idx <= workNum; idx++) {
			if (inDegree[idx] == 0) {
				queue.add(idx);
			}
		}

		while (!queue.isEmpty()) { // 큐가 빌때까지 실행
			int work = queue.poll();
			
			// 현재 작업의 후행작업들을 뽑아서 진입차수 감소시켜주고
			for (int i = 0; i < adjList[work].size(); i++) {
				inDegree[adjList[work].get(i)]--;
				
				// 지금 작업까지 걸린 시간 + 다음 작업에 걸리는 시간과 다음 작업의 기존 걸리는 시간 중 최댓값을 저장 -> 최소시간
				result[adjList[work].get(i)] = Math.max(result[adjList[work].get(i)], result[work] + workTime[adjList[work].get(i)]);
				
				// 0이되면 큐에 추가
				if (inDegree[adjList[work].get(i)] == 0) {
					queue.add(adjList[work].get(i));
				}

			}
		}
	}
	
	// 최댓값 찾아주기
	static int findMax() {
		int max = 0;
		for(int i = 1; i <= workNum; i++) {
			max = Math.max(max, result[i]);
		}
		
		return max;
	}

	public static void main(String[] args) {
		input();
		topologicalSort();
		System.out.println(findMax());
	}
}
