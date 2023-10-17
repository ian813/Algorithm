import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	private static class Person implements Comparable<Person> {
		String name;
		int day, month, year;

		private Person(String name, int day, int month, int year) {
			this.name = name;
			this.day = day;
			this.month = month;
			this.year = year;
		}

		@Override
		public int compareTo(Person o) {
			// 연 월 일의 숫자가 크면 나이가 어리므로
			// 새로 들어온 연 월 일이 크면 바꿔줘야한다.
			if (o.year > this.year) {
				return 1;
			} else if (o.year < this.year) {
				return -1;
			} else {
				if (o.month > this.month) {
					return 1;
				} else if (o.month < this.month) {
					return -1;
				} else {
					if (o.day > this.day) {
						return 1;
					} else {
						return -1;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ArrayList<Person> people = new ArrayList<>();

		int n = sc.nextInt();

		// 사람 정보 입력받기
		while (n-- > 0) {
			Person p = new Person(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt());

			people.add(p);
		}

		// 나이순 정렬
		Collections.sort(people);

		// 나이 어린 사람 많은 사람의 이름을 순서대로 출력
		// n은 이미 감소시켰으니까 size로 뽑아준다.
		System.out.println(people.get(0).name);
		System.out.println(people.get(people.size() - 1).name);
	}
}