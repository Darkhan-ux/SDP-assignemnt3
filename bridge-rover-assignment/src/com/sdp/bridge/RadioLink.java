package com.sdp.bridge;

/** Concrete Implementor #1. */
public class RadioLink implements CommunicationLink {
    @Override
    public void connect() {
        System.out.println("[Radio] Connection established.");
    }

    @Override
    public void send(String data) {
        System.out.println("[Radio] Sending: " + data);
    }

    @Override
    public void disconnect() {
        System.out.println("[Radio] Connection closed.");
    }

    @Override
    public String getName() {
        return "Radio Link";
    }
}
