import java.util.Scanner;

public class Solution {
	static int testCase;

	// 서브트리 크기
	static int subTreeSize;
	
	// 공통조상 노드
	static int commonAncestor = 0;
	
	// 공통조상을 임시로 저장할 변수
	static int tmpChild;
	
	// 정점의 개수
	static int V;

	// 간선의 개수
	static int E;
	
	// 간선을 찾으려는 두 정점 번호
	static int firstNode;
	static int secondNode;
	
	static int[] parentNode;
	static int[] childNode;

	
	static int findTreeSize(int node) {
		for(int idx = 0; idx < parentNode.length; idx++) {
			if(parentNode[idx] == node) {

				subTreeSize++;
				
				node = childNode[idx];
				
				findTreeSize(node);
				
				node = parentNode[idx];

			} 
		}
		
		return subTreeSize;

	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		testCase = sc.nextInt();

		for (int tc = 1; tc <= testCase; tc++) {
			// 정점의 개수
			V = sc.nextInt();

			// 간선의 개수
			E = sc.nextInt();

			// 간선을 찾으려는 두 정점 번호
			firstNode = sc.nextInt();
			secondNode = sc.nextInt();

			parentNode = new int[E];
			childNode = new int[E];

			for (int idx = 0; idx < E; idx++) {
				// 부모노드, 자식노드를 순서대로 저장
				parentNode[idx] = sc.nextInt();
				childNode[idx] = sc.nextInt();

			}
			
			// 첫번째, 두번째 노드를 저장할 임시 변수들
			int tmpFirstNode = firstNode;
			int tmpSecondNode = secondNode;

			// tmpSecondNode 루트 노드가 되기 전까지 반복
			while(tmpSecondNode != 1) {
				// tmpFirstNode를 매 시행마다 초기화
				tmpFirstNode = firstNode;
				
				while (tmpFirstNode != 1) {
					// tmpFirstNode가 1이 아니면
					if(tmpFirstNode == tmpSecondNode) {
						// tmpFirstNode와 tmpSecondNode가
						// 같으면 와일문 빠져나가고
						break;
					}
					// 아니면		
					for (int idx = E - 1; idx >= 0; idx--) {
						if (childNode[idx] == tmpFirstNode) {
							// childNode에서 tmpFirstNode와 같은지 찾아서 발견하면
							// 그 부모노드로 tmpFirstNode를 업데이트
							tmpFirstNode = parentNode[idx];
							// 찾으면 바로 break
							break;
						}
					}

				}
				
				// 와일문을 빠져나왔을 때 두 노드가 같으면
				// 와일문을 멈춰준다.
				if(tmpFirstNode == tmpSecondNode) {
					break;
				}
				
				// 두 노드가 다르면
				// 이번엔 세컨드노드의 부모노드를 찾아서 그걸로 업데이트
				for (int idx = E - 1; idx >= 0; idx--) {
					if (childNode[idx] == tmpSecondNode) {
						tmpSecondNode = parentNode[idx];
						break;
					}
				}
				
			}
			
			// 두 노드가 같을 때 와일문이 끝나므로,,
			// 공통조상을 업데이트 시켜주면 된다.
			commonAncestor = tmpSecondNode;
			
			// 서브트리 사이즈를 1로 초기화
			subTreeSize = 1;
			
			// tmpChild에 공통조상 노드 담아주기
			tmpChild = commonAncestor;
			
			// 메서드 실행
			findTreeSize(tmpChild);
			
			System.out.printf("#%d %d %d\n", tc, commonAncestor, subTreeSize);
		}

	}
}