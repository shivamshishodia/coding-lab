// https://www.codechef.com/problems/HS08TEST
#include <bits/stdc++.h>
using namespace std;

int main() {
	int draw;
	float bal;
	scanf("%d %f", &draw, &bal);
	if ((draw % 5 == 0) && (draw <= (bal - 0.5)))
		printf("%.2f", bal - draw - 0.5);
	else
		printf("%.2f", bal);

	return 0;
}