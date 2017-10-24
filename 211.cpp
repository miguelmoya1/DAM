#include <unistd.h>
// #define scan(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)
char _;
 
int main() {
 	int x;
 	// scan(x); 		
 	while (x != 0) {
	 	printf(x % 2 != 0 ? "IZQUIERDA\n" : "DERECHA\n");
		scan(x);
	}
}
