#include <iostream>

using namespace std;

int main(){
	int numCase;
	cin >> numCase;
	while (numCase > 0){
		long lhs;
		long rhs;
		cin >> lhs;
		cin >> rhs;
		if (lhs < rhs) { cout << "<" << endl; }
		else if (lhs > rhs) { cout << ">" << endl; }
		else { cout << "=" << endl; }
		numCase--;
	}

	return 0;
}