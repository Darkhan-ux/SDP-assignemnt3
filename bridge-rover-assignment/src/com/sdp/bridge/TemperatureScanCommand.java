package com.sdp.bridge;

/** Refined Abstraction #2. */
public class TemperatureScanCommand extends RoverCommand {
    private final String area;

    public TemperatureScanCommand(CommunicationLink communicationLink, String area) {
        super(communicationLink);
        this.area = area;
    }

    @Override
    public void execute() {
        communicationLink.connect();
        communicationLink.send("Scan temperature in " + area);
        communicationLink.disconnect();
    }
}
