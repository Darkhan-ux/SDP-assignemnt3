package com.sdp.bridge;

/** Refined Abstraction #1. */
public class PhotoCommand extends RoverCommand {
    private final String target;

    public PhotoCommand(CommunicationLink communicationLink, String target) {
        super(communicationLink);
        this.target = target;
    }

    @Override
    public void execute() {
        communicationLink.connect();
        communicationLink.send("Capture photo of " + target);
        communicationLink.disconnect();
    }
}
