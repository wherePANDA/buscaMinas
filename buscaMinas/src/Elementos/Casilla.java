/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementos;

/**
 *
 * @author Catalin 'uNKoLL' Ciurcanu
 */
public class Casilla {
    private boolean mina;
    private boolean blanco;
    private boolean bandera;
    private boolean visible;
    private int numero;

    
    public Casilla(){
        this.mina = false;
        this.blanco = false;
        this.bandera = false;
        this.visible = false;
        this.numero = 0;
    }

    @Override
    public String toString() {
        /*String omitirCero="";
        if(getNumero()==0){
            omitirCero="-";
        }else{
            omitirCero=String.valueOf(getNumero());
        }*/
        if (bandera){
            return "X ";
        }
        
        if (mina){
            return "\u001B[31mM \u001B[0m";
        }
        
        if (numero>0)
            return Integer.toString(numero)+" ";
        
        return "- ";
    }

    /**
     * @return the mina
     */
    public boolean isMina() {
        return mina;
    }

    /**
     * @param mina the mina to set
     */
    public void setMina(boolean mina) {
        this.mina = mina;
    }

    /**
     * @return the blanco
     */
    public boolean isBlanco() {
        return blanco;
    }

    /**
     * @param blanco the blanco to set
     */
    public void setBlanco(boolean blanco) {
        this.blanco = blanco;
    }

    /**
     * @return the bandera
     */
    public boolean isBandera() {
        return bandera;
    }

    /**
     * @param bandera the bandera to set
     */
    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }

    /**
     * @return the visible
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     * @param visible the visible to set
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    
}
