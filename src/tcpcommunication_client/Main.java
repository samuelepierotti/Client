/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tcpcommunication_client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.net.Socket;

/**
 *
 * @author Amministratore
 */

public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args, Socket socket) {
        InputStream is;
        Scanner streamIn = null;
        OutputStream os;
        PrintWriter streamOut = null;
        String messaggioIn, messaggioOut;

        try {
            Client c = new Client("localhost");
            c.connetti("localhost",2000);
            
            os = socket.getOutputStream();
            streamOut = new PrintWriter(os);
            streamOut.flush();
            is = socket.getInputStream();
            streamIn = new Scanner(is);
            messaggioIn = streamIn.nextLine();
            System.out.println("Messaggio del server: " + messaggioIn);
            messaggioOut = "Ci sono!";
            streamOut.println(messaggioOut);
            streamOut.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


        c.chiudi();
        
    }
    
}
