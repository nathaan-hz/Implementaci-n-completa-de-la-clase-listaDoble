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
public class ListaDoble {
        private int tamanio;
    private nodoDoble cabeza;
    private nodoDoble cola; 
    
    public ListaDoble(){
        tamanio = 0;
        cabeza=null;
        cola=null;
    }
    
    public boolean estaVacia()
    {
        if(cabeza==null && cola==null)
        {
            return true; 
        }
        else{
            return false;
        }
    }

    /**
     * @return the tamanio
     */
    public int getTamanio() {
        return tamanio;
    }
    
    public boolean buscar (int dato){
        nodoDoble aux = cabeza; 
        while(aux != null)
        {
            if(aux.getDato()==dato)
            {
                return true; 
            }
            aux = aux.getSiguiente();
        }
        return false; 
    }
    
          
    @Override  
    public String toString(){
        String res = "";
        nodoDoble aux = cabeza;
        while (aux != null) // recorre hasta el ultimo nodo 
        {
            res = res + "<-- [" + aux.getDato() + "] -> ";
            aux = aux.getSiguiente();
        }
        res = res + "NULL";
        return res;
    }
    
    // Recorre la lista al reves (de cola a cabeza) usando anterior.
    // Sirve para comprobar que los enlaces hacia atras estan bien.
    public String toStringReversa(){
        String res = "";
        nodoDoble aux = cola;
        while (aux != null)
        {
            res = res + "<-- [" + aux.getDato() + "] -> ";
            aux = aux.getAnterior();
        }
        res = res + "NULL";
        return res;
    }
    
    //Cuenta las posiciones desde 1 
    public nodoDoble obtenerNodo(int pos){
        if(pos <= 0 || pos > tamanio){
            return null;
        }

        nodoDoble aux = cabeza;

        for(int i = 1; i < pos; i++)
        {
            aux = aux.getSiguiente();
        }

        return aux;
    }
    
    public void actualizar(int pos, int dato)
    {
        nodoDoble referencia = obtenerNodo(pos); 
        referencia.setDato(dato);
    }
    
    public void insertarAlinicio(int dato){
        nodoDoble nuevo = new nodoDoble(dato);
        //Caso 1: La lista esta vacia
        if(estaVacia())
        {
            cola = nuevo; 
        }
        else{
            //caso 2: La lista no esta vacia
            nuevo.setSiguiente(cabeza);
            cabeza.setAnterior(nuevo);
        }
        tamanio++;
        cabeza = nuevo; 
    }
    
    
    public void insertarAlFinal(int dato){
        // Creamos nuestro nodo
        nodoDoble nuevo = new nodoDoble(dato);
        // Caso 1: La lista está vacía
        if(estaVacia())
        {
            cabeza = nuevo;
        }
        // Caso 2: La lista tiene elementos
        else
        {
            nuevo.setAnterior(cola);
            cola.setSiguiente(nuevo);  
        }
        tamanio++;
        cola = nuevo;
    }
    
    public int eliminarAlinicio(){
        if(estaVacia())
        {
            throw new IllegalStateException("La lista esta vacia"); 
        }
        int dato = cabeza.getDato();
        
        if(cabeza == cola)
        {
            // solo habia un nodo: la lista queda vacia
            cabeza = null;
            cola = null;
        }
        else
        {
            cabeza = cabeza.getSiguiente(); // la cabeza avanza
            cabeza.setAnterior(null);       // la nueva cabeza ya no apunta hacia atras
        }
        tamanio--; 
        return dato;
    }
    
