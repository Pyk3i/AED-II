package aed;

import java.util.*;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    // Agregar atributos privados del Conjunto
    Nodo raiz;
    int cardinal;
    T maximo;
    T minimo;

    private class Nodo {
        // Agregar atributos privados del Nodo
        T valor;
        Nodo izq;
        Nodo der;
        Nodo padre;
        int altura;

        // Crear Constructor del nodo
        Nodo(T v) {
            v = valor;
            izq = null;
            der = null;
            padre = null;
        }
    }

    public ABB() {
        this.raiz = new Nodo(null);
        this.cardinal = 0;
        this.maximo = null;
        this.minimo = null;
    }

    public int cardinal() {
        return cardinal;
    }

    public T minimo(){
        return minimo;
    }

    public T maximo(){
        return maximo;
    }


////////////////////////// REVISAR /////////////////////////////////////// (PUEDE SER LA RAZON DEL ERROR DE INSERTAR_IZQUIERDA)
    public void insertar(T elem){
        Nodo nodoActual = raiz;
        Nodo nuevoNodo = new Nodo(elem);
        int a = 1;
        if (cardinal == 0){
            raiz.valor = elem;
            cardinal = 1;
        }
        if (this.pertenece(elem) != true){
            while(a != 0){
                if (elem.compareTo(nodoActual.valor) > 0 && nodoActual.der.valor != null){
                    nodoActual = nodoActual.der;
                } else if (elem.compareTo(nodoActual.valor) < 0 && nodoActual.izq.valor != null){
                    nodoActual = nodoActual.izq;
                } else if (elem.compareTo(nodoActual.valor) > 0 && nodoActual.der.valor == null){
                    nodoActual.der = nuevoNodo;
                    nodoActual.der.padre = nodoActual;
                    cardinal += 1;
                    a += 1;
                } else if (elem.compareTo(nodoActual.valor) < 0 && nodoActual.izq.valor == null){
                    nodoActual.izq = nuevoNodo;
                    nodoActual.izq.padre = nodoActual;
                    cardinal += 1;
                    a += 1;
                }
            }
            // Compara maximo y minimo con elem y lo cambia de ser necesario
            if (nuevoNodo.valor.compareTo(maximo) > 0 || maximo == null){
                maximo = elem;
            } else if (elem.compareTo(minimo) < 0 || minimo == null){
                minimo = elem;
            }
        }
    }
    //////////////////////////////  REVISAR //////////////////////////////// (PUEDE SER LA CAUSE DEL ERROR INSERTAR_IZQUIERDA)
    public boolean pertenece(T elem){ 
        Nodo nodoActual = raiz;
        while (true){
            if(nodoActual.valor == null) {
                return false;
            } else if (elem.compareTo(nodoActual.valor) == 0){
                return true;
            } else if (nodoActual.valor.compareTo(null) == 0){
                return false;
            } else if (elem.compareTo(nodoActual.valor) > 0){
                nodoActual = nodoActual.der;
            } else if (elem.compareTo(nodoActual.valor) < 0){
                nodoActual = nodoActual.izq;
            }
        }
    }

    public void eliminar(T elem){
        throw new UnsupportedOperationException("No implementada aun");
    }

    public String toString(){
        throw new UnsupportedOperationException("No implementada aun");
    }

    private class ABB_Iterador implements Iterador<T> {
        private Nodo _actual;

        public boolean haySiguiente() {            
            throw new UnsupportedOperationException("No implementada aun");
        }
    
        public T siguiente() {
            throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

}
