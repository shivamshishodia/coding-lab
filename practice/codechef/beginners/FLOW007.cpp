#include <bits/stdc++.h>
using namespace std;

int main() {
	int t_case, num, rev, rem;

	scanf("%d", &t_case);
	while (t_case--) {
		scanf("%d", &num);
		rev = 0;
		while (num > 0) {
			rev = rev * 10 + num % 10;
			num = num / 10;
		}
		printf("%d\n", rev);
	}

	return 0;
}