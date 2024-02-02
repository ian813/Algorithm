import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int people = sc.nextInt();

		// 창문번호의 약수의 개수가 홀수개일 때만 열려있을 수 있다.
		// 약수의 개수가 홀수개이려면 결국 어떤 수의 제곱수일 수밖에 없다.
		// 따라서 맨 끝 창문 번호의 제곱급보다 작은 자연수의 개수가 곧
		// 창문 번호보다 작은 제곱수의 개수가 된다.
		int ans = (int)Math.floor(Math.sqrt(people));

		System.out.println(ans);
	}
}