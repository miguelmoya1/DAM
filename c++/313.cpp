#include <stdio.h>
#define scan(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)
char _;

int main() {
	int a;
	scan(a);
	printf("%d", a);
	int x, y, t, i;
	scan(t);
	for(i = 0; i < t; i++) {
		scanf("%d%d",&x, &y);
		if (y+x>=0) {
			putchar('S'); putchar('I'); putchar('\n');
		} else {
			putchar('N'); putchar('O'); putchar('\n');
		}
	}
	return 0;
}
