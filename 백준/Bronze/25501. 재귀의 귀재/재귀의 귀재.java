import java.util.Scanner;

public class Main {
	
	// testCase 변수 생성
	static int testCase;
	
	// 받을 문자열 변수
	static String s;
	
	// 재귀함수 개수 셀 변수
	static int numRecursion;
	
	// input메서드(입력받고 출력까지 해버리기..)
	static void input() {
		
		Scanner sc = new Scanner(System.in);
		
		// testCase 변수 입력받기
		testCase = sc.nextInt();
		
		// testCase만큼 반복!
		for(int tc = 0; tc < testCase; tc++) {
			
			// 문자열 입력받기
			s = sc.next();

			// 재귀함수를 처음 호출할 때부터
			// 세줘야하므로 1로 시작!
			numRecursion = 1;
			
			// isPalindrome함수를 이용해 재귀를 거친 뒤 형식에 맞게 출력
			System.out.println(isPalindrome(s) + " " + numRecursion);
			
			
		}
		
		sc.close();
		
	}
	
	// 재귀함수 (palindrome인지 실질적으로 판단해준다.)
	// 문자열과 양 끝 인덱스를 파라미터로 받아주자.
	public static int recursion(String s, int l, int r){
        // 0에서 출발한 l이 반대쪽에서 출발한 r보다 크거나 같아지면
		// else if문에 걸리지 않고 else문에 따라 쭉 와서 중간 지점에서 교차되었다는 뜻,,,
		// 즉, 교차할 때까지 s.charAt(l) == s.charAt(r)이었다는 뜻,,,
		// 따라서 palindrome이라고 판단할 수 있다.
		// 따라서 1 return
		if(l >= r) {
        	return 1;
        }
		// 0에서 출발한 l과 반대쪽에서 출발한 r일 떄의 문자를 비교해서
		// 다르면 palindrome이 아니므로 0 return하고 함수 종료!
        else if(s.charAt(l) != s.charAt(r)) {
        	return 0;
        }
		// 0에서 출발한 l과 반대쪽에서 출발한 r일 떄의 문자를 비교해서
		// 같으면 다음 인덱스를 비교해줘야 하므로
		// recursion함수를 다시 호출
		// 이 때 대입 값을 l은 +1, r은 -1해준다.
		// 이때 recursion을 다시 호출하는 것이므로 numRecursion도 더해준다.
        else {
        	numRecursion++;
        	return recursion(s, l+1, r-1);
        }
    }
	
	// 문자열이 Palindrome인지 확인하기 위해 문자열 s를 입력받아서
	// recursion 함수를 호출해준다.
    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }
    
    public static void main(String[] args){
    	// input만 호출하면 바로 해결이 되버리네...
    	input();
    }
	
}