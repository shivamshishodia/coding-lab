#include <iostream>
#include <cstdio>
#include <vector>
#include <climits>
#include <cmath>
using namespace std;

int main() {
	int t_case, play1, play2, index, lead;
	vector<int> max(2, INT_MIN);
	scanf("%d", &t_case);
	while(t_case--) {
		scanf("%d %d", &play1, &play2);
		index = play1 >= play2 ? 0 : 1;
		lead = abs(play1 - play2);
		if (max.at(index) < lead) {
			max.at(index) = lead;
		}
	}
	index = max.at(0) >= max.at(1) ? 0 : 1;
	printf("%d %d", index + 1, max.at(index));
	return 0;
}