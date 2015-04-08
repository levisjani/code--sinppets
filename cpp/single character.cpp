/*
Write a program that prompts the user to provide a single character from the alphabet.
Print Vowel or Consonant, depending on the user input. If the user input is not a letter
(between a and z or A and Z), or is a string of length > 1, print an error message.
*/

#include<iostream>
#include<cctype>

using namespace std;

int main()
{
    cout << "Enter a single character from the alphabet: ";
    char input;
    cin >> input;

    /// isalpha() is a function that checks if it's a letter.

    if(isalpha(input))
    {
        if(input == 'a' || input == 'A' || input == 'e' || input == 'E' || input == 'i' || input == 'I' || input == 'o' || input == 'O' || input == 'u' || input == 'U')
        {
            cout << input << " is a vowel\n";
        }

        else
        {
            cout << input << " is a consonant.\n";
        }
    }

    else
    {
        cout << "Invalid input\n";
    }

    return 0;
}
