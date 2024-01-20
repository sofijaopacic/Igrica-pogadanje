/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nit;

import controller.ServerController;
import domen.OdgovorNaPogadjanje;
import domen.Pogadjanje;
import forme.GlavnaForma;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.KlijentskiZahtev;
import util.Operacije;
import util.ServerskiOdgovor;

/**
 *
 * @author Sofija
 */
public class KlijentNit extends Thread {

    private Socket socket;
    private GlavnaForma glavnaForma;
    private int brojPokusaja = 0;
    private int brojTacnih = 0;

    public KlijentNit(Socket socket, GlavnaForma glavnaForma) {
        this.socket = socket;
        this.glavnaForma = glavnaForma;
    }

    @Override
    public void run() {

        try {
            while (!isInterrupted()) {
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                KlijentskiZahtev klijentskiZahtev = (KlijentskiZahtev) in.readObject();

                ServerskiOdgovor serverskiOdgovor = obradiZahtev(klijentskiZahtev);
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(serverskiOdgovor);

                if (brojTacnih == 3) {
                    // logika za gasenje i pokretanje
                    glavnaForma.zasutaviIgru();
                }
                
                if(brojPokusaja == 5){
                    glavnaForma.zasutaviIgru();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private ServerskiOdgovor obradiZahtev(KlijentskiZahtev klijentskiZahtev) {
        ServerskiOdgovor serverskiOdgovor = new ServerskiOdgovor();

        try {
            switch (klijentskiZahtev.getOperacija()) {
                case Operacije.POGODI:

                    brojPokusaja++;
                    Pogadjanje pogadjanje = (Pogadjanje) klijentskiZahtev.getPodatak();
                    OdgovorNaPogadjanje odgovorNaPogadjanje = ServerController.getInstanca().odgovoriNaPogadjanje(pogadjanje);

                    if (odgovorNaPogadjanje.getBroj() != -1) {
                        brojTacnih++;
                    }

                    serverskiOdgovor.setPodatak(odgovorNaPogadjanje);

                    break;
            }
        } catch (Exception ex) {
            serverskiOdgovor.setGreska(ex);
        }

        return serverskiOdgovor;
    }

    void zaustaviKlijentNit() {
        try {
            socket.close();
        } catch (IOException ex) {
        }
    }

}
