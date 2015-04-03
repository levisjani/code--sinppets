/*
Write a program that calculates and prints the monthly paycheck for an employee. The
net pay is calculated after taking the following deductions:
Federal Income Tax: 15%
State Tax: 3.5%
Social Security Tax: 5.75%
Medicare/Medicaid Tax: 2.75%
Pension Plan: 5%
Health Insurance: $75.00
Your program should prompt the user to input the gross amount and the employee name.
The output will be stored in a file. Format your output to have two decimal places.
*/

#include<iostream>
using namespace std;

int main()
{
    cout << "Enter your Gross Pay: ";
    double pay;
    double gross_pay = pay * 1;
    cin >> pay;

    cout << "Enter Federal Income tax: ";
    double fedtax;
    double fedtaxr = gross_pay * 0.15;
    cin >> fedtax;

    cout << "Enter State tax: ";
    double statetax;
    double statetaxr = gross_pay * 0.035;
    cin >> statetax;

    cout << "Enter Social Security tax: ";
    double socialtax;
    double socialtaxr = gross_pay * 0.0575;
    cin >> socialtax;

    cout << "Enter Medical/Medicaid tax: ";
    double medicaretax;
    double medicaretaxr = gross_pay * 0.0275;
    cin >> medicaretax;

    cout << "Enter Pension Plan tax: ";
    double pensiontax;
    double pensiontaxr = gross_pay * 0.05;
    cin >> pensiontax;

    cout << "Enter Health Insurance tax: ";
    double healthtax;
    double healthtaxr = gross_pay - 75.0;
    cin >> healthtax;

    double deductions = fedtaxr + statetaxr + socialtaxr + medicaretaxr +
             pensiontaxr + healthtaxr;

    double total_pay = gross_pay - deductions;
    string employee = "Bill Robinson";

    cout << "Employee name: " << employee << "\n";
    cout << "Enter your Gross Pay: " << gross_pay << "\n";
    cout << "Deductions: " << "\n";
    cout << "Federdal Withholding (15.0%): $ " << fedtaxr << "\n";
    cout << "State Withholding (3.5% ): $ " << statetaxr << "\n";
    cout << "Social Security Tax (5.75%): $ " << socialtaxr << "\n";
    cout << "Medicare Tax (2.75%): $ " << medicaretaxr << "\n";
    cout << "Pension Plan (5%): $ " << pensiontaxr << "\n";
    cout << "Health Insurance ($75.00): $ " << healthtaxr << "\n";
    cout << "Total deductions: $ " << deductions << "\n";
    cout << "Total pay: " << total_pay;
}
