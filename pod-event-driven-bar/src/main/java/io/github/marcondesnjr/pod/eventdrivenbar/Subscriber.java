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
public class Subscriber {
    private String ip;
    private int port;

    public Subscriber(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }
    
    public String getIp() {
        return ip;
    }

    public int getPort() {
        return port;
    }
    
    
}
