package com.sdp.bridge;

/**
 * Abstraction in the Bridge pattern.
 * It stores a reference to the Implementor (CommunicationLink).
 */
public abstract class RoverCommand {
    protected CommunicationLink communicationLink;

    protected RoverCommand(CommunicationLink communicationLink) {
        this.communicationLink = communicationLink;
    }

    /**
     * Allows the implementation side of the bridge to be switched at runtime.
     */
    public void setCommunicationLink(CommunicationLink communicationLink) {
        this.communicationLink = communicationLink;
    }

    public abstract void execute();
}
