// https://www.codechef.com/problems/TSORT
#include <bits/stdc++.h>

void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

//It uses Dutch National Flag Algorithm
void partition(int a[], int low, int high, int &i, int &j)
{
    if (high - low <= 1) {
        if (a[high] < a[low])
            swap(&a[high], &a[low]);
        i = low;
        j = high;
        return;
    }

    int mid = low;
    int pivot = a[high];

    while (mid <= high) {
        if (a[mid]<pivot)
            swap(&a[low++], &a[mid++]);
        else if (a[mid]==pivot)
            mid++;
        else if (a[mid]>pivot)
            swap(&a[mid], &a[high--]);
    }
 
    i = low-1;
    j = mid;
}
 
void quicksort(int a[], int low, int high)
{
    if (low>=high)
        return;
 
    int i, j;
    partition(a, low, high, i, j); 
    quicksort(a, low, i);
    quicksort(a, j, high);
}

int main()
{
	int t_case, *ptr, i;
	scanf("%d", &t_case);
	ptr = (int*)malloc(sizeof(int)*t_case);

	for (i=0; i<t_case; ++i) {
		scanf("%d", (ptr + i));
	}

	quicksort(ptr, 0, t_case-1);

	for (i=0; i<t_case; ++i) {
		printf("%d\n", *(ptr + i));
	}

	return 0;
}