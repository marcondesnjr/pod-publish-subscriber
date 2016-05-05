/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.marcondesnjr.pod.eventdrivenbar;

import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author José Marcondes do Nascimento Junior
 */
public class TaskManager extends Thread {

    private final EventBus eventBus;

    public TaskManager(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5 * 1000);
                task();
            } catch (InterruptedException ex) {
                Logger.getLogger(TaskManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void task() {
        EventBusImpl e = (EventBusImpl) eventBus;
        //recuperar a lista de tópicos
        Set<String> topics = e.messages.keySet();
        //recuperar a lista de inscritos (por topico)
        for (String t : topics) {
            List<Subscriber> s = e.subscribers.get(t);
            if (s != null && s.size() > 0) {
                //recuperar a smensagens(por tópico)
                List<String> m = e.messages.get(t);
                if (m != null && m.size() > 0) {
                    for (Subscriber sub : s) {
                        for (String message : m) {
                            //no final, notificar
                            eventBus.notify(sub.getIp(), sub.getPort(), t, message);
                        }
                    }
                }
            }
        }
    }

}
