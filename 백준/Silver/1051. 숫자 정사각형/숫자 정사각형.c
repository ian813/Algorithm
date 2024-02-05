#include <stdio.h>

// 직사각형의 최대 가로 세로 길이 : 50
#define maxLength 50

// 높이와 너비, 직사각형 정보를 담을 배열
int height, width;
int rectangular[maxLength][maxLength];

// 최대 정사각형 찾기
int findMaxSquare() {
    // 답
    int ans = 1;

    // 직사각형 전부 돌면서 최댓값 찾기
    for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
            for (int k = 1; k < (height < width ? height : width); k++) {
                // k를 1부터 넓이, 너비 중 최솟값까지 하나씩 늘리면서 정사각형이 만들어지는지 탐색
                if (i + k < height && j + k < width &&
                    rectangular[i][j] == rectangular[i + k][j] &&
                    rectangular[i][j] == rectangular[i][j + k] &&
                    rectangular[i][j] == rectangular[i + k][j + k]) {
                    // 정사각형 조건을 만족하면 최댓값 갱신
                    ans = (ans > k + 1 ? ans : k + 1);
                }
            }
        }
    }

    // 넓이 구해서 반환
    return ans * ans;
}

int main() {

    scanf("%d %d", &height, &width);

    for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
            scanf("%1d", &rectangular[i][j]);
        }
    }

    // 정사각형 최대넓이 출력
    printf("%d\n", findMaxSquare());

    return 0;
}