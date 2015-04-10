/*
Write a program that prompts the user to input a string. The program then uses the
function substr to remove all the vowels from the string. For example, if str = "There",
then after removing all the vowels, str = "Thr". After removing all the vowels, output the
string. Your program must contain a function to remove all the vowels and a function to
determine whether a character is a vowel.
*/
#include <iostream>
#include <string>

using namespace std;

void removeVowels(string& s);
bool isVowel(char v);

int main()
{
	string input;
	char isRunning = 'y';
	cout << "This program will remove all vowels from your input.\n";

	while (isRunning != 'n')
	{
		cout << "Input: ";
		cin >> input;
		removeVowels(input);
		cout << "\nYour new string is: " << input << endl;
		cout << "Would you like to go again? <y/n>: ";
		cin >> isRunning;
		cout << endl;
	}
}

void removeVowels(string& s)
{
	string tempStr = "";
	int substrLength = 0;
	int stringStart = 0;
	bool startSet = false;
	for (int i = 0; i < s.length(); i++)
	{
		if (!isVowel(s[i]))
		{
			substrLength++;
			if (!startSet)
			{
				stringStart = i;
				startSet = true;
			}
		}
		else
		{
			tempStr += s.substr(stringStart, substrLength);
			substrLength = 0;
			stringStart = 0;
			startSet = false;
		}
	}
	s = tempStr;
}

bool isVowel(char v)
{
	if (v == 'a' || v == 'e' || v == 'i' || v == 'o' || v == 'u' || v == 'A' || v == 'E' || v == 'I' || v == 'O' || v == 'U')
	{
		return true;
	}
	else
	{
		return false;
	}
}
