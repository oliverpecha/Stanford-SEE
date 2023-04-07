/*
 * File: main.cpp
 * --------------
 * Blank C++ project configured to use Stanford cslib and Qt
 */

#include "console.h"
#include "simpio.h"
#include "rational.h"
using namespace std;


int main()
{

    // 1/2+1/3+1/6
    Rational a(1,2);
    Rational b(1,3);
    Rational c(1,4);
    Rational d(1,6);
    Rational e;
    cout << a << " + " << b << " + " << d << " = " << a + b + d << endl;
    cout << "e: " << e << endl;

    cout << "d += a: " << a << endl;
    cout << b << " + " << 1 << " = " << b + 1 << endl;
    cout << b << " + " << a << " = " << b + a << endl;

    cout << endl;
    Rational f(5,6);
    Rational g(3,8);
    if ( f < g) cout << f << " < " << g << endl;
    else cout << f << " !< " << g << endl;
    if ( f > g) cout << f << " < " << g << endl;
    else cout << f << " !< " << g << endl;

    if ( d < c) cout << d << " < " << c << endl;
    else cout << d << " !< " << c << endl;
    if ( d > c) cout << f << " < " << g << endl;
    else cout << d << " !< " << c << endl;
    Rational h(20,24);
    if ( f >= h) cout << f << " >= " << h << endl;
    else cout << f << " !>= " << h << endl;
    cout << endl;
    cout << "f: " << f << endl;
    cout << "f++: " << f++ << endl;
    cout << "f: " << f << endl;
    ++f;
    cout << "++f: " << f << endl;
    cout << "f: " << f << endl;












    return 0;
}
