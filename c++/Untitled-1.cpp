#include <iostream>
#include <stdio.h>
using namespace std;

int main()
{
    int attempts, i,  x; 
    string spaces = "";
    string chars = "";
    string in = "";
	while (1)
	{
		scanf("%d", &attempts);
		if (attempts == 0)
            return 0;
        getchar_unlocked();
		x = getchar_unlocked();
		
		putchar_unlocked('|');
		
		spaces = "";
		chars = "";
		in = "";
		for (i = 0; i < attempts; i++) {
			spaces += " ";
			chars += x;
			in += "--------";
		}
		printf(in.c_str());
		putchar_unlocked('|');
		putchar_unlocked('\n');
		
		const char* space = spaces.c_str();
		const char* c = chars.c_str();
		
		for (i = 0; i < attempts; i++) {
			putchar_unlocked('|');
			printf("%s%s%s%s%s%s%s%s", space, c, space , c,space, c, space , c);		
			putchar_unlocked('|');  putchar_unlocked('\n');
		}
		for (i = 0; i < attempts; i++) {
			putchar_unlocked('|');
			printf("%s%s%s%s%s%s%s%s", c, space, c, space , c,space, c, space);
			putchar_unlocked('|'); putchar_unlocked('\n');
		}
		for (i = 0; i < attempts; i++) {
			putchar_unlocked('|');
			printf("%s%s%s%s%s%s%s%s", space, c, space , c,space, c, space , c);				
			putchar_unlocked('|');  putchar_unlocked('\n');
		}
		for (i = 0; i < attempts; i++) {
			putchar_unlocked('|');
			printf("%s%s%s%s%s%s%s%s", c, space, c, space , c,space, c, space);
			putchar_unlocked('|'); putchar_unlocked('\n');
		}
		for (i = 0; i < attempts; i++) {
			putchar_unlocked('|');
			printf("%s%s%s%s%s%s%s%s", space, c, space , c,space, c, space , c);				
			putchar_unlocked('|');  putchar_unlocked('\n');
		}
		for (i = 0; i < attempts; i++) {
			putchar_unlocked('|');
			printf("%s%s%s%s%s%s%s%s", c, space, c, space , c,space, c, space);
			putchar_unlocked('|'); putchar_unlocked('\n');
		}
		for (i = 0; i < attempts; i++) {
			putchar_unlocked('|');
			printf("%s%s%s%s%s%s%s%s", space, c, space , c,space, c, space , c);			
			putchar_unlocked('|');  putchar_unlocked('\n');
		}
		for (i = 0; i < attempts; i++) {
			putchar_unlocked('|');
			printf("%s%s%s%s%s%s%s%s", c, space, c, space , c,space, c, space);
			putchar_unlocked('|'); putchar_unlocked('\n');
		}
		
		putchar_unlocked('|');
		printf(in.c_str());
		putchar_unlocked('|');
		putchar_unlocked('\n');
	}
	return 0;
}