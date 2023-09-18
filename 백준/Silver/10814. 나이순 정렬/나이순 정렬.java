import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    // 사람 클래스
    static class Person {
        int age;
        String name;

        Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return age + " " + name + "\n";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        // 사람 객체를 담을 배열
        Person[] people = new Person[N];

        // 사람의 나이와 이름 입력받기
        for (int i = 0; i < N; i++) {
            people[i] = new Person(sc.nextInt(), sc.next());
        }

        sc.close();

        Arrays.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.age - o2.age;
            }
        });

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            // 객체배열의 객체를 출력하면 해당 인덱스의 객체의 toString() 이 출력 됨
            sb.append(people[i]);
        }

//        for (int i = 0; i < N; i++) {
//            sb.append(people[i].age).append(" ").append(people[i].name).append("\n");
//        }
        System.out.println(sb);
    }
}