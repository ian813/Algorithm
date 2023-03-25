
import java.util.Scanner;

public class Main {
	
	static int ans;
	
	static void solve() {
		Scanner sc = new Scanner(System.in);
		// 문자열 입력받기
		String expression = sc.next();
		
		sc.close();
		// - 기준으로 쪼개주자
		String[] minus = expression.split("-");
		// 똑같은 크기의 정수 배열 생성 (나중에 최종 숫자로 받아서 그 숫자들끼리 빼줄거임)
		int[] numArr = new int[minus.length];
		
		for(int idx = 0; idx < minus.length; idx++) {
			if(minus[idx].contains("+")) { // + 가 포함된 문자열이면
				String[] tmp = minus[idx].split("\\+"); // + 기준으로 쪼개서 임시 배열에 담아주고
				for(int i = 0; i < tmp.length; i++) {
					numArr[idx] += Integer.parseInt(tmp[i]); // 그 배열에 담긴 값들을 모두 정수로 바꿔서 더해주고 같은 인덱스의 numArr에 넣어준다.
				}
			} else {
				numArr[idx] = Integer.parseInt(minus[idx]); // + 없는거면 숫자만 있으므로 그냥 같은 인덱스의 numArr에 넣어준다.
			}
		}
		// 제일 첫 번째 값을 저장해주고
		ans = numArr[0];
		
		for(int idx = 1; idx < numArr.length; idx++) {
			// 그 수에서 계속 빼주면서 계산
			ans -= numArr[idx];
		}
		
	}
	
	public static void main(String[] args) {
		solve();
		// 출력
		System.out.println(ans);
	}
}
