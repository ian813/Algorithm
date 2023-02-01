import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	 
    	Scanner sc= new Scanner(System.in);
    
    	// 모자 번호 담을 배열
    	int[] hatNum = new int[9];
    	
    	// 배열에 값 입력
    	for(int idx = 0; idx < hatNum.length; idx++) {
    		hatNum[idx] = sc.nextInt();
    	}
    	
    	// 임시 합 구하기 (배열에 있는 숫자 모두 더하기)
    	// 왜냐하면 배열에서 7개 뽑아서 더해주는 for문은 7중 for문 써야할 듯...?
    	// 여사건 구하듯이 전부 더한 합에서 2개의 숫자만 빼주자 -> 2중 for문으로 해결
    	int tmpSum = 0;
    	
    	for(int idx = 0; idx < hatNum.length; idx++) {
    		tmpSum += hatNum[idx];
    	}
    	
    	// 구하려는 합 (sum이 100인지 아닌지 확인)
    	int sum = 0;
    	
    	for(int i = 0; i < hatNum.length; i++) {
    		
        	for(int j = i+1; j < hatNum.length; j++) {
        		// tmpSum - 배열에서 뽑은 두 값
        		sum = tmpSum - (hatNum[i] + hatNum[j]);
            	
        		// sum이 100인지 판단
        		if (sum == 100) {
        			
            		for(int idx = 0; idx < hatNum.length; idx++) {
            			
            			// sum이 100일 때의 i, j를 뺀 idx에 해당하는 값을 출력
            			if(idx != i && idx != j) {
            				System.out.println(hatNum[idx]);
           				}
           			}
            		
            		// 출력이 끝난 뒤 break 걸기
           			if (sum == 100) {
           				break;
            		}
            	}
        	}
        	// break로 for문 빠져나오기
        	if (sum == 100) {
   				break;
    		}
    	}
    }
}