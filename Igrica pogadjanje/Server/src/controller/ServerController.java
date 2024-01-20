/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domen.Administrator;
import domen.OdgovorNaPogadjanje;
import domen.Pogadjanje;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Sofija
 */
public class ServerController {
    
    private static ServerController instanca;
    private List<Administrator> listaAdministratora;
    private int matrica [][];
    
    private ServerController(){
        
        listaAdministratora = new LinkedList<>();
        listaAdministratora.add(new Administrator("pera@gmail.com", "123456", "Pera", "Peric"));
        listaAdministratora.add(new Administrator("mara@gmail.com", "654321", "Mara", "Maric"));
        
    }

    public static ServerController getInstanca() {
        if(instanca == null){
            instanca = new ServerController();
        }
        return instanca;
    }

    public void setMatrica(int[][] matrica) {
        this.matrica = matrica;
    }
    
    
    
    public Administrator login(String email, String lozinka) throws Exception{
        for(Administrator administrator: listaAdministratora){
            if(administrator.getEmail().equals(email) && administrator.getLozinka().equals(lozinka)){
                return administrator;
            }
        }
        
        throw new Exception("Pogresni kredencijali");
    }

    public OdgovorNaPogadjanje odgovoriNaPogadjanje(Pogadjanje pogadjanje) {
        int red = pogadjanje.getRed();
        int kolona = pogadjanje.getKolona();
        
        return new OdgovorNaPogadjanje(matrica[red][kolona]);
    }
    
}
