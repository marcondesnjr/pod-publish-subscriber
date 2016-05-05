/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.marcondesnjr.pod.eventdrivensubscribe;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author José Marcondes do Nascimento Junior
 */
public class Main {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(10998);) {
            while (true) {
                //criando um server socket
                try (Socket socket = serverSocket.accept();) {
                    byte[] b = new byte[1024];
                    socket.getInputStream().read(b);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
