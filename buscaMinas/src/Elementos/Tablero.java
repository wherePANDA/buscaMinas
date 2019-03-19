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

    public Tablero(int numFilas, int numColumnas) {
        this.numFilas = numFilas;
        this.numColumnas = numColumnas;
        this.numMinas = 0;
        this.tabla = new Casilla[numFilas][numColumnas];
    }

    public void insertarMinas(int minas){
        Random r = new Random();
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla[i].length; j++) {
                int aleatorio = r.nextInt();
                tabla[i][j] = new Casilla();
            }
        }
    }
    
    public void imprimirPrueba(){
        System.out.println("\u001B[31m0|1 2 3 4 5 6 |0 ");
        int contador=1;
        for (int i = 0; i < tabla.length; i++) {
            System.out.print("\u001B[31m"+contador+"|"+"\u001B[0m");
            for (int j = 0; j < tabla[i].length; j++) {
                if(tabla[i][j].isMina()){
                    System.out.print("x ");
                }else{
                    System.out.print(tabla[i][j].toString()+" ");
                }
                
            }
            System.out.print("\u001B[31m|"+contador+"\u001B[0m");
            contador++;
            System.out.println("");
        }
        System.out.println("\u001B[31m0|0 1 2 3 4 5 |6");
    }
}
