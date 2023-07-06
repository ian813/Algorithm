import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		String[] arr = new String[N];
		
		for(int i = 0; i < N; i++) {
			String str = sc.next();
			
			arr[i] = str;
		}
		
		sc.close();

		Arrays.sort(arr, new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {
				if(o1.length() == o2.length()) {
					return o1.compareTo(o2); // 사전 순 정렬
				} else {
					// 양수일 경우 자리를 바꾼다. (앞에 나온 길이가 뒤에 나온 길이보다 크면 자리를 바꾼다. -> 오름차순 정렬)
					return o1.length() - o2.length(); // 길이 순 오름차순 정렬
				}
			}
		});
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(arr[0] + "\n");
		
		for(int i = 1; i < N; i++) {
			// 중복되지 않은 단어만 출력하기
			if(!arr[i].equals(arr[i-1])) {
				sb.append(arr[i] + "\n");				
			}
		}
		
		System.out.println(sb);
	}
}