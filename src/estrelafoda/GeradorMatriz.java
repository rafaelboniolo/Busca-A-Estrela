/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estrelafoda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Boniolo
 */
public class GeradorMatriz {
    
    
    
    
    
    private Integer[][] geradorNum(){
        Integer[] terrenos = {1,20,4,1000,10,1,4,10,20,1,20,4,1,-10};
        Integer[][] matriz = new Integer[10][10];
        Integer teste;
        
        Random rand = new Random();
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){

                matriz[i][j] = terrenos[rand.nextInt(14)];                        
            }
        }
        
        
        return matriz;
        
    }
    
    private List<List<Nodo>> geradorNodo(Integer[][] matriz){
        List<List<Nodo>> grafo = new ArrayList<>();
                
        for(int i = 0; i < 10; i++){
            grafo.add(new ArrayList<Nodo>());
            for(int j = 0; j < 10; j++){
                if(matriz[i][j] == -1000)
                    grafo.get(i).add(new Nodo((-10),(matriz[i][j]), (i+"x"+j)));
                else
                    grafo.get(i).add(new Nodo(((9-i)+(9-j)),(matriz[i][j]), (i+"x"+j)));
                
            }
            
        }
       return grafo;
    }
    
    private List<List<Nodo>> encadeador(List<List<Nodo>> grafo){
        
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                try{
                    
                    if(grafo.get(i).get(j+1).getCusto() != 1000 ) 
                        grafo.get(i).get(j).setFilhos(grafo.get(i).get(j+1).getThis());
                    
                    if(grafo.get(i+1).get(j).getCusto() != 1000)
                        grafo.get(i).get(j).setFilhos(grafo.get(i+1).get(j).getThis());
                    
                    if(grafo.get(i-1).get(j).getCusto() != 1000)
                        grafo.get(i).get(j).setFilhos(grafo.get(i-1).get(j).getThis());
                    
                    if(grafo.get(i).get(j-1).getCusto() != 1000)
                        grafo.get(i).get(j).setFilhos(grafo.get(i).get(j-1).getThis());
                   
                    
                }catch(Exception e){
                    continue;
                }
                
            }
        }
        
        
        
        return grafo;
    }
        
    public List<List<Nodo>> getGrafo(){
        return this.encadeador(this.geradorNodo(this.geradorNum()));
    }
    public Integer[][] getMatriz(){
        return this.geradorNum();
    }
}
