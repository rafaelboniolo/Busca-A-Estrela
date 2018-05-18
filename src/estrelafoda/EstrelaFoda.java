/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estrelafoda;

import estrelafoda.view.Tela;
import java.util.List;

/**
 *
 * @author Boniolo
 */
public class EstrelaFoda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeradorMatriz gerador = new GeradorMatriz();
        
       
        new Tela().setVisible(true);
       //new Estrela(gerador.getGrafo()).busca().forEach((x)->{
       //    System.out.println(x);
       // });
        
       //gerador.getGrafo();
    }
    
}
