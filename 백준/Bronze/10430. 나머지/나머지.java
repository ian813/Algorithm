import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();

		StringBuilder sb = new StringBuilder();

		int ans1 = (A + B) % C;
		sb.append(ans1).append("\n");

		int ans2 = ((A % C) + (B % C)) % C;
		sb.append(ans2).append("\n");

		int ans3 = (A * B) % C;
		sb.append(ans3).append("\n");

		int ans4 = ((A % C) * (B % C)) % C;
		sb.append(ans4).append("\n");

		System.out.println(sb);
	}
}