    public void insertarEnPosicion(int pos, int dato){
        // validamos para no tener NullPointerException
        if(pos < 0 || pos > tamanio)
        {
            System.out.println("Posicion " + pos + " fuera de rango, no se inserto " + dato);
            return;
        }
        
        if(pos == 0)
        {
            insertarAlinicio(dato);   // ya actualiza cabeza, cola y tamanio
            return;
        }
        if(pos == tamanio)
        {
            insertarAlFinal(dato);    // ya actualiza cola y tamanio
            return;
        }
        
        // Caso en medio: el nuevo va antes del nodo que hoy esta en pos
        nodoDoble actual = obtenerNodo(pos + 1);
        nodoDoble previo = actual.getAnterior();
        nodoDoble nuevo = new nodoDoble(dato);
        
        // 1 el nuevo se agarra de sus dos vecinos
        nuevo.setAnterior(previo);
        nuevo.setSiguiente(actual);
        // 2 los vecinos ahora apuntan al nuevo
        previo.setSiguiente(nuevo);
        actual.setAnterior(nuevo);
        
        tamanio++;
    }
    public boolean eliminarUltimo(){
        if(estaVacia())
        {
            return false;
        }
        
        if(cabeza == cola)
        {
            // Caso: un solo nodo, la lista queda vacia
            cabeza = null;
            cola = null;
        }
        else
        {
            cola = cola.getAnterior();  // la cola se regresa al penultimo
            cola.setSiguiente(null);    // el nuevo ultimo ya no apunta a nada
        }
        tamanio--;
        return true;
    }
    
    //Metodos nuevos

    //Elimina la primera vez que aparece el valor x.
    public boolean eliminarPorValor(int x){
        nodoDoble aux = cabeza;
        while(aux != null && aux.getDato() != x)
        {
            aux = aux.getSiguiente();
        }
        if(aux == null)
        {
            return false; // no estaba (o la lista estaba vacia)
        }
        // Caso 1: es la cabeza
        if(aux == cabeza)
        {
            eliminarAlinicio();
        }
        // Caso 2: es la cola
        else if(aux == cola)
        {
            eliminarUltimo();
        }
        // Caso 3: esta en medio, sus vecinos se apuntan entre ellos
        else
        {
            aux.getAnterior().setSiguiente(aux.getSiguiente());
            aux.getSiguiente().setAnterior(aux.getAnterior());
            tamanio--;
        }
        return true;
    }
    
    //Elimina el nodo que esta en la posicion pos (empezando en 0)
    public int eliminarEnPosicion(int pos){
        if(pos < 0 || pos >= tamanio)
        {
            System.out.println("Posicion " + pos + " fuera de rango");
            return -1;
        }
        nodoDoble n = obtenerNodo(pos + 1); 
        int dato = n.getDato();
        if(n == cabeza)
        {
            eliminarAlinicio();
        }
        else if(n == cola)
        {
            eliminarUltimo();
        }
        else
        {
            n.getAnterior().setSiguiente(n.getSiguiente());
            n.getSiguiente().setAnterior(n.getAnterior());
            tamanio--;
        }
        return dato;
    }
    
    //Inserta el dato en su lugar para que la lista quede ordenada de menor a mayor 
    public void insertarOrdenado(int dato){
        // Caso a: lista vacia
        // Caso b: el dato es menor o igual que el primero -> va al inicio
        if(estaVacia() || dato <= cabeza.getDato())
        {
            insertarAlinicio(dato);
            return;
        }
        
        // Caso c: el dato es mayor o igual que el ultimo -> va al final
        if(dato >= cola.getDato())
        {
            insertarAlFinal(dato);
            return;
        }
        
        // Caso d: va en medio. Buscamos el primer nodo mayor o igual al dato
        nodoDoble aux = cabeza;
        while(aux.getDato() < dato)
        {
            aux = aux.getSiguiente();
        }
        
        // el nuevo va justo antes de aux
        nodoDoble previo = aux.getAnterior();
        nodoDoble nuevo = new nodoDoble(dato);
        
        nuevo.setAnterior(previo);
        nuevo.setSiguiente(aux);
        previo.setSiguiente(nuevo);
        aux.setAnterior(nuevo);
        
        tamanio++;
    }
    
    // Muestra quien es la cabeza y la cola 
    public String extremos(){
        String c = (cabeza == null) ? "null" : "" + cabeza.getDato();
        String k = (cola == null) ? "null" : "" + cola.getDato();
        return "cabeza = " + c + ", cola = " + k + ", tamanio = " + tamanio;
    }
}
