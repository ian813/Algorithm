import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력받을 숫자 개수, 타깃 인덱스 (-1해서 인덱스 맞추기)
        int num = Integer.parseInt(st.nextToken());
        int targetIdx = Integer.parseInt(st.nextToken()) - 1;

        // 숫자 데이터 받을 배열
        int[] numArr = new int[num];

        st = new StringTokenizer(br.readLine());

        // 데이터 입력받기
        for (int i = 0; i < num; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        // 오름차순 정렬
        Arrays.sort(numArr);

        System.out.println(numArr[targetIdx]);
    }
}