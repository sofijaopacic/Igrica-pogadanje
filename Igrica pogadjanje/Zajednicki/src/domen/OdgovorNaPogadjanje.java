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
public class OdgovorNaPogadjanje implements Serializable{
    private int broj;

    public OdgovorNaPogadjanje() {
    }

    public OdgovorNaPogadjanje(int broj) {
        this.broj = broj;
    }

    public int getBroj() {
        return broj;
    }

    public void setBroj(int broj) {
        this.broj = broj;
    }
    
    
}
