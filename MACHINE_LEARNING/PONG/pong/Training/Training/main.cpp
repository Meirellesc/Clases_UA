//----------TRAINING---------//

//#include <QCoreApplication>
#include <iostream>
#include <fstream>
#include <string>

#include <stdio.h>
#include <stdlib.h>

#include<sstream>
using namespace std;

//Struct to keep the datos from game.
/*
struct sdatos{
    float x[100];
};*/

int main()//(int argc, char *argv[])
{
    //Defining the file's path.
    ifstream Data_File ("/home/meirelles/Clases_UA/MACHINE_LEARNING/PONG/pong/Training/Training/datos_manipulated.txt");

    //Variables_Vectors.
    double vector_x[100];
    double vector_y[100];
    double vector_w[100];
    //sdatos datos;
    string receive;
    int k=0;
    int conv;

    //CONDITION THAT CHECK IF THE FILE IS OPEN
    if (Data_File.is_open()){

        //WHILE THE FILE IS NOT EMPTY...
        //while(!Data_File.eof()){
        while(Data_File.good()){
            getline(Data_File,receive,';'); //Reading each line from 'Data_File'
            stringstream (receive) >> vector_x[k];   //Converting String >> Int
            //cout<<"DATOS STRING: "<<receive[k]<<"\n";
            k=k+1;
        }

    Data_File.close();
    }
    else{ //IF NOT FOUND THE FILE...
        cout<< "Não encontrou o arquivo!"<<"\n";
    }

    cout<<"-----------Working with Vector-------------"<<"\n";


    for (int j=0;j<30;j++){
        //cout<<"DATOS VEC: "<<datos.x[j]<<"\n";
        cout<<"DATOS VEC: "<<vector_x[j]<<"\n";
    }


    return 0;

}

