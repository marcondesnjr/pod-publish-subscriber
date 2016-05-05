/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.marcondesnjr.pod.eventdrivenbar;

/**
 *
 * @author José Marcondes do Nascimento Junior
 */
public interface EventBus {
    void subscribe( String topic, String ip, Integer port);
    void publish(String topic, String message);
    void notify(String ip, Integer port,String topic, String message);
}
