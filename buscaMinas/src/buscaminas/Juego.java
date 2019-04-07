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
        boolean perdido = false;
        tablero.insertarMinas(numMinas);
        do{
            tablero.calcularTablero();
            mostrarTablero();
            int opc=elegirOperacion();
            int fil=0,column= 0;
            switch(opc){
                case 1: 
                    System.out.println("Introduce las coordenadas");
                    System.out.print("Fila: ");
                    fil = leer.nextInt();
                    System.out.print("Columna: ");
                    column = leer.nextInt();
                    
                    descubrirCasilla(fil, column);
                    
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
            if(!descubrirCasilla(fil, column)){
                acabarJuegoMina();
                perdido=true;
            }
        }while(!partidaGanada() && !perdido);
    }
    
    private void mostrarTablero(){
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
            }while(!estado);
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
        if(tablero.getCasilla(fila, columna).isMina()){
            return false;
        }
        else if(tablero.getCasilla(fila, columna).isBandera()){
            System.out.println("No puedes descubrir una bandera");
        }
        else if(tablero.getCasilla(fila, columna).isVisible()){
            System.out.println("Ya está visible");
        }
        else{
            tablero.getCasilla(fila, columna).setVisible(true);
            tablero.getCasilla(fila, columna).setBlanco(true);
            if (tablero.getCasilla(fila, columna).isBlanco() && !(tablero.getCasilla(fila, columna).getNumero()>0) ) {
                descubrirBlanco(fila, columna);
            }
        }
        return true;
    }
    
    private void descubrirBlanco(int fila, int columna){
        
    }
    
    private boolean partidaGanada(){
        boolean victoria=false;
        int acierto=0;
        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numColumnas; j++) {
                if(tablero.getCasilla(i, j).isMina() && tablero.getCasilla(i, j).isBandera()){
                    acierto++;
                }
            }
        }
        if(acierto==numMinas){
            System.out.println("JUEGO TERMINADO");
            victoria = true;
        }else{
            victoria = false;
        }
        
        return victoria;
    }
}
