/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas;

import Elementos.Tablero;

/**
 *
 * @author Catalin 'uNKoLL' Ciurcanu
 */
public class BuscaMinas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Juego juego = new Juego();
        if(juego!=null){
           juego.jugar();
        }
        
    }
}