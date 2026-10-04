package com.sdp.bridge;

/** Client: composes abstractions with implementations at runtime. */
public class Main {
    public static void main(String[] args) {
        CommunicationLink radio = new RadioLink();
        CommunicationLink satellite = new SatelliteLink();

        RoverCommand photoCommand = new PhotoCommand(radio, "Sector A-17");
        RoverCommand temperatureCommand = new TemperatureScanCommand(satellite, "Crater North");

        System.out.println("=== Initial combinations ===");
        photoCommand.execute();
        System.out.println();
        temperatureCommand.execute();

        System.out.println("\n=== Runtime implementation switch ===");
        photoCommand.setCommunicationLink(satellite);
        photoCommand.execute();
    }
}
