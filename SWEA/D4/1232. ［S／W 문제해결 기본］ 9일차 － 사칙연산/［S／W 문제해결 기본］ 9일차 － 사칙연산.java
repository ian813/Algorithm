import java.util.Scanner;

public class Solution {
	static int nodeNum;
	static double[] number;
	static char[] operator;
	static String[] nodeInfo;
	static int[][] priorityCal;

	// node의 순서를 저장할 배열
	static int[] node;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			// node의 개수
			nodeNum = sc.nextInt();

			sc.nextLine();

			// 연산자를 담아줄 배열
			operator = new char[nodeNum+1];
			// 숫자를 받아줄 배열
			number = new double[nodeNum+1];
			// 우선순위를 위해 숫자를 받아줄 배열
			priorityCal = new int[nodeNum+1][2];
			
			// nodeNum만큼 정보 받아주기
			for (int idx = 0; idx < nodeNum; idx++) {
				// nodeInfo에 node정보를 저장
				// 띄어쓰기를 기준으로 쪼개서 받기
				nodeInfo = sc.nextLine().split(" ");


				if(nodeInfo.length == 4) {
					// 노드 정보의 길이가 4이면 연산자가 포함되어 있으므로
					char temp = ' ';
					if(nodeInfo[1].equals("*")) {
						temp = '*';
					} else if(nodeInfo[1].equals("/")) {
						temp = '/';
					} else if(nodeInfo[1].equals("+")) {
						temp = '+';
					} else if(nodeInfo[1].equals("-")) {
						temp = '-';
					}

					// 연산자를 노드 번호의 인덱스에 담아준다.
					operator[Integer.parseInt(nodeInfo[0])] = temp;
					
					// 자식 노드들은 우선순위를 담는 배열에 담아준다.
					priorityCal[Integer.parseInt(nodeInfo[0])][0] = Integer.parseInt(nodeInfo[2]);
					priorityCal[Integer.parseInt(nodeInfo[0])][1] = Integer.parseInt(nodeInfo[3]);
					
				} else {
					// 노드 정보의 길이가 4가 아니면숫자 정보가 포함되어 있으므로
					// 노드에 해당하는 인덱스에 숫자를 저장해준다.
					number[Integer.parseInt(nodeInfo[0])] = Integer.parseInt(nodeInfo[1]);
					
				}



			}
			
			// 한번 계산한 값을 임시로 담아줄 변수
			double tmpResult;
			
			for(int tmpIdx = nodeNum; tmpIdx >= 0; tmpIdx--) {
				if(operator[tmpIdx] == '*') {
					// *를 찾으면 해당 인덱스로 숫자를 찾아가서 *연산을 해주고
					tmpResult = number[priorityCal[tmpIdx][0]] * number[priorityCal[tmpIdx][1]];
					
					// 그 결과값을 해당 인덱스에 넣어준다.
					number[tmpIdx] = tmpResult;
					
				} else if(operator[tmpIdx] == '/') { // 나머지 연산들도 *와 마찬가지로 해준다.
					tmpResult = number[priorityCal[tmpIdx][0]] / number[priorityCal[tmpIdx][1]];
					
					number[tmpIdx] = tmpResult;
					
				} else if(operator[tmpIdx] == '+') {
					tmpResult = number[priorityCal[tmpIdx][0]] + number[priorityCal[tmpIdx][1]];
					
					number[tmpIdx] = tmpResult;
					
				} else if(operator[tmpIdx] == '-') {
					tmpResult = number[priorityCal[tmpIdx][0]] - number[priorityCal[tmpIdx][1]];
					
					number[tmpIdx] = tmpResult;
				} 
			}
			
			// 루트노드까지 끝나면 결과값이 1번인덱스에 저장되어 있다.
			double result = number[1];

			// 결과값을 int형으로 바꿔서 출력하면 끝
			System.out.println("#" + tc + " " + (int)result);
		}
	}
}