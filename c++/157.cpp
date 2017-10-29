#include <stdio.h>
#define scan(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)
 char _;
 void p(int n) {
	if (n / 10 != 0) p(n / 10);
	putchar((n % 10) + '0');
 }
 	    
int main() {
	short trys, dia, mes;
	scan(trys);
	while (trys) {
		scan(dia);
		scan(mes);
		switch(mes) {
			case 1: p(365-dia); break;
			case 2: p(334-dia); break;
			case 3: p(306-dia); break;
			case 4: p(275-dia); break;
			case 5: p(245-dia); break;
			case 6: p(214-dia); break;
			case 7: p(184-dia); break;
			case 8: p(153-dia); break;
			case 9: p(122-dia); break;
			case 10: p(92-dia); break;
			case 11: p(61-dia); break;
			case 12: p(31-dia); break;
		}
		putchar('\n');
		trys--;
	}
	return 0;
}

