import java.util.Scanner;

public class Main {
	static int testCase, nodeNum, nodeA, nodeB; // 테케, 노드 개수, 공통부모를 구할 두 노드
	static int[] parent; // 부모 노드
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StringBuilder sb = new StringBuilder();
		
		testCase = sc.nextInt();
		
		for(int tc = 1; tc <= testCase; tc++) {
			nodeNum = sc.nextInt();
			
			parent = new int[nodeNum+1];
			
			for(int i = 1; i < nodeNum; i++) {
				int p = sc.nextInt(); // 부모
				int c = sc.nextInt(); // 자식
				
				parent[c] = p; // 부모 자식 관계
			}
			
			// 부모를 구할 두 노드
			nodeA = sc.nextInt();
			nodeB = sc.nextInt();
			
			boolean[] isParent = new boolean[nodeNum+1];
			
            while (nodeA != 0) { // 현재 노드가 0이 아니면 부모가 존재한다는 뜻 (왜냐하면 계속 부모를 찾아서 업데이트 시켜주는데 부모가 없으면 0이 되므로)
                isParent[nodeA] = true; // 부모를 찾아주는 표시
                nodeA = parent[nodeA]; // 부모 업데이트 (부모가 없을 때까지 계속 찾자)
            }

            while (true) {
                if (isParent[nodeB]) { // 노드B입장에서 노드A가 부모를 찾아주는 루트에 진입 했는지 확인
                    sb.append(nodeB).append("\n"); // 진입했으면 공통조상을 찾아줬으므로 스트링빌더에 담고
                    break; // 와일문 멈추기
                }

                nodeB = parent[nodeB]; // 진입 못했으면 노드B도 부모를 계속 찾아가보자.
            }
			
		}
		
		sc.close();
		
		// 스트링빌더 출력
		System.out.println(sb);
	}
	
	
}
