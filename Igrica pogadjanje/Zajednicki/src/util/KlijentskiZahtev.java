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
public class KlijentskiZahtev implements Serializable{
    
    private int operacija;
    private Object podatak;

    public KlijentskiZahtev() {
    }

    public KlijentskiZahtev(int operacija, Object podatak) {
        this.operacija = operacija;
        this.podatak = podatak;
    }

    public int getOperacija() {
        return operacija;
    }

    public void setOperacija(int operacija) {
        this.operacija = operacija;
    }

    public Object getPodatak() {
        return podatak;
    }

    public void setPodatak(Object podatak) {
        this.podatak = podatak;
    }
    
    
}
