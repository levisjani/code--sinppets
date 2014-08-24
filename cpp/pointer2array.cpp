#include <iostream>
using namespace std;

int main ()
{
   // an array with 5 elements.
   double arr[5] = {10,20,30,40,50};
   double *ptr;

   ptr = arr;

   // output each array element's value
   cout << "Print Array Elements : " << endl;
   for ( int i = 0; i < 5; i++ )
   {
       cout << "*(ptr + "  << i << ") : ";
       cout <<  *(ptr + i) << endl;
   }

   return 0;
}
