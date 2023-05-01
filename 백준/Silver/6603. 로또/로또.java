import java.util.Scanner;

public class Main {
	static int size = -1;
	static int[] nums, result;
	static StringBuilder sb;
	
	static void comb(int idx, int sIdx) {
		if(sIdx == 6) { // 6개 뽑으면 결과배열에 저장된 숫자들을 스트링빌더에 저장해주자.
			for(int i = 0; i < 6; i++) {
				sb.append(result[i] + " ");
			}
			// 저장이 끝나면 한번 개행하고 리턴
			sb.append("\n");
			return;
		}
		if(idx >= size) return; // idx가 배열 범위를 넘어가면 리턴
		
		result[sIdx] = nums[idx]; // 현재 선택된 인덱스에 값을 넣어주고
		comb(idx+1, sIdx+1); // 현재 값을 저장하고 넘어가기
		comb(idx+1, sIdx); // 현재 값 저장 안하고 넘어가기
		
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		while(size != 0) { // 0이 나오면 멈추자.
			size = sc.nextInt(); // 숫자 표본 크기
			
			sb = new StringBuilder(); // 결과를 저장할 스트링빌더 (매 시행마다 다시 생성해서 초기화)
			
			nums = new int[size]; // 숫자 표본을 담을 배열
			
			for(int i = 0; i < size; i++) { // 배열 돌면서 입력받기
				nums[i] = sc.nextInt();
			}
			
			result = new int[6]; // 결과를 저장할 배열
			
			comb(0, 0); // 조합으로 찾자!
			
			System.out.println(sb); // 조합으로 다 찾으면 스트링빌더 출력
		}
		
		sc.close();
	}
}
