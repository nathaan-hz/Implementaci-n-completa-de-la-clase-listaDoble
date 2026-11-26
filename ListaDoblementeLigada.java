/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.listadoblementeligada;

/**
 *
 * @author Nathan Hazael Merenciano Hernandez
 * PRACTICA: Implementación completa de la clase listaDoble
 */
public class ListaDoblementeLigada {
    
    // Imprime la lista hacia adelante, hacia atras y sus extremos
    static void mostrar(ListaDoble l){
        System.out.println("  Adelante: " + l);
        System.out.println("  Atras:    " + l.toStringReversa());
        System.out.println("  " + l.extremos());
    }


    public static void main(String[] args) {
        ListaDoble lista = new ListaDoble();

        //Insertar ordenado
        System.out.println("Insertar ordenado");
        System.out.println("");
        int[] valores = {25, 10, 40, 30, 10, 3, 99, 20};
        for (int v : valores) {
            lista.insertarOrdenado(v);
            System.out.println("insertarOrdenado(" + v + "): " + lista);
        }
        System.out.println("Resultado en ambos sentidos:");
        mostrar(lista);

        System.out.println("");
        //Insertar en posicion
        System.out.println("Insertar en posicion");
        System.out.println("");
        System.out.println("insertarEnPosicion(0, 1) -> al inicio");
        lista.insertarEnPosicion(0, 1);
        mostrar(lista);
        System.out.println("insertarEnPosicion(4, 15) -> en medio");
        lista.insertarEnPosicion(4, 15);
        mostrar(lista);
        System.out.println("insertarEnPosicion(" + lista.getTamanio() + ", 100) -> al final");
        lista.insertarEnPosicion(lista.getTamanio(), 100);
        mostrar(lista);
        System.out.println("insertarEnPosicion(-1, 7) y (50, 7) -> invalidas");
        lista.insertarEnPosicion(-1, 7);
        lista.insertarEnPosicion(50, 7);
        mostrar(lista);

        System.out.println("");
        //Eliminar por valor
        System.out.println("Eliminar por valor");
        System.out.println("");
        System.out.println("eliminarPorValor(1) (cabeza) -> " + lista.eliminarPorValor(1));
        mostrar(lista);
        System.out.println("eliminarPorValor(100) (cola) -> " + lista.eliminarPorValor(100));
        mostrar(lista);
        System.out.println("eliminarPorValor(25) (medio) -> " + lista.eliminarPorValor(25));
        mostrar(lista);
        System.out.println("eliminarPorValor(10) (repetido, borra solo uno) -> " + lista.eliminarPorValor(10));
        mostrar(lista);
        System.out.println("eliminarPorValor(77) (no existe) -> " + lista.eliminarPorValor(77));
        mostrar(lista);

        System.out.println("");
        //Eliminar en posicion
        System.out.println("Eliminar en posicion");
        System.out.println("");
        System.out.println("eliminarEnPosicion(0) (inicio) -> regreso " + lista.eliminarEnPosicion(0));
        mostrar(lista);
        int ultima = lista.getTamanio() - 1;
        System.out.println("eliminarEnPosicion(" + ultima + ") (final) -> regreso " + lista.eliminarEnPosicion(ultima));
        mostrar(lista);
        System.out.println("eliminarEnPosicion(2) (medio) -> regreso " + lista.eliminarEnPosicion(2));
        mostrar(lista);
        System.out.println("eliminarEnPosicion(-1):");
        System.out.println("  regreso " + lista.eliminarEnPosicion(-1));
        System.out.println("eliminarEnPosicion(" + lista.getTamanio() + ") (pos == tamanio):");
        System.out.println("  regreso " + lista.eliminarEnPosicion(lista.getTamanio()));
        mostrar(lista);

        System.out.println("");
        //Eliminar ultimo
        System.out.println("Eliminar ultimo");
        System.out.println("");
        while (!lista.estaVacia()) {
            System.out.println("eliminarUltimo() -> " + lista.eliminarUltimo());
            mostrar(lista);
        }
        System.out.println("eliminarUltimo() con lista vacia -> " + lista.eliminarUltimo());
        
        System.out.println("");
        //Casos borde
        System.out.println("Casos borde");
        System.out.println("");
        System.out.println("eliminarPorValor(5) en vacia -> " + lista.eliminarPorValor(5));
        System.out.println("eliminarEnPosicion(0) en vacia:");
        System.out.println("  regreso " + lista.eliminarEnPosicion(0));
        System.out.println("insertarEnPosicion(0, 42) en vacia:");
        lista.insertarEnPosicion(0, 42);
        mostrar(lista);
        System.out.println("eliminarEnPosicion(0) con un solo elemento -> regreso " + lista.eliminarEnPosicion(0));
        mostrar(lista);
        System.out.println("insertarOrdenado(8) en vacia:");
        lista.insertarOrdenado(8);
        mostrar(lista);
        System.out.println("eliminarPorValor(8) con un solo elemento -> " + lista.eliminarPorValor(8));
        mostrar(lista);

        System.out.println();


    }
}
