/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.marcondesnjr.pod.eventdrivenbar;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author José Marcondes do Nascimento Junior
 */
public class Main {

    public static void main(String[] args) throws IOException {
        //criando o barramento de eventos
        EventBus eventBus = new EventBusImpl();
        //criando gerenciador de tarefa
        TaskManager manager = new TaskManager(eventBus);
        //inicializando o gerenciamento de tarefas
        manager.start();
        try (ServerSocket serverSocket = new ServerSocket(10997);) {
            //execução infinita
            while (true) {
                byte[] b = new byte[1024];
                try (Socket client = serverSocket.accept();) {
                    //
                    client.getInputStream().read(b);
                    //
                }
                String xmessage = new String(b).trim();
                //protocolo de comunicação(formato da mensagem)
                //<action>:<topic>:<message> --> action=publish
                //<action>:<topic>:<ip>:<port> --> action = subscribe
                String[] xm = xmessage.split(":");
                
                if("publish".equals(xm[0])){
                    eventBus.publish(xm[1], xm[2]);
                }else{
                    eventBus.subscribe(xm[1], xm[2] , Integer.parseInt(xm[3]));
                }
            }
        }

    }
}
