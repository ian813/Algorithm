import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 기타 개수

        String[] arr = new String[N]; // 문자열 담을 배열

        // 문자열 입력받기
        for (int i = 0; i < N; i++) {
            arr[i] = sc.next();
        }

        sc.close();
        
        // 정렬을 comparator를 새로 정의해서 해보자
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) { // 문자열 2개 비교
                if (o1.length() == o2.length()) { // 문자열 길이가 같으면
                    int sum1 = 0;
                    int sum2 = 0;
                    // o1 문자열에서 숫자만 뽑아서 합을 구하고
                    for (int i = 0; i < o1.length(); i++) {
                        if (o1.charAt(i) <= '9' && o1.charAt(i) >= '0') {
                            sum1 += Integer.parseInt(String.valueOf(o1.charAt(i)));
                        }
                    }
                    // o2 문자열에서 숫자만 뽑아서 합을 구하고
                    for (int i = 0; i < o2.length(); i++) {
                        if (o2.charAt(i) <= '9' && o2.charAt(i) >= '0') {
                            sum2 += Integer.parseInt(String.valueOf(o2.charAt(i)));
                        }
                    }
                    
                    if (sum1 == sum2) { // 합이 같으면 사전순으로 정렬
                    	return o1.compareTo(o2);                    	
                    } else { // 합이 다르면 합이 작은 순으로 배열
                    	return sum1 - sum2;                    	
                    }
                } else {
                	// 문자열 길이가 다르면 문자열 길이 순으로 배열
                    return o1.length() - o2.length();
                }
            }
        });
        
        // 정렬이 끝났으면 순서대로 출력
        for (int i = 0; i < N; i++) {
            System.out.println(arr[i]);
        }
    }
}