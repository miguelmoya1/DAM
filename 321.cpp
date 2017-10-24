#include <iostream>
#define scan(x) do{while((x=getchar_unlocked())<'0'); for(x-='0'; '0'<=(_=getchar_unlocked()); x=(x<<3)+(x<<1)+_-'0');}while(0)
char _;
int main()
{
	int trys, c, t;
	char a, b;
	scan(trys);
	for (int i = 0; i < trys; trys--)
	{
		scan(c); 
		t = 0;
		for	(int i = 0; i < c; c--)
		{
			a = getchar_unlocked();
			b = getchar_unlocked();
			getchar_unlocked();
			if (a == 'M' && b == 'M') t--; else
			if (a == 'H' && b == 'H') t++;  
		}
		if (t == 0) {
			putchar_unlocked('P');putchar_unlocked('O');putchar_unlocked('S');putchar_unlocked('I');putchar_unlocked('B');putchar_unlocked('L');putchar_unlocked('E');putchar_unlocked('\n');
		}
		else {
			putchar_unlocked('I');putchar_unlocked('M');putchar_unlocked('P');putchar_unlocked('O');putchar_unlocked('S');putchar_unlocked('I');putchar_unlocked('B');putchar_unlocked('L');putchar_unlocked('E');putchar_unlocked('\n');
		}
	}
	return 0;
}
