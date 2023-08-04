import java.util.Scanner;

public class Solution {
	static int[] numArr;
	static int[] sorted;
	static void input() {
		Scanner sc = new Scanner(System.in);
		
		numArr = new int[1000000];
		
		for(int idx = 0; idx < 1000000; idx++) {
			numArr[idx] = sc.nextInt();
		}
		
		sorted = new int[1000000];
		
		sc.close();
	}
	
	static void mergeSort(int left, int right) {
		if(left < right) {
			int mid = (left+right)/2;
			
			mergeSort(left, mid);
			mergeSort(mid+1, right);
			
			merge(left, mid , right);
			
		}
	}
	
	static void merge(int left, int mid, int right) {
		int L = left;
		int R = mid+1;
		int idx = left;
		
		while(L <= mid && R <= right) {
			if(numArr[L] <= numArr[R]) {
				sorted[idx++] = numArr[L++];
			} else {
				sorted[idx++] = numArr[R++];
			}
			
		}
		if(L <= mid) {
			for(int i = L; i <= mid; i++)  {
				sorted[idx++] = numArr[i];
			}
		} else {
			for(int i = R; i <= right; i++)  {
				sorted[idx++] = numArr[i];
			}
		}
		
		for(int i = left; i <= right; i++) {
			numArr[i] = sorted[i];
		}
		
	}
	
	public static void main(String[] args) {
		input();
		mergeSort(0, numArr.length-1);
		
		System.out.println(numArr[500000]);
	}
}