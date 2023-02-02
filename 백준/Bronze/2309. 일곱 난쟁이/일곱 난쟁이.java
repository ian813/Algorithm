import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Integer> tallList = new ArrayList<>();
		
		// 9명의 합을 담을 변수
		int tmpSum = 0;
		
		// 입력값 받기
		for(int idx = 0; idx < 9; idx++) {
			int tall = sc.nextInt();
			tallList.add(tall);
			tmpSum += tall;
		}
		
		// 오름차순 정렬
		Collections.sort(tallList);
		
		// 7명의 합을 담을 변수
		int sum = 0;
		
		for(int i = 0; i < tallList.size(); i++) {
			for(int j = i+1; j < tallList.size(); j++) {
        		
				// tmpSum - (배열에서 뽑은 두 값)
        		sum = tmpSum - (tallList.get(i) + tallList.get(j));
            	
        		// sum이 100인지 판단
        		if (sum == 100) {
        			
            		for(int idx = 0; idx < tallList.size(); idx++) {
            			
            			// sum이 100일 때의 i, j를 뺀 idx에 해당하는 값을 출력
            			if(idx != i && idx != j) {
            				System.out.println(tallList.get(idx));
           				}
            		}
        		}
        		if (sum == 100) {
        			break;
        		}
			}
			if (sum == 100) {
				break;
			}
		}
	}
}