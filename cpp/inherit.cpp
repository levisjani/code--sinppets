#include <iostream>

using namespace std;

class CFigure{

protected:
	double dSide;

public:
	CFigure(double a){dSide=a;};
	virtual	~CFigure(){};
	virtual double Surface(void)const=0;
	virtual double Side(void)const=0;
};

class CSquare: public CFigure{

public:
	CSquare(double a):CFigure(a){};
	~CSquare(){};

	double Surface(void)const{return dSide*dSide;}
	double Circumference(void)const{return 4.0*dSide;}
	double Side(void)const{return dSide;}
	
};

int main(void){

	CSquare Square_1(1);

	cout<<"Surface="
		<<Square_1.Surface()<<endl
		<<"Circumference="
		<<Square_1.Circumference()<<endl;

	CFigure* ptrFigure = new CSquare(2);
	
	cout<<"Surface="
    	<<ptrFigure->Surface()<<endl
    	<<"Circumference="
    	<<ptrFigure->Circumference()<<endl;	

delete ptrFigure;
    
return EXIT_SUCCESS;	
}
