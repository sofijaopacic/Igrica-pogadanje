/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.Serializable;

/**
 *
 * @author Sofija
 */
public class ServerskiOdgovor implements Serializable{
    
    private Object podatak;
    private Exception greska;

    public ServerskiOdgovor() {
    }

    public ServerskiOdgovor(Object podatak, Exception greska) {
        this.podatak = podatak;
        this.greska = greska;
    }

    public Exception getGreska() {
        return greska;
    }

    public void setGreska(Exception greska) {
        this.greska = greska;
    }

    public Object getPodatak() {
        return podatak;
    }

    public void setPodatak(Object podatak) {
        this.podatak = podatak;
    }
    
    
}
