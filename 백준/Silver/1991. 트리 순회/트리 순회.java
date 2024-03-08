import java.io.IOException;
import java.util.Scanner;

// 노드 클래스
class Node {
	char value;
	Node left;
	Node right;

	public Node(char value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
}

public class Main {

	private static StringBuilder sb = new StringBuilder();

	private static Node[] tree; // 트리

	// 전위 순회
	private static void preorder(Node node) {
		if (node == null) { // 순회할 곳에 노드가 없으면 리턴
			return;
		}
		// 루트 -> 왼쪽 -> 오른쪽 순
		sb.append(node.value);// 현재값 저장
		preorder(node.left); // 왼쪽 자식으로 이동
		preorder(node.right); // 오른쪽 자식으로 이동
	}

	// 중위 순회
	private static void inorder(Node node) {
		if (node == null) {
			return;
		}
		// 왼쪽 -> 루트 -> 오른쪽 순
		inorder(node.left);
		sb.append(node.value);
		inorder(node.right);
	}

	// 후위 순회
	private static void postorder(Node node) {
		if (node == null) {
			return;
		}

		// 왼쪽 -> 오른쪽 -> 루트 순
		postorder(node.left);
		postorder(node.right);
		sb.append(node.value);
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int nodeNum = sc.nextInt();

		tree = new Node[nodeNum];

		for (int i = 0; i < nodeNum; i++) {
			// 부모와 왼쪽 오른쪽 자식 입력받기
			char root = sc.next().charAt(0);
			char left = sc.next().charAt(0);
			char right = sc.next().charAt(0);

			if (tree[root - 'A'] == null) { // 부모 노드가 아직 생성되지 않은 경우. 'A'는 문자 'A'의 ASCII 값
				tree[root - 'A'] = new Node(root); // 부모 노드를 생성
			}
			if (left != '.') { // 왼쪽 자식이 존재할 경우
				tree[left - 'A'] = new Node(left); // 왼쪽 자식 노드를 생성
				tree[root - 'A'].left = tree[left - 'A']; // 부모 노드와 연결
			}
			if (right != '.') { // 오른쪽 자식이 존재할 경우
				tree[right - 'A'] = new Node(right); // 오른쪽 자식 노드를 생성
				tree[root - 'A'].right = tree[right - 'A']; // 부모 노드와 연결
			}

		}
		// 전위 순회
		preorder(tree[0]);
		sb.append("\n");

		// 중위 순회
		inorder(tree[0]);
		sb.append("\n");

		// 후위 순회
		postorder(tree[0]);
		sb.append("\n");

		// 출력
		System.out.println(sb);
	}
}