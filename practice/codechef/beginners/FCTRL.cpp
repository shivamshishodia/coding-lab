// https://www.codechef.com/problems/FCTRL
#include <bits/stdc++.h>
using namespace std;

#define BUF 4096
char ibuf[BUF];
int ipt = BUF;
int readInt() {
	while (ipt < BUF && ibuf[ipt] < '0') ipt++;
	if (ipt == BUF) {
		fread(ibuf, 1, BUF, stdin);
		ipt = 0;
		while (ipt < BUF && ibuf[ipt] < '0') ipt++;
	}
	int n = 0;
	while (ipt < BUF && ibuf[ipt] >= '0') n = (n*10)+(ibuf[ipt++]-'0');
	if (ipt == BUF) {
		fread(ibuf, 1, BUF, stdin);
		ipt = 0;
		while (ipt < BUF && ibuf[ipt] >= '0') n = (n*10)+(ibuf[ipt++]-'0');
	}
	return n;
}

int main(void) {
	int n = readInt(), num, count, i;
	while(n--) {
		count = 0;
		num = readInt();
		for (i = 5; num/i >= 1; i *= 5) {
			count += num/i;
		}
		printf("%d\n", count);
	}

	return 0;
}