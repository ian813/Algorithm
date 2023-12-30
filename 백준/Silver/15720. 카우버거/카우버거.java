import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		StringBuilder sb = new StringBuilder();

		// 햄버거, 사이드, 음료수 개수
		int burgerNum = sc.nextInt();
		int sideNum = sc.nextInt();
		int drinkNum = sc.nextInt();

		// 각각의 가격 정보를 저장할 배열
		Integer[] burgers = new Integer[burgerNum];
		Integer[] sides = new Integer[sideNum];
		Integer[] drinks = new Integer[drinkNum];

		// 할인 전 가격
		int sum = 0;

		for (int i = 0; i < burgerNum; i++) {
			burgers[i] = sc.nextInt();
			sum += burgers[i];
		}

		for (int i = 0; i < sideNum; i++) {
			sides[i] = sc.nextInt();
			sum += sides[i];
		}

		for (int i = 0; i < drinkNum; i++) {
			drinks[i] = sc.nextInt();
			sum += drinks[i];
		}

		// 할인 전 가격 저장
		sb.append(sum).append("\n");

		// 각각 내림차순으로 정렬
		Arrays.sort(burgers, Collections.reverseOrder());
		Arrays.sort(sides, Collections.reverseOrder());
		Arrays.sort(drinks, Collections.reverseOrder());

		// 메뉴 중 최소 개수 구하기
		int min = Math.min(Math.min(burgerNum, sideNum), drinkNum);

		// 할인 후 가격
		int discountSum = 0;

		// 가장 작은 개수 기준으로 세트 만들기
		for (int i = 0; i < min; i++) {
			discountSum += burgers[i] + sides[i] + drinks[i];
		}

		// 0.9 곱해서 할인
		discountSum *= 0.9;

		// 남은 메뉴들 싹 다 더하기
		for (int i = min; i < burgerNum; i++) {
			discountSum += burgers[i];
		}
		for (int i = min; i < sideNum; i++) {
			discountSum += sides[i];
		}
		for (int i = min; i < drinkNum; i++) {
			discountSum += drinks[i];
		}

		// 할인 후 가격 저장
		sb.append(discountSum);

		// 출력
		System.out.println(sb);
	}
}