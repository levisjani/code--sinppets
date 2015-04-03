/*
Write a program that reads in the name and salary of an employee. Here the salary will
denote an hourly wage, such as $9.25. Then ask how many hours the employee worked in
the past week. Be sure to accept fractional hours. Compute the pay. Any overtime work
(over 40 hours per week) is paid at 150 percent of the regular wage. Print a paycheck for
the employee.
*/

#include<iostream>
using namespace std;

int main()
{

    cout << "Name: ";
    string name;
    cin >> name;

    cout << "Hourly wage: ";
    double hourly_wage;
    cin >> hourly_wage;

    cout << "Hours worked: ";
    double hours;
    cin >> hours;

    double pay = 0;
    if(hours > 40)
    {
        pay = hourly_wage * hours * 1.5;
    }

    else
    {
        pay = hourly_wage * hours;
    }

    cout << name << ", your payment is " << pay;
}
