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
    }
    public void configurarJuego(){
        System.out.println("Introduce numFilas, Columnas y Minas");
        Scanner leer = new Scanner(System.in);
        
    }
    
    public void jugar(){
        
    }
    
    private void mostrarTablero(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                
            }
        }
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
