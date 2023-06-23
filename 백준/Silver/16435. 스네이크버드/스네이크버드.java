import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int fruit, snake;
	static int[] height;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		
		// 과일 개수, 뱀의 길이 입력받기
		fruit = Integer.parseInt(st.nextToken());
		snake = Integer.parseInt(st.nextToken());
		
		// 과일의 높이
		height = new int[fruit];
		
		st = new StringTokenizer(br.readLine().trim());
		
		for(int i = 0; i < fruit; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}
		
		eat();
		
		System.out.println(snake);
	}
	
	static void eat() {
		// 오름차순 정렬
		Arrays.sort(height);
		
		// 작은것부터 먹을수 있는지 차례로 판단
		for(int i = 0; i < fruit; i++) {
			if(height[i] <= snake) { // 뱀 길이가 과일높이보다 작거나 같으면 뱀 길이 늘려주고
				snake++;
			} else { // 그렇지 않으면 멈추기
				break;
			}
		}
	}


}