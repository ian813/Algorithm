#include <stdio.h>

int main()
{
    int testCase, A, B;

    scanf("%d", &testCase);

    for (int tc = 1; tc <= testCase; tc++) {
        scanf("%d %d", &A, &B);

        printf("Case #%d: %d\n", tc, A + B);
    }

    return 0;
}