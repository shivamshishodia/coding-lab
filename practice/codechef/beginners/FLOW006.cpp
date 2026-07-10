#include <bits/stdc++.h>
using namespace std;

int main() {
	int t_case, num, rem, sum;

	scanf("%d", &t_case);
	while (t_case--) {
		scanf("%d", &num);
		sum = 0;
		while (num > 0) {
			sum = sum + num % 10;
			num = num / 10;
		}
		printf("%d\n", sum);
	}

	return 0;
}