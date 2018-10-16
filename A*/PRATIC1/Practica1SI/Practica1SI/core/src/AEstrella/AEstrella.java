/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AEstrella;

import java.util.ArrayList;
import java.util.PriorityQueue;


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
        //PriorityQueue  ListaFrontera = new  PriorityQueue();
        //PriorityQueue ListaInterior = new PriorityQueue();
        
        //COORDENADA TESTE
        Coordenada coord = new Coordenada();
        Coordenada caux = new Coordenada();
        Coordenada caux1 = new Coordenada();
        Coordenada atual = new Coordenada();
        
        
        
        //BUSQUEDA
        atual.set(mundo.caballero.getX(), mundo.caballero.getY());
        //caux.set(atual.getX()+1,atual.getY()-1);
        //caux1.set(atual.getX()+1,atual.getY()+1);
        
        if(atual.getY()%2 == 1) {
            for(int j = (atual.getX()-1); j <= (atual.getX()+1); j++){
                for( int i = (atual.getY()-1); i <= (atual.getY()+1); i++){
                    coord.set(j, i);
                    
                    caux.set(coord.getX()-1,coord.getY()+1);
                    caux1.set(coord.getX()-1,coord.getY()+1);
                    
                    //System.out.println("COORD " +"(" + j+","+i+") " + coord);
                    
                if(mundo.getCelda(j, i) != 'b' && mundo.getCelda(j, i) != 'p' && mundo.getCelda(j, i) != 'k' && ((caux.getX() != coord.getX()) && (caux.getY() != coord.getY()))){
                        
                        System.out.println("COORD " +"(" + j+","+i+") " + coord);
                        
                        //System.out.println("EQUALS " + ();
                        
                        
                        System.out.println("GET CELDA " + mundo.getCelda(j, i));
                        ListaFrontera.add(coord);
                    }
                }
            }
            
            
        }
        
        System.err.println("CAUX: " + caux);
        System.err.println("CAUX1: " + caux1);
        System.out.println("\n\nLF SIZE: " + ListaFrontera.size());
        
        /*
        Coordenada element = new Coordenada(); 
        element = (Coordenada) ListaFrontera.get((ListaFrontera.size()));
        System.out.println("\n\nLF SIZE: " + ListaFrontera.size());
        System.out.println("\n\nLF ULTIMO ELEMENT: " + element.getX() + "," + element.getY());
        */
        
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
        
        System.out.println("DRAGON X: " + mundo.dragon.getX());
        System.out.println("DRAGON Y: " + mundo.dragon.getY());
        
        //System.out.println("CELDA (0,0) " + mundo.getCelda(0, 0));
        
        //System.out.println("CAB Y-1: " + (mundo.caballero.getX()-1));
        //System.out.println("CAB X-1: " + (mundo.caballero.getY()-1));        
         
        //ListaFrontera.add(mundo.getCaballero());
        
        
        System.out.println("\nmundo.getCaballero(): " + mundo.getCaballero());
        System.out.println("ITERATOR: " + ListaFrontera.iterator());

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


