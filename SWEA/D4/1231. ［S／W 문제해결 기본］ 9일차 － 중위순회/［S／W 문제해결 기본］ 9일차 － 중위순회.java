import java.util.Scanner;

public class Solution {
	static int testCase;
	static char[] tree;
	static int nodeNum;
	static StringBuilder ans;
	
	// 중위순회를 위한 함수 구현
	private static void traverse(int i) { // i번째 노드의 순회
		
		if( i <= tree.length-1 ) {
			// 중위 순회
			
			// L: 왼쪽 트리로 탐색을 이어나감
			traverse(i*2);
			
			// V: 자기 자신을 방문처리
			if(tree[i] != '\u0000') {
				// 자기 자신을 방문할 때 데이터 뽑아주기
				ans.append(tree[i]);
			}

			// R: 오른쪽으로 탐색을 이어나감
			traverse(i*2+1);
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		
		for(int tc = 1; tc <= 10; tc++) {
			ans = new StringBuilder();
			
			nodeNum = sc.nextInt();
			
			// nodeNum까지 인덱스로 사용하기 위해,,
			tree = new char[nodeNum + 1];
			
			for(int idx = 1; idx < tree.length; idx++) {
				int node = sc.nextInt();
				tree[node] = sc.next().charAt(0);
				
				if(nodeNum % 2 == 0) {
					if(idx < nodeNum/2) {
						int left = sc.nextInt();
						int right = sc.nextInt();
					} else if (idx == nodeNum/2) {
						int child = sc.nextInt();
					}
				} else if(nodeNum % 2 == 1) {
					if(idx <= nodeNum/2) {
						int left = sc.nextInt();
						int right = sc.nextInt();
					}
				}
				
				
			}
			// 함수 실행
			traverse(1);
			
			// 형식에 맞게 출력
			System.out.printf("#%d %s\n", tc, ans);
		}
	}
}