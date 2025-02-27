/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tcpcommunication_client;

/**
 *
 * @author Amministratore
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {
    InputStream is;
    Scanner streamIn = null;
    OutputStream os;
    PrintWriter streamOut = null;
    String messaggioIn, messaggioOut;
    String nome;
    String colore;
    public Socket socket = null;

    public static final String BLUE = "\u001B[34m";
    public static final String RESET = "\u001B[0m";

    public Client(String nome){
        this.nome = nome;
    }

    public void connetti(String nomeServer, int portaServer){
        try {
            socket = new Socket(nomeServer, portaServer);
            System.out.println("1) Connessione con il server avvenuta");
            System.out.println(BLUE + "Socket client: " + socket.getLocalSocketAddress() + RESET);
            System.out.println("Socket server: " + socket.getRemoteSocketAddress());
        }
        catch(ConnectException ex){
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Errore di connessione, server non in ascolto");
        } catch (UnknownHostException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Errore nella risoluzione del nome del server");
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Errore nello stabilimento della connessione con il server");
        }
    }

    public void scrivi(){
        try {
            os = socket.getOutputStream();
            streamOut = new PrintWriter(os);
            streamOut.flush();
            messaggioOut = "Ci sono!";
            streamOut.println(messaggioOut);
            streamOut.flush();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Errore a inizializzare lo stream di output");
        }
    }

    public void leggi(){
        try {
            is = socket.getInputStream();
            streamIn = new Scanner(is);
            messaggioIn = streamIn.nextLine();
            System.out.println("Messaggio del server: " + messaggioIn);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Errore nell'inizializzazione dello stream di input");
        }
    }

    public void chiudi(){
        if(socket!=null) {
            try {
                socket.close();
                System.out.println("5) Chiusura connessione avvenuta con successo");
            } catch (IOException e) {
                System.err.println("Errore durante la chiusura del socket");
            }
        }
    }
}
