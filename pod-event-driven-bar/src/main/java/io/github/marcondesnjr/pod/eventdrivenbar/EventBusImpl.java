/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.marcondesnjr.pod.eventdrivenbar;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author José Marcondes do Nascimento Junior
 */
public class EventBusImpl implements EventBus {

    protected Map<String, List<String>> messages = new HashMap<>();
    protected Map<String, List<Subscriber>> subscribers = new HashMap<>();
    
    @Override
    public void subscribe(String topic, String ip, Integer port) {
        //localizar tópico e lista de inscritos
        List<Subscriber> list = subscribers.get(topic);
        if(list == null){
            list = new ArrayList<>();
        }
        //inscreve o novo participante
        list.add(new Subscriber(ip, port));
        System.out.println("Escrito");
    }
    
    @Override
    public void publish(String topic, String message) {
        //localizar o tópico e a lista de mensagens
        List<String> list = messages.get(topic);
        if(list == null){
            list = new ArrayList<>();
        }
        //incluir uma mensagem para a lista de mensagens do tópico
        list.add(message);
        System.out.println("Publicado");
    }
    
    @Override
    public void notify(String ip, Integer port, String topic, String message) {
        try (Socket socket = new Socket(ip, port);) {
            socket.getOutputStream().write((topic + ":" + message).getBytes());
        } catch (IOException ex) {
            Logger.getLogger(EventBusImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
