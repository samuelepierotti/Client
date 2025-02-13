/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tcpcommunication_client;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 *
 * @author Amministratore
 */

public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InputStream is;
        Scanner streamIn = null;
        OutputStream os;
        PrintWriter streamOut = null;
        String messaggioIn, messaggioOut;
        
        Client c = new Client("localhost");
        c.connetti("localhost",2000);
        c.chiudi();
        
        
    }
    
}
