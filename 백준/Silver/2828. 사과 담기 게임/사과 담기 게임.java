import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int apple = sc.nextInt();
		
		int left = 1;  //바구니 왼쪽 좌표
		int right = M;  //바구니 오른쪽 좌표
		int sum = 0;  //이동 거리
		
		for(int i = 0; i < apple; i++) {
			int place = sc.nextInt();
			
			//바구니 안에 떨어지는 경우
			if(left <= place && place <= right) {
				continue;
			}
			
			//바구니 왼쪽에 가깝게 떨어지는 경우
			if(left > place) {
				sum += (left - place); // 움직일 거리 구해주고 (왼쪽에 가깝게)
				right -= (left - place); // 오른쪽 좌표 갱신
				left = place; // 왼쪽 좌표 갱신
			}
			
			//바구니 오른쪽에 가깝게 떨어지는 경우
			else{
				sum += (place - right); // 움직일 거리 구해주고 (오른쪽에 가깝게)
				left += (place - right); // 왼쪽 좌표 갱신
				right = place; // 오른쪽 좌표 갱신
			}
		}
		sc.close();
		
		System.out.println(sum);		
	}
}