import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// N, F를  받아줌.
		int N = sc.nextInt();
		int F = sc.nextInt();
		
		// N의 맨 뒷자리를 00으로 바꿔줌. (N/100) = N을 100으로 나눴을 때 몫이므로...
		int newN = (N/100) * 100;
		
		// i를 0부터 100까지 newN에 더해주면서 F로 나눴을 때 나머지가 0일 때 i 출력
		// 단 i가 0~9일 때 앞에 0을 붙여서 출력
		for(int i = 0; i < 100; i++) {
			int newNumber = newN + i;
			if(newNumber % F == 0) {
				if(i < 10) {
					System.out.println("0" + i);
					break;
				}
				else {
					System.out.println(i);
					break;
				}
			}
			
		}
	}
}