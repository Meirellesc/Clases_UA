//TRAINING

#include <fstream>
#include <vector>
#include <stdio.h>
#include <iostream>

//using namespace std;

int main() {
  std::ifstream file("datos.csv");
  unsigned size;
  file >> size;

  if (!file) {
    //erro durante leitura
  }

  std::vector<int> matrix;
  matrix.reserve(size*size);

  while (true) {
    double value;
    if (!(file >> value)) {
      break;
    }
    matrix.push_back(value);
  }

  if (matrix.size() != size*size) {
    //erro durante leitura
  }

//return matrix[0];
std::cout<<"MATRIZ: ";
//return 0;
//usa matriz
}
