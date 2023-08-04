import java.util.Scanner;

public class Solution {
	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();
	static int testCase = sc.nextInt();
	// 고객수
	static int customer;
	// 회사와 집 좌표
	static int[][] company;
	static int[][] house;
	// 고객의 집 좌표
	static int[][] point;
	// 거리 합
	static int sum;
	// 들릴 고객의 집 위치
	static int[][] visit;
	// 방문 여부 체크
	static boolean[] check;
	
	static void input() {
		customer = sc.nextInt();
		
		company = new int[1][2];
		house = new int[1][2];
		point = new int[customer][2];
		
		// 회사 위치
		for(int idx = 0; idx < 2; idx++) {
			company[0][idx] = sc.nextInt();
		}
		
		// 집 위치
		for(int idx = 0; idx < 2; idx++) {
			house[0][idx] = sc.nextInt();
		}
		
		// 고객 집 위치
		for(int row = 0; row < point.length; row++) {
			for(int col = 0; col < point[0].length; col++) {
				point[row][col]	= sc.nextInt();
			}
		}
		visit = new int[customer][2];
		check = new boolean[customer];
	}
	
	static void search(int n, int k, int idx) {
		if(n == k) {
			// 임시 최솟값
			int tmpSum = 0;
			// 거리 합 구하기
			tmpSum += distance(company[0][0], visit[0][0], company[0][1], visit[0][1]);
			for(int i = 0; i < customer-1; i++) {
				tmpSum += distance(visit[i][0], visit[i+1][0], visit[i][1], visit[i+1][1]);
			}
			tmpSum += distance(visit[customer-1][0], house[0][0], visit[customer-1][1], house[0][1]);
			// 최솟값 갱신
			sum = Math.min(tmpSum, sum);
			return;
		}
		
		for(int i = 0; i < customer; i++) {
			// 방문 체크
			if(check[i]) continue;
			// 방문 안 한 집이면 방문하자.
			visit[idx][0] = point[i][0];
			visit[idx][1] = point[i][1];
			check[i] = true; // 방문 체크
			search(customer, k+1 ,idx+1); // 재귀 호출
			check[i] = false; // 방문 해제
			
		}
		
	}
	
	static int distance(int x1, int x2, int y1, int y2) {
		int dist = Math.abs(x1-x2) + Math.abs(y1-y2);
		
		return dist;
	}
	
	public static void main(String[] args) {
		for(int tc = 1; tc <= testCase; tc++) {
			input();
			sum = Integer.MAX_VALUE;
			search(customer, 0, 0);
			sb.append("#"+tc+" "+sum+"\n");
		}
		System.out.println(sb);
	}
}