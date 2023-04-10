import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		// 값이 크므로 biginteger 사용
		// 값은 1로 일단 생성해준다.
		BigInteger numerator = BigInteger.ONE;
        BigInteger denominator = BigInteger.ONE;
		
		for(int i = 0; i < m; i++) {
			// 분자, 분모 값을 구해보자.
			// 분자는 n*(n-1)* ... *(n-m+1) = n!/(n-m)!
			// 분모는 1*2* ... * m = m!
			numerator = numerator.multiply(new BigInteger(String.valueOf(n - i)));
			denominator = denominator.multiply(new BigInteger(String.valueOf(i+1)));
		}
		// 구한 값을 나눠준 뒤 출력
		BigInteger comb = numerator.divide(denominator);
		System.out.println(comb);
	}
}