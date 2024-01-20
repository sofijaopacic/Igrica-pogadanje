/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domen.OdgovorNaPogadjanje;
import domen.Pogadjanje;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import util.KlijentskiZahtev;
import util.Operacije;
import util.ServerskiOdgovor;

/**
 *
 * @author Sofija
 */
public class ClientController {
    
    private Socket socket;
    
    private static ClientController instanca;
    
    private ClientController() throws IOException{
        socket = new Socket("localhost", 10000);
    }

    public static ClientController getInstanca() throws IOException {
        if(instanca == null){
            instanca = new ClientController();
        }
        return instanca;
    }
    
    public OdgovorNaPogadjanje pogodi(Pogadjanje pogadjanje) throws Exception {
        return (OdgovorNaPogadjanje) posaljiZahtevServeru(Operacije.POGODI, pogadjanje);
    }
    
    private Object posaljiZahtevServeru(int operacija, Object podatak) throws Exception{
        KlijentskiZahtev klijentskiZahtev = new KlijentskiZahtev(operacija, podatak);
        
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(klijentskiZahtev);
        
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        ServerskiOdgovor serverskiOdgovor = (ServerskiOdgovor) in.readObject();
        
        if(serverskiOdgovor.getGreska()!=null){
            throw serverskiOdgovor.getGreska();
        }
        
        return serverskiOdgovor.getPodatak();
        
    }

    
    
}
