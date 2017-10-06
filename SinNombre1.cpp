#include <cstdio>
#define scan(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)
 char _;

int main() {
	register short y, i, j, t;
	scan(i);
	for(; i > 0; i--) {
		scan(t);
		j = t;
		for(; j > 0; j--) {
			scan(y);
			if(y % 2 != 0 )t--;
		}
		 char buffor[3];
         register short h=0;
         do{
               buffor[h++]=(t%10)+'0';
               t/=10;
            } while(t);
           h--;
            while(h>=0) putchar(buffor[h--]);
            putchar('\n');
	}
	return 0;
}
