/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estrelafoda;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Boniolo
 */
public class Nodo implements Comparable<Nodo>{
    private Integer heuristica = 0;
    private Integer custo = 0;
    private Integer valor = 0;
    private String id;
    List<Nodo> filhos = new ArrayList<Nodo>();
    private Nodo pai;

    public Nodo(Integer heuristica, Integer custo, String id) {
        this.custo = custo;
        this.heuristica = heuristica;
        this.id = id;
    }

    public Nodo getThis(){
        return this;
    }
    
    public Nodo getPai() {
        return pai;
    }

    public void setPai(Nodo pai) {
        this.pai = pai;
    }

    
    
    public Integer getHeuristica() {
        return heuristica;
    }

    public void setHeuristica(Integer heuristica) {
        this.heuristica = heuristica;
    }

    public Integer getCusto() {
        return custo;
    }

    public void setCusto(Integer custo) {
        this.custo = custo;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Nodo> getFilhos() {
        return filhos;
    }

    public void setFilhos(Nodo filhos) {
        this.filhos.add(filhos);
    }

    @Override
    public int compareTo(Nodo t) {
        if((this.getValor()+this.getHeuristica()) > (t.getValor()+t.getHeuristica()))
            return 1;
        if((this.getValor()+this.getHeuristica()) < (t.getValor()+t.getHeuristica()))
            return -1;
        return 0;               
    }
    
    
}
