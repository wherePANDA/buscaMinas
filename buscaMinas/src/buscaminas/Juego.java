/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas;

import Elementos.Tablero;
import java.util.Scanner;

/**
 *
 * @author Catalin 'uNKoLL' Ciurcanu
 */
public class Juego {
    private Tablero tablero;
    private int numMinas;
    private int numFilas;
    private int numColumnas;

    public Juego() {
        configurarJuego();
    }
    
    public void configurarJuego(){
        Scanner leer;
        int numColumnas=0,numFilas=0,numMinas=0;
        do{
            try{
                leer = new Scanner(System.in);
                System.out.println("Introduce el número de Filas");
                numFilas = leer.nextInt();
                System.out.println("Introduce el número de Columnas");
                numColumnas = leer.nextInt();
                System.out.println("Introduce el número de Minas");
                numMinas = leer.nextInt();
            } catch(java.util.InputMismatchException letraIntroducida){
                System.out.println("--=[Has introducido una letra]=--");
            } catch(Exception ex){
                System.out.println("Error general");
            }
        }while(numColumnas==0 || numFilas==0);
        this.numColumnas = numColumnas;
        this.numFilas = numFilas;
        this.numMinas = numMinas;
        this.tablero = new Tablero(numFilas, numColumnas);
        mostrarTablero();
    }
    public void jugar(){
        
    }
    
    private void mostrarTablero(){
        tablero.insertarMinas(numMinas);
        tablero.imprimirPrueba();
    }
    
    private int elegirOperacion(){
        int opc=0;
        
        
        return opc;
    }
    
    private void acabarJuegoMina(){
        System.out.println("Juego finalizado, has pisado una mina");
    }
    
    private boolean descubrirCasilla(int fila, int columna){
        return true;
    }
    
    private void descubrirBlanco(int fila, int columna){
        
    }
    
    private boolean partidaGanada(){
        return false;
    }
}
