import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        
        // 1부터 n까지 합 구하기
        int ans = n*(n+1)/2;
        
        System.out.println(ans);
    }
}