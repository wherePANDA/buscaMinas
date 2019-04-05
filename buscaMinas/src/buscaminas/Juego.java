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
    }
    
    public void jugar(){
        Scanner leer=new Scanner(System.in);
        do{
            tablero.insertarMinas(numMinas);
            mostrarTablero();
            int opc=elegirOperacion();
            switch(opc){
                case 1: 
                    int fil,column;
                    System.out.println("Introduce las coordenadas");
                    System.out.print("Fila: ");
                    fil = leer.nextInt();
                    System.out.print("Columna: ");
                    column = leer.nextInt();
                    
                    tablero.getCasilla(fil, column).setBlanco(true);
                    tablero.calcularMinasCasilla(fil, column);
                    tablero.calcularTablero();
                    tablero.getCasilla(fil, column).setVisible(true);
                    

                    break;
                case 2: 
                    System.out.println("Introduce las coordenadas");
                    System.out.print("Fila: ");
                    fil = leer.nextInt();
                    System.out.print("Columna: ");
                    column = leer.nextInt();
                    tablero.getCasilla(fil, column).setBandera(true);
                    break;
                case 3: 
                    break;
            }
        }while(!partidaGanada());
    }
    
    private void mostrarTablero(){
        tablero.insertarMinas(numMinas);
        tablero.imprimirPrueba();
    }
    
    private int elegirOperacion(){
        int opc=0;
        Scanner leer=new Scanner(System.in);
        System.out.println("Elige una opcion:");
        System.out.println("1. Descubrir");
        System.out.println("2. Poner Bandera");
        System.out.println("3. Quitar Bandera");
        opc = leer.nextInt();
        return opc;
    }
    
    private boolean coordenadasCorrectas(int fila, int columna){
        Scanner leer = new Scanner(System.in);
        boolean filas=false, columnas = false, estado=false;
        try{
            do{
                while(fila>this.numFilas){
                    System.out.print("Error Filas: ");
                    fila = leer.nextInt();
                    if(fila<this.numFilas){
                        filas = true;
                    }
                }
                while(columna>this.numColumnas){
                    System.out.print("Error columnas: ");
                    columna = leer.nextInt();
                    if(columna<this.numColumnas){
                        columnas = true;
                    }
                }
                if(filas && columnas){
                    estado=true;
                }
            }while(filas==false || columnas==false);
        } catch(java.util.InputMismatchException letraIntroducida){
            System.out.println("--=[Has introducido una letra]=--");
        } catch(Exception ex){
            System.out.println("Error general");
        }
        return estado;
    }
    
    private void acabarJuegoMina(){
        System.out.println("Juego finalizado, has pisado una mina");
    }
    
    private boolean descubrirCasilla(int fila, int columna){
        tablero.getCasilla(fila, columna);
        return true;
    }
    
    private void descubrirBlanco(int fila, int columna){
        
    }
    
    private boolean partidaGanada(){
        boolean victoria;
        return false;
    }
}
