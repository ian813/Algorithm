import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int L, C, consonant, vowel; // 암호길이, 암호에 들어갈 수 있는 알파벳 개수, 자음 개수, 모음 개수
	static char[] alphabet, result; // 후보 알파벳 저장할 배열, 뽑은 알파벳 저장할 배열
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		alphabet = new char[C];
		result = new char[L];
		
		st = new StringTokenizer(br.readLine().trim());
		for(int i = 0; i < C; i++) {
			alphabet[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(alphabet); // 알파벳 순 정렬
		
		// 조합 실행
		comb(0, 0);
		
		System.out.println(sb);
	}
	
	static void comb(int idx, int sIdx) {
		if(sIdx == L) {
			// 암호 후보가 될 수 있는지 판단할 불리안
			boolean check = false;
			// 모음개수 초기화
			vowel = 0;
			for(int i = 0; i < L; i++) {
				if(result[i] == 'a' || result[i] == 'e' || result[i] == 'i' || result[i] == 'o' || result[i] == 'u') {
					vowel++; // 모음 개수 카운팅
				}
			}
			consonant = L - vowel; // 자음 개수 구하기
			if(vowel >= 1 && consonant >= 2) {
				check = true; // 암호 후보가 될 수 있으면 체크
			}
			if(check) {
				// 암호 후보가 되면 스트링빌더에 담아주고 리턴
				for(int i = 0; i < L; i++) {
					sb.append(result[i]);
				}				
				sb.append("\n");
				return;
			}
			// 암호 후보가 안되면 그냥 리턴
			return;
		}
		
		if(idx >= C) return; // 배열 범위 넘어가면 리턴
		
		result[sIdx] = alphabet[idx]; // 선택된 인덱스에 알파벳 저장
		comb(idx+1, sIdx+1); // 현재 값 포함하고 다음으로 넘기기
		comb(idx+1, sIdx); // 현재 값 포함 안하고 다음으로 넘기기
	}
}