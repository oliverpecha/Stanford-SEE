#include <iostream>
#include <sstream>
#include <iomanip>
#include <algorithm>
#include <console.h>

int main() {
  double youge = 1.46000001e5;
   std::cout<<youge << std::endl; // 1e16.csv
  std::stringstream ss;
  ss<<youge<<".csv";
  std::string filename = ss.str(); // filename = 1e+16.csv
  filename.erase(std::remove(filename.begin(), filename.end(), '+'), filename.end());// removing the '+' sign
  std::cout<<filename; // 1e16.csv
  return 0;
}
