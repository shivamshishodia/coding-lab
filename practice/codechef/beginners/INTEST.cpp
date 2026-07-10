// https://www.codechef.com/problems/INTEST
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

int main() {
	long n = readInt(), k = readInt(), i, temp, count = 0;

	while(n--) {
		temp = readInt();
		if (temp % k == 0)
			++count;
	}
	printf("%ld", count);

	return 0;
}