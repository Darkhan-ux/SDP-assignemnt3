package com.sdp.bridge;

/**
 * Implementor in the Bridge pattern.
 * Defines low-level communication operations used by rover commands.
 */
public interface CommunicationLink {
    void connect();
    void send(String data);
    void disconnect();
    String getName();
}
