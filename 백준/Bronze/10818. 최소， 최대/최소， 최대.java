import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int max = arr[0];
		int min = arr[0];
		
		for(int idx = 0; idx < N; idx++) {
			if(max < arr[idx]) {
				max = arr[idx];
			}
		}
		
		for(int idx = 0; idx < N; idx++) {
			if(min > arr[idx]) {
				min = arr[idx];
			}
		}
		
		System.out.println(min + " " + max);
	}
}