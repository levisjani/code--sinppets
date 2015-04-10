#include <iostream>
#include <fstream>
#include <iomanip>
#include <string>
using namespace std;

void openFiles(ifstream&, ofstream&);
void initialize(ifstream&, ofstream&);
void sumGrades(float&, float&, ifstream&, ofstream&, int&, int&);
void averageGrade(int&, int&, float&, float&, ifstream&, ofstream&);
void printResults(int&, int&, float&, float&, ifstream&, ofstream&, float&, float&);

int main() {
	ifstream in;
	ofstream out;
	openFiles(in, out);
	return 0;
}

void openFiles(ifstream& in, ofstream& out) {
	in.open("GPA.dat");
	out.open("Out.dat");
	out << fixed << showpoint;
	out << setprecision(2);
	initialize(in, out);
}

void initialize(ifstream& in, ofstream& out) {
	char gender;
	float GPA;
	string line;
	int countFemale = 0;
	int countMale = 0;
	float sumFemaleGPA = 0;
	float sumMaleGPA = 0;
	while (!in.eof()) {
		in >> gender >> GPA;
		if (gender == 'f')  {
			countFemale++;
			sumFemaleGPA = sumFemaleGPA + GPA;
		}
		if (gender == 'm') {
			countMale++;
			sumMaleGPA = sumMaleGPA + GPA;
		}
	}
	sumGrades(sumFemaleGPA, sumMaleGPA, in, out, countFemale, countMale);
	averageGrade(countFemale, countMale, sumFemaleGPA, sumMaleGPA, in, out);
}

void sumGrades(float& sumFemaleGPA, float& sumMaleGPA, ifstream& in, ofstream& out, int& countFemale, int& countMale) {
	out << "Total Sum of GPA Grades: " << sumFemaleGPA + sumMaleGPA << endl;
}

void averageGrade(int& countFemale, int& countMale, float& sumFemaleGPA, float& sumMaleGPA, ifstream& in, ofstream& out) {
	float averageFemaleGPA = sumFemaleGPA / countFemale;
	float averageMaleGPA = sumMaleGPA / countMale;
	printResults(countFemale, countMale, sumFemaleGPA, sumMaleGPA, in, out, averageFemaleGPA, averageMaleGPA);
}

void printResults(int& countFemale, int&countMale, float& sumFemaleGPA, float& sumMaleGPA, ifstream& in, ofstream& out, float& averageFemaleGPA, float& averageMaleGPA) {
	out << "Total Females: " << countFemale << endl;
	out << "Total Males: " << countMale << endl;
	out << "Female Sum GPA: " << sumFemaleGPA << endl;
	out << "Male Sum GPA: " << sumMaleGPA << endl;
	out << "Female Average GPA: " << averageFemaleGPA << endl;
	out << "Male Average GPA: " << averageMaleGPA;
	in.close();
	out.close();
}
