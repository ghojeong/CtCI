#include <iostream>
using namespace std;

union ShareData{
	int a;
	float b;
};

int main()
{
	ShareData i1;
	i1.b = 5.125;
	ShareData i2;
	i2.b = 0.125;


	int result = i1.a ^ i2.a;
	int count = 0;
	for(int i = 0; i< 32; i++){
		if (result & 1) count++;
		result >>= 1;
	}


	cout << count << endl;

	return 0;
}

