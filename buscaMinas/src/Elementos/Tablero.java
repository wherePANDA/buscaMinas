/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementos;

import java.util.Random;

/**
 *
 * @author Catalin 'uNKoLL' Ciurcanu
 */
public class Tablero {
    private int numFilas;
    private int numColumnas;
    private int numMinas;
    private Casilla[][] tabla;
    /**
     * Constructor que inicializa ma matriz tabla
     * @param numFilas
     * @param numColumnas 
     */
    public Tablero(int numFilas, int numColumnas) {
        this.numFilas = numFilas;
        this.numColumnas = numColumnas;
        this.numMinas = 0;
        this.tabla = new Casilla[numFilas][numColumnas];
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla[i].length; j++) {
                tabla[i][j] = new Casilla();
            }
        }
    }
    /**
     * Metodo que inserta las minas aleatoriamente
     * @param minas 
     */
    public void insertarMinas(int minas){
        Random r = new Random();
        int numAleatorio1;
        int numALeatorio2;
        while(minas>0){
            numAleatorio1 = r.nextInt(this.numFilas);
            numALeatorio2 = r.nextInt(this.numColumnas);
            tabla[numAleatorio1][numALeatorio2].setMina(true);
            minas--;
        }
    }
    /**
     * Metodo que imprime el tablero
     */
    public void imprimirPrueba(){
        System.out.print("\u001B[31m0|");
        for (int i = 0; i <= tabla.length-1; i++) {
            System.out.print("\u001B[31m"+i+" \u001B[0m");
        }
        System.out.print("\u001B[31m|0 ");
        System.out.println("");
        int contador=0;
        for (int i = 0; i < tabla.length; i++) {
            System.out.print("\u001B[31m"+contador+"|"+"\u001B[0m");
            for (int j = 0; j < tabla[i].length; j++) {
                System.out.print(tabla[i][j]);
            }
            System.out.print("\u001B[31m|"+contador+"\u001B[0m");
            contador++;
            System.out.println("");
        }
        System.out.print("\u001B[31m0|");
        for (int i = 0; i <= tabla.length-1; i++) {
            System.out.print("\u001B[31m"+i+" \u001B[0m");
        }
        System.out.print("\u001B[31m|0 ");
        System.out.println("");
    }
    
    /**
     * Método que calcula el numero de minas que hay alrededor
     * @param fila
     * @param columna
     * @return 
     */
    public int calcularMinasCasilla(int fila, int columna){
        int num=0;
        for (int i = fila-1; i <= fila+1; i++) {
            if(i>=0 && i<numFilas){
                for (int j = columna-1; j <= columna+1; j++) {
                    if(j>=0 && j<numColumnas && tabla[i][j].isMina()){
                        num++;
                    }
                }
            }
            
        }
        return num;
    }
    
    /**
     * Método que devuelve una casilla de la matriz tabla
     * @author Catalin Ciurcanu
     * @version 1
     * @param fila fila de la matriz
     * @param columna columna de la matriz
     * @return devuelve la casilla de tabla
     */
    public Casilla getCasilla(int fila, int columna){
        return this.tabla[fila][columna];
    }
    
    /**
     * Haciendo uso del metodo getMinas casilla introduce en el tablero
     * las casillas con numeros (minas que hay alrededor).
     */
    public void calcularTablero(){
        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numColumnas; j++) {
                if(!tabla[i][j].isMina()){
                    tabla[i][j].setNumero(calcularMinasCasilla(i, j));
                }
            }
        }
    }
}
