#include <iostream>
#define scan(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)
char _;
int main() {
	int trys, total, suma;
	scan(trys);
	for (int i = 0; i < trys; i++) {
		int number = 1;
		total = 0;
		suma = 0;
		scan(number);
		while(number != 0) {
			suma += number;
			total += suma;
			scan(number);
		}
		printf("%d\n", total * 2);
	}
	return 0;
}


