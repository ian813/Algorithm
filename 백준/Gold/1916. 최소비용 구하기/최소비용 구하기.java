import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.sun.java_cup.internal.runtime.virtual_parse_stack;

public class Main {
	static int N, M, stPoint, endPont; // 도시 개수, 버스 개수
	static final int INF = Integer.MAX_VALUE; // 정수 최댓값
	static List<Node>[] adjList; // 인접 리스트
	static int[] price; // 비용을 나타낼 배열
	
	// 노드 클래스
	static class Node {
		int v, w;
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		price = new int[N+1];
		// 가격에 최댓값 대입
		Arrays.fill(price, INF);
		// 인접리스트 생성
		adjList = new ArrayList[N+1];
		// 인덱스마다 어레이리스트 생성
		for(int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		// 인접리스트에 끝점과 가중치 정보 담아주기
		for(int i = 0; i < M; i++) {
			int st = sc.nextInt();
			int end = sc.nextInt();
			int weight = sc.nextInt();
			
			adjList[st].add(new Node(end, weight));
		}
		// 시작점과 끝점 입력받기
		stPoint = sc.nextInt();
		endPont = sc.nextInt();
		
		sc.close();
	}
	
	static void dijkstra(int start) {
		// 방문 체크 배열
		boolean[] visited = new boolean[N+1];
		// 시작점 비용은 0으로 초기화
		price[start] = 0;
		
		for(int i = 0; i < N-1; i++) {
			int min = INF;
			int idx = -1;
			
			// 선택하지 않은 정점 중 최소비용인 것을 고르기
			for(int j = 1; j <= N; j++) {
				if(!visited[j] && min > price[j]) {
					min = price[j];
					idx = j;
				}
			}
			
			if(idx == -1) break; // 선택을 못했으면 중단
			
			visited[idx] = true; // 방문 체크
			
			for(int j = 0; j < adjList[idx].size(); j++) {
				Node curr = adjList[idx].get(j);
				
				// 방문 안했고, 연결되어 있을 때
				// 이미 가진 비용보다 더 최소 비용이라면 갱신
				if(!visited[curr.v] && price[curr.v] > price[idx] + curr.w) {
					price[curr.v] = price[idx] + curr.w;
				}
				
//				if(curr.v == endPont) break; // 끝점에 도달했으면 중단
			}
		}
	}
	
	public static void main(String[] args) {
		input();
		dijkstra(stPoint);
		System.out.println(price[endPont]);
	}
}
