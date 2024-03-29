/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AEstrella;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Vector;


/**
 *
 * @author Lucas Meirelles
 */
public class AEstrella {
 
    //Mundo sobre el que se debe calcular A*
    Mundo mundo;
    
    //Camino
    public char camino[][];
    
    //Casillas expandidas
    int camino_expandido[][];
    
    //Número de nodos expandidos
    int expandidos;
    
    //Coste del camino
    float coste_total;
    
    public AEstrella(){
        expandidos = 0;
        mundo = new Mundo();
    }
    
    public AEstrella(Mundo m){
        //Copia el mundo que le llega por parámetro
        mundo = new Mundo(m);
        camino = new char[m.tamanyo_y][m.tamanyo_x];
        camino_expandido = new int[m.tamanyo_y][m.tamanyo_x];
        expandidos = 0;
        
        //Inicializa las variables camino y camino_expandidos donde el A* debe incluir el resultado
            for(int i=0;i<m.tamanyo_x;i++)
                for(int j=0;j<m.tamanyo_y;j++){
                    camino[j][i] = '.';
                    camino_expandido[j][i] = -1;
                }
    }
    
    //Calcula el A*
    public int CalcularAEstrella(){

        boolean encontrado = true;
        int result = 1;
        
        //AQUÍ ES DONDE SE DEBE IMPLEMENTAR A*
        
        ArrayList ListaFrontera = new ArrayList();
        ArrayList ListaInterior = new ArrayList();
        
        //G(N) COAST 
        int g = 0;
        
        //COORDINATES
        Coordenada atual = new Coordenada();
        Coordenada caux = new Coordenada();
        Coordenada caux1 = new Coordenada();
        
        
        
        
        //-----------------------------------------BUSQUEDA-----------------------------------------//
        atual.set(mundo.caballero.getX(), mundo.caballero.getY());
        caux.set(atual.getX()+1,atual.getY());
        caux1.set(atual.getX()-1,atual.getY());
        
        //ADDING THE CABALLERO POSITIONING
        ListaFrontera.add(atual);
        
        
        //while(ListaFrontera.isEmpty() == false){
            
        //}
        
        //IN CASE THE ATUAL POSITION IS UNPAIRED 
        if(atual.getY()%2 == 1) {
            for(int j = (atual.getX()-1); j <= (atual.getX()); j++){
                for( int i = (atual.getY()-1); i <= (atual.getY()+1); i++){
                    Coordenada coord = new Coordenada(j,i);
                    
                if(mundo.getCelda(j, i) != 'b' && mundo.getCelda(j, i) != 'p' && mundo.getCelda(j, i) != 'k' ){
                        ListaFrontera.add(coord);
                        
                        System.out.println("COORD " +"(" + j+","+i+") " + coord);
                        System.out.println("GET CELDA " + mundo.getCelda(j, i));
                }
            }   
        }
            //Adding the exception
            if(mundo.getCelda(caux.getX(), caux.getY()) != 'b' && mundo.getCelda(caux.getX(), caux.getY()) != 'p' && mundo.getCelda(caux.getX(), caux.getY()) != 'k'){
                ListaFrontera.add(caux);
            }
            //Increasing the coast
            g = g +1;

        }
        
        //--------------------------------------------------------------------//
        
        //IN CASE THE ACTUAL POSITION IS PAIRED
        if(atual.getY()%2 == 0) {
            for(int j = (atual.getX()); j <= (atual.getX()+1); j++){
                for( int i = (atual.getY()-1); i <= (atual.getY()+1); i++){
                    
                    Coordenada coord = new Coordenada(j,i);
                    
                if(mundo.getCelda(j, i) != 'b' && mundo.getCelda(j, i) != 'p' && mundo.getCelda(j, i) != 'k' ){
                        ListaFrontera.add(coord);
                        
                        System.out.println("COORD " +"(" + j+","+i+") " + coord);
                        System.out.println("GET CELDA " + mundo.getCelda(j, i));
                }
            }   
        }
            //Adding the exception
            if(mundo.getCelda(caux1.getX(), caux1.getY()) != 'b' && mundo.getCelda(caux1.getX(), caux1.getY()) != 'p' && mundo.getCelda(caux1.getX(), caux1.getY()) != 'k'){
                ListaFrontera.add(caux1);
            }
        
            g = g +1;
            
        }
        //-----------------------------------------BUSQUEDA-----------------------------------------//
        
        
        
        caux = (Coordenada) ListaFrontera.get(4);
        System.err.println("CAUX1_X: " + caux.getX());
        System.err.println("CAUX1_y: " + caux.getY());
     
        camino[caux.getY()][caux.getX()] = 'X';
        
        //CALCULO DA HEURISTICA
        /*int h = 0;
        
        for (int j = celda.getY(); j>= mundo.dragon.getY() ; j++ ){
            System.out.println("ENTREI J");
            for (int i = celda.getX(); i >= mundo.dragon.getX() ; i++ ){
                System.out.println("ENTREI I");
                h = h + 1;
            }
        System.out.println("\n\nH(n) = " + h + "\n\n");
        }*/
        
       
        //Si ha encontrado la solución, es decir, el camino, muestra las matrices camino y camino_expandidos y el número de nodos expandidos
        if(encontrado){
            //Mostrar las soluciones
            System.out.println("Camino");
            mostrarCamino();

            System.out.println("Camino explorado");
            mostrarCaminoExpandido();
            
            System.out.println("Nodos expandidos: "+expandidos);
        }

        return result;
    }
    
      
    //Muestra la matriz que contendrá el camino después de calcular A*
    public void mostrarCamino(){
        for (int i=0; i<mundo.tamanyo_y; i++){
            if(i%2==0)
                System.out.print(" ");
            for(int j=0;j<mundo.tamanyo_x; j++){
                System.out.print(camino[i][j]+" ");
            }
            System.out.println();   
        }
    }
    
    //Muestra la matriz que contendrá el orden de los nodos expandidos después de calcular A*
    public void mostrarCaminoExpandido(){
        for (int i=0; i<mundo.tamanyo_y; i++){
            if(i%2==0)
                    System.out.print(" ");
            for(int j=0;j<mundo.tamanyo_x; j++){
                if(camino_expandido[i][j]>-1 && camino_expandido[i][j]<10)
                    System.out.print(" ");
                System.out.print(camino_expandido[i][j]+" ");
            }
            System.out.println();   
        }
    }
    
    public void reiniciarAEstrella(Mundo m){
        //Copia el mundo que le llega por parámetro
        mundo = new Mundo(m);
        camino = new char[m.tamanyo_y][m.tamanyo_x];
        camino_expandido = new int[m.tamanyo_y][m.tamanyo_x];
        expandidos = 0;
        
        //Inicializa las variables camino y camino_expandidos donde el A* debe incluir el resultado
            for(int i=0;i<m.tamanyo_x;i++)
                for(int j=0;j<m.tamanyo_y;j++){
                    camino[j][i] = '.';
                    camino_expandido[j][i] = -1;
                }
    }
    
    public float getCosteTotal(){
        return coste_total;
    }
}


