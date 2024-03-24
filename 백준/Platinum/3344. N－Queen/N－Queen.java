import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		if (N % 6 != 2 && N % 6 != 3) {
			for (int i = 1; i <= N; i += 2) {
				sb.append(i).append("\n");
			}

			for (int i = 2; i <= N; i += 2) {
				sb.append(i).append("\n");
			}

		} else if (N % 6 == 2) {
			for (int i = 2; i <= N; i += 2) {
				sb.append(i).append("\n");
			}

			sb.append(3).append("\n");
			sb.append(1).append("\n");
			for (int i = 7; i <= N; i += 2) {
				sb.append(i).append("\n");
			}
			sb.append(5).append("\n");

		} else {
			for (int i = 4; i <= N; i += 2) {
				sb.append(i).append("\n");
			}
			sb.append(2).append("\n");

			for (int i = 5; i <= N; i += 2) {
				sb.append(i).append("\n");
			}
			sb.append(1).append("\n");
			sb.append(3).append("\n");

		}

		System.out.println(sb);
	}
}