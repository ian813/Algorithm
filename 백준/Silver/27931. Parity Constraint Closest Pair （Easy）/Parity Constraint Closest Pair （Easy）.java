import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Integer> point;
    static int even;
    static int odd;

    static void solve() {
        even = Integer.MAX_VALUE;
        odd = Integer.MAX_VALUE;

        Collections.sort(point);

        for(int i = 0; i < N-1; i++) {
            boolean isEven = false;
            boolean isOdd = false;

            for(int j = i+1; j < N; j++) {
                int tmp = Math.abs(point.get(i) - point.get(j));

                if(!isEven && tmp % 2 == 0) {
                    isEven = true;
                    even = Math.min(tmp, even);
                } else if(!isOdd && tmp % 2 == 1){
                    isOdd = true;
                    odd = Math.min(tmp, odd);
                }

                if(isEven && isOdd) break;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        point = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());

            point.add(tmp);
        }

        solve();

        if(even == Integer.MAX_VALUE) even = -1;
        if(odd == Integer.MAX_VALUE) odd = -1;

        System.out.println(even + " " + odd);
    }
}
