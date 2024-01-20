/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nit;

import forme.GlavnaForma;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sofija
 */
public class ServerNit extends Thread {

    private ServerSocket serverSocket;
    private GlavnaForma glavnaForma;
    private List<KlijentNit> listaNiti;

    public ServerNit(GlavnaForma glavnaForma) throws IOException {
        this.glavnaForma = glavnaForma;
        serverSocket = new ServerSocket(10000);
        listaNiti = new LinkedList<>();
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                Socket socket = serverSocket.accept();
                KlijentNit klijentNit = new KlijentNit(socket, glavnaForma);
                klijentNit.start();
                listaNiti.add(klijentNit);
            }
        }catch(Exception ex){
        }

    }
    
    
    public void zaustaviServer(){
        try {
            
            for(KlijentNit klijentNit: listaNiti){
                klijentNit.zaustaviKlijentNit();
            }
            serverSocket.close();
            
        } catch (IOException ex) {
            
        }
    }
    

}
