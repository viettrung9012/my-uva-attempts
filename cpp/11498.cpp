#include <iostream>

using namespace std;

int main(){
	int numCase;
	cin >> numCase;
	while (numCase != 0){
		int divPointX;
		int divPointY;
		cin >> divPointX;
		cin >> divPointY;
		int temp = numCase;
		while (temp > 0){
			int houseX;
			int houseY;
			cin >> houseX;
			cin >> houseY;
			if (houseX == divPointX || houseY == divPointY){
				cout << "divisa" << endl;
			}
			else if (houseX < divPointX && houseY < divPointY){
				cout << "SO" << endl;
			}
			else if (houseX > divPointX && houseY < divPointY){
				cout << "SE" << endl;
			}
			else if (houseX < divPointX && houseY > divPointY){
				cout << "NO" << endl;
			}
			else {
				cout << "NE" << endl;
			}
			temp--;
		}
		cin >> numCase;
	}

	return 0;
}