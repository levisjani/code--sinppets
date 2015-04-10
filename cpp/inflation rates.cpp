/*
Write a program that outputs inflation rates for two successive years and whether the
inflation is increasing or decreasing. Ask the user to input the current price of an item and
its price one year and two years ago. To calculate the inflation rate for a year, subtract the
price of the item for that year from the price of the item one year ago and then divide the
result by the price a year ago. Your program must contain at least the following
functions: a function to get the input, a function to calculate the results, and a function to
output the results. Use appropriate parameters to pass the information in and out of the
function. Do not use any global variables.
*/

#include<iostream>
#include<iomanip>
#include<string>
using namespace std;


double getDoubleInput(string message);
double inflationRate(double oldPrice, double newPrice);
void printPercent2d(double value);

int main()
{
    double price1; // The price of the item two years ago
    double price2; // The price of the item one year ago
    double price3; // The current price of the item
    double rate1; // The inflatin rate for the first two years
    double rate2; // The inflation rate for the second two years

    price1 = getDoubleInput("Enter the price from two years ago:");
    price2 = getDoubleInput("Enter the price from one year ago:");
    price3 = getDoubleInput("Enter the current price:");


    cout << "\n";

    rate1 = inflationRate(price1, price2);

    cout << "The inflation rate from two years ago to one year ago is: ";
    printPercent2d(rate1);

    rate2 = inflationRate(price2, price3);

    cout << "The inflation rate from one year ago to now is: ";
    printPercent2d(rate2);

    cout << "\n";


    if ( rate1 < rate2 )
    {
        cout << "The inflation rate is increasing" << endl;
    }
    else if (rate1 > rate2)
    {
        cout << "The inflation rate is decreasing" << endl;
    }
    else
    {
        cout << "There is no change in the inflation rate" << endl;
    }


    return 0;

}

double getDoubleInput(string message)
{

    double num;
    cout << message << " ";
    cin >> num;

    while ( !cin )
    {
        cin.clear();
        cin.ignore(5000, '\n');

        cout << "Please enter a double: ";
        cin >> num;
    }

    return num;

}

double inflationRate(double oldPrice, double newPrice)
{
    double rate;
    rate = (newPrice - oldPrice) / oldPrice;

    return rate;


}

void printPercent2d(double value)
{
    cout << fixed << setprecision(2);
    cout << (value * 100) << "%" << endl;
}
