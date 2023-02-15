import java.util.Scanner;

public class Main {
	
	// input값 입력받기
	static int input;
	
	// 밑줄을 받을 문자열
	static String underLine = "";
	
	
	// input 메서드
	static void inputMethod() {
		Scanner sc = new Scanner(System.in);
		
		input = sc.nextInt();
		
		sc.close();
	}
	
	// 재귀함수 (재귀를 반복할 정수 n과 재귀 반복마다 추가되는 밑줄을 받을 underLine을 파라미터로 설정)
	static void recursion(int n, String underLine) {		
		
		// n이 0이 되면 return (재귀를 끝낼 조건)
		if(n == 0) {
			// 마지막에 재귀함수가 끝날 때 멘트
			System.out.println(underLine + "\"재귀함수가 뭔가요?\"");
			System.out.println(underLine + "\"재귀함수는 자기 자신을 호출하는 함수라네\"");
			System.out.println(underLine + "라고 답변하였지.");
			
			return;
		}
		
		// 반복될 때마다 출력
		System.out.println(underLine + "\"재귀함수가 뭔가요?\"");
		System.out.println(underLine + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
		System.out.println(underLine + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
		System.out.println(underLine + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");

		// 재귀함수 불러오기
		recursion(n-1, underLine + "____");
		
		// 밑에 반복될 멘트는 재귀함수 뒤로 빼주기
		System.out.println(underLine + "라고 답변하였지.");

	}
	
	
	
	public static void main(String[] args) {
		// 인풋메서드 실행
		inputMethod();
		
		// 재귀함수에 넣으면 여러 번 출력될텐데,,
		// 이건 한번밖에 출력이 안되어서 따로 빼서 출력해줌..
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		
		// 재귀함수 실행
		recursion(input, underLine);
	}
}