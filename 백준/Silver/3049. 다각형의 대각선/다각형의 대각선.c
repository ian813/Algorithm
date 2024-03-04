#include <stdio.h>

int main() {
	int n, diagonal;

	scanf("%d", &n);

	// nC4 구해주면 됨 -> 왜냐하면 교차점 하나가 나오기 위해서 점 4개를 선택해야 하므로
	diagonal = n * (n - 1) * (n - 2) * (n - 3) / 24;

	printf("%d", diagonal);
	
	return 0;
}