#include <stdio.h>
#define scan(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)
 char _;
 
int main()
{
	short size = 1;
	short toMatriz;
	
	while(size != 0)
	{
		scan(size);
		if(size != 0)
		{
			short ok = 1;
			short i,j;
			for(i = 0; i < size; i++)
				for(j = 0; j < size; j++)
				{	
					scan(toMatriz);
					if(ok)
						if (i != j)
						{
							if (toMatriz != 0)
								ok = 0;
						}
						else 
							if(toMatriz != 1)
								ok = 0;
				}
				if(ok)
					printf("SI\n");
				else
					printf("NO\n");
		}
		else
			return 0;
	}
}
