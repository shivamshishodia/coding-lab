#include <bits/stdc++.h>
using namespace std;

int main() {
	int t_case, i, m, n, rank, sum;

	scanf("%d", &t_case);
	while(t_case--) {
		scanf("%d %d", &m, &n);
		m = m + 1;
		rank = (m * (m + 1)) / 2;
		/*for (i = 0; i < n; ++i) {
			rank = rank + m + i;
		}*/
		sum = (n * (2 * m + (n - 1) ))/ 2;
		printf("%d\n", rank + sum);
	}

	return 0;
}