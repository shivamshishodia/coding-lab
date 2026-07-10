#include <bits/stdc++.h>
using namespace std;

int main() {
	int t_case, num, odd;

	scanf("%d", &t_case);
	while(t_case--) {
		scanf("%d", &num);
		odd = 1;
		while(num--) {
			printf("%d ", odd);
			odd += 2;
		}
		printf("\n");
	}

	return 0;
}