#include<iostream>

using namespace std;

int main()
{
    cout << "Enter a grade score: ";
    float input;
    cin >> input;

    string grade;
    if(input > 4 || input < 0)
    {
        cout << "Invalid input. Grades are between 4.0 and 0.0\n";
    }

    // grade assigning
    if(input == 4 || input >= 3.85)
    {
        grade = "A";
    }

    else if(input < 3.85 && input >= 3.7)
    {
        grade = "A-";
    }

    else if(input == 3.3 || input > 3)
    {
        grade = "B+";
    }

    else if(input == 3 || input >= 2.85)
    {
        grade = "B";
    }

    else if(input < 2.85 && input >= 2.7)
    {
        grade = "B-";
    }

    else if(input == 2.3 && input > 2)
    {
        grade = "C+";
    }

    else if(input == 2 || input >= 1.85)
    {
        grade = "C";
    }

    else if(input < 1.85 && input >= 1.7)
    {
        grade = "C-";
    }

    else if(input == 1.3 && input > 1)
    {
        grade = "D+";
    }

    else if(input == 1 || input >= 0.85)
    {
        grade = "D";
    }

    else if(input < 0.85 && input >= 0.7)
    {
        grade = "D-";
    }

    else
    {
        grade = "F";
    }

    cout << "Your grade is: " << grade;

    //return 0;
}
