package com.sdp.bridge;

/** Concrete Implementor #2. */
public class SatelliteLink implements CommunicationLink {
    @Override
    public void connect() {
        System.out.println("[Satellite] Secure satellite channel opened.");
    }

    @Override
    public void send(String data) {
        System.out.println("[Satellite] Transmitting: " + data);
    }

    @Override
    public void disconnect() {
        System.out.println("[Satellite] Satellite channel closed.");
    }

    @Override
    public String getName() {
        return "Satellite Link";
    }
}
