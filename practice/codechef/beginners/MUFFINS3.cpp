// https://www.codechef.com/problems/MUFFINS3
#include <bits/stdc++.h>

int main()
{
	long int t_case, i, cakes, left, pack;
	scanf("%ld", &t_case);

	while(t_case--) {
		left = 0;
		scanf("%ld", &cakes);

		if (cakes % 2 == 0)
			printf("%ld\n", (cakes/2)+1);
		else 
			printf("%ld\n", (cakes+1)/2);
	}

	return 0;
}