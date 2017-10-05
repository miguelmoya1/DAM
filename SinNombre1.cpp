#include <stdio.h>
#define scan(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)
 char _;

int main() {
	int y, r, i, j, t;
	scan(r);
	i = r;
	for(; i > 0; i--) {
		scan(t);
		j = t;
		for(; j > 0; j--) {
			scan(y);
			if(y % 2 != 0) t--;
		}
		printf("%d\n", t);
	}
	return 0;
}
