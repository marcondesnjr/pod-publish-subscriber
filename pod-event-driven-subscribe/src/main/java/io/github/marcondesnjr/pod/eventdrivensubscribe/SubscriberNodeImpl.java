/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.marcondesnjr.pod.eventdrivensubscribe;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author José Marcondes do Nascimento Junior
 */
public class SubscriberNodeImpl implements SubscriberNode{

    @Override
    public void subscribe(String topic) {
        try(Socket socket = new Socket("localhost", 10997);){
            socket.getOutputStream().write("subscribe:t1:127.0.0.1:10998".getBytes());
        } catch (IOException ex) {
            Logger.getLogger(SubscriberNodeImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
