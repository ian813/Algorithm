import java.util.Scanner;

public class Main {
	static String subject;
	static double[] credit;
	static String[] grade;

	static double creditSum;
	static double gradeSum;
	static double result;
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		// 입력이 20줄에 걸쳐서 주어지므로
		// 크기 20으로 배열 생성
		credit = new double[20];
		grade = new String[20];

		for (int re = 0; re < 20; re++) {
			// 과목명
			subject = sc.next();

			// 학점과 등급 입력받기
			credit[re] = sc.nextDouble();
			grade[re] = sc.next();
		}

		creditSum = 0;
		gradeSum = 0;
	}

	static void calculate() {
		input();

		for (int idx = 0; idx < 20; idx++) {
			if (!grade[idx].equals("P")) {
				// 등급이 P일 때 제외한 모든 학점 더해주기
				creditSum += credit[idx];
			}
			// 등급에 맞게 합 계산
			switch (grade[idx]) {
				case "A+":
					gradeSum += 4.5 * credit[idx];
					break;
				case "A0":
					gradeSum += 4.0 * credit[idx];
					break;
				case "B+":
					gradeSum += 3.5 * credit[idx];
					break;
				case "B0":
					gradeSum += 3.0 * credit[idx];
					break;
				case "C+":
					gradeSum += 2.5 * credit[idx];
					break;
				case "C0":
					gradeSum += 2.0 * credit[idx];
					break;
				case "D+":
					gradeSum += 1.5 * credit[idx];
					break;
				case "D0":
					gradeSum += 1.0 * credit[idx];
					break;
				case "F":
					break;
			}
		}
		// 학점 계산
		result = gradeSum/creditSum;
	}
	public static void main(String[] args) {
		calculate();
		// 소수점 6째자리까지만 출력
		System.out.printf("%.6f", result);
	}
}