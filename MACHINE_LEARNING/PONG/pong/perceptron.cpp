//----------TRAINING---------//

//#include <QCoreApplication>
#include <iostream>
#include <fstream>
#include <string>

#include <stdio.h>
#include <stdlib.h>

#include<sstream>
using namespace std;

struct sdatos{
    float x[100];
};

int main()//(int argc, char *argv[])
{

    ifstream Dfile ("/home/meirelles/Clases_UA/MACHINE_LEARNING/PONG/pong/Training/Training/datos_manipulated.txt");
    string receive;
    string temp;

    int i=0;
    sdatos datos;



    //READING THE FILE
    if (Dfile.is_open()){
        while(!Dfile.eof()){
            getline(Dfile,receive);
            stringstream (receive) >> datos.x[i];
            i = i+1;

            int count = receive.size();
            cout<<"Count : "<<count<<"\n";
            cout<<"DATOS STRING: "<<receive<<"\n";
        }
        Dfile.close();
    }
    else{ //IF NOT FOUND THE FILE...
        cout<< "Não encontrou o arquivo!"<<"\n";
    }

    cout<<"-----------Trabalhando com a String-------------"<<"\n";

    for (int j=0;j<30;j++){
        cout<<"DATOS VEC: "<<datos.x[j]<<"\n";
    }


    return 0;

}

