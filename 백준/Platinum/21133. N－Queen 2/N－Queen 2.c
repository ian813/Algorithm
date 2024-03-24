#include <stdio.h>

int main() {
    int N;
    scanf("%d", &N);

    if (N % 6 != 2 && N % 6 != 3) {
        for (int i = 1; i <= N; i += 2) {
            printf("%d\n", i);
        }

        for (int i = 2; i <= N; i += 2) {
            printf("%d\n", i);
        }

    } else if (N % 6 == 2) {
        for (int i = 2; i <= N; i += 2) {
            printf("%d\n", i);
        }

        printf("3\n");
        printf("1\n");

        for (int i = 7; i <= N; i += 2) {
            printf("%d\n", i);
        }

        printf("5\n");

    } else {
        for (int i = 4; i <= N; i += 2) {
            printf("%d\n", i);
        }

        printf("2\n");

        for (int i = 5; i <= N; i += 2) {
            printf("%d\n", i);
        }

        printf("1\n");
        printf("3\n");
    }

    return 0;
}