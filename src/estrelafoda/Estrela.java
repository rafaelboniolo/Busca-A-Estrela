/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estrelafoda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Boniolo
 */
public class Estrela {
    
    private List<List<Nodo>> grafo;
    private int i = 0;
    
    public Estrela(List<List<Nodo>> grafo){
        this.grafo = grafo;
    }

    public List<List<Nodo>> getGrafo() {
        return grafo;
    }

    public int getI() {
        return i;
    }
    
    
    
    public List<String> busca(String destino){
        List<Nodo> aberta = new ArrayList<>();
        List<Nodo> fechada = new ArrayList<>();
        List<String> caminho = new ArrayList<>();
        
       
        Nodo inicial = this.grafo.get(0).get(0);
       
        
        aberta.add(inicial);
        
        
        Nodo atual = aberta.get(0);
        
        while (true){
            
            if(atual.getId().equals(destino)){//destino)){
               
               while(true){
                    //System.out.println(atual.getValor());
                    caminho.add(atual.getId());
                    atual = atual.getPai();
                    
                    if(atual.getId().equals("0x0")){
                        Collections.reverse(caminho);
                        aberta = new ArrayList<>();
                        fechada = new ArrayList<>();
                        atual = grafo.get(0).get(0);
                        
                        System.out.println(this.i);
                        return caminho;
                    }
                }
           }
            
         
            for(Nodo x : atual.getFilhos()){
                if(fechada.contains(x))
                    continue;
                this.i++;
                x.setPai(atual);
                x.setValor(x.getCusto() + atual.getValor());
                aberta.add(x);
            }
               
               fechada.add(atual);
                aberta.remove(atual);
                System.out.println("");
                
                if(aberta.isEmpty() ){
                    
                    JOptionPane.showMessageDialog(null, "Caminho Impossivel");
                    caminho.add(this.grafo.get(0).get(0).getId());
                    return caminho;
                }
                
             
                Collections.sort(aberta);
                atual = aberta.get(0);
            
    
        }
        
    }
    
}
