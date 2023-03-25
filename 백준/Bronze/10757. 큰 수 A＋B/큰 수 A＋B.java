import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// biginteger 메서드 임포트해서 사용
		// 문자열로 받아줘야 한다.
		BigInteger A = new BigInteger(sc.next());
		BigInteger B = new BigInteger(sc.next());
		
		// A.add(B) => A+B
		System.out.println(A.add(B));
	}
}
