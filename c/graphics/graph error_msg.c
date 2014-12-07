#include <graphics.h>
#include <stdlib.h>
#include <conio.h>
 
main()
{
   int gd, gm, errorcode;
 
   initgraph(&gd, &gm, "C:\\TC\\BGI");
 
   errorcode = graphresult();
 
   if(errorcode != grOk)
   {
      printf("Graphics error: %s\n", grapherrormsg(errorcode));
      printf("Press any key to exit.");
      getch();
      exit(1);
   }
 
   getch();
   closegraph();
   return 0;
}
