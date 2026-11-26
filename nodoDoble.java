/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.listadoblementeligada;

/**
 *
 * @author Nathan Hazael Merenciano Hernandez
 * PRACTICA: Implementación completa de la clase listaDoble
 */
public class nodoDoble {
      private int dato;
    private nodoDoble siguiente;
    private nodoDoble anterior;//nuevo
    
    public nodoDoble (int x){
        dato = x;
        siguiente=null;
        anterior=null; 
    }

    /**
     * @return the dato
     */
    public int getDato() {
        return dato;
    }

    /**
     * @param dato the dato to set
     */
    public void setDato(int dato) {
        this.dato = dato;
    }

    /**
     * @return the siguiente
     */
    public nodoDoble getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(nodoDoble siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * @return the anterior
     */
    public nodoDoble getAnterior() {
        return anterior;
    }

    /**
     * @param anterior the anterior to set
     */
    public void setAnterior(nodoDoble anterior) {
        this.anterior = anterior;
    }
    
}
