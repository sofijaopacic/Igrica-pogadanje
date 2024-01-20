/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.io.Serializable;

/**
 *
 * @author Sofija
 */
public class Pogadjanje implements Serializable{
    
    private int red;
    private int kolona;

    public Pogadjanje() {
    }

    public Pogadjanje(int red, int kolona) {
        this.red = red;
        this.kolona = kolona;
    }

    public int getKolona() {
        return kolona;
    }

    public void setKolona(int kolona) {
        this.kolona = kolona;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }
    
    
}
