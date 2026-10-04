# Assignment #3 — Bridge Pattern

## Topic
**Mars Rover Command System**

The program separates two independent dimensions:

1. **Rover commands** — what the rover should do.
2. **Communication links** — how the command is transmitted.

This is implemented with the **Bridge structural design pattern**.

## Bridge Pattern Roles

| Assignment role | Class/interface in this project |
|---|---|
| Abstraction | `RoverCommand` |
| Refined Abstraction | `PhotoCommand`, `TemperatureScanCommand` |
| Implementor | `CommunicationLink` |
| Concrete Implementor | `RadioLink`, `SatelliteLink` |
| Client | `Main` |

`RoverCommand` contains a reference to `CommunicationLink`, which creates the bridge between the abstraction hierarchy and the implementation hierarchy.

## Why Bridge is useful here

Without Bridge, we could end up creating combinations such as `RadioPhotoCommand`, `SatellitePhotoCommand`, `RadioTemperatureScanCommand`, and `SatelliteTemperatureScanCommand`.

With Bridge, command types and communication technologies can be extended independently. For example, we can add a new `NavigationCommand` without changing `RadioLink` or `SatelliteLink`, and we can add a new `LaserLink` without changing the existing command classes.

## Runtime switching

The client can switch the implementation without changing the abstraction:

```java
RoverCommand photoCommand = new PhotoCommand(new RadioLink(), "Sector A-17");
photoCommand.execute();

photoCommand.setCommunicationLink(new SatelliteLink());
photoCommand.execute();
```

The `PhotoCommand` object remains the same abstraction while its communication implementation changes at runtime.

## Clean Code Principles

### 1. Separation of responsibilities
`RoverCommand` classes describe command behavior, while `CommunicationLink` classes handle transmission. The two responsibilities are not mixed.

### 2. Meaningful names
Names such as `RoverCommand`, `CommunicationLink`, `PhotoCommand`, and `SatelliteLink` clearly describe the role of each class.

### 3. Small and focused classes
Each class has one clear purpose. Command classes define one rover action, and communication classes define one transmission technology.

### 4. No duplicated high-level logic
The command classes call the same `CommunicationLink` contract instead of duplicating separate versions of each command for every communication technology.

### 5. Open/Closed Principle / backward-compatible design
A new `CommunicationLink` implementation can be added without modifying `RoverCommand`, `PhotoCommand`, or `TemperatureScanCommand`.

### 6. Dependency on abstraction
`RoverCommand` depends on the `CommunicationLink` interface rather than directly depending on `RadioLink` or `SatelliteLink`.

## How to run

From the project root:

### Windows PowerShell / Command Prompt

```text
javac -d out src/com/sdp/bridge/*.java
java -cp out com.sdp.bridge.Main
```

### macOS / Linux

```text
javac -d out src/com/sdp/bridge/*.java
java -cp out com.sdp.bridge.Main
```

## Expected output

```text
=== Initial combinations ===
[Radio] Connection established.
[Radio] Sending: Capture photo of Sector A-17
[Radio] Connection closed.

[Satellite] Secure satellite channel opened.
[Satellite] Transmitting: Scan temperature in Crater North
[Satellite] Satellite channel closed.

=== Runtime implementation switch ===
[Satellite] Secure satellite channel opened.
[Satellite] Transmitting: Capture photo of Sector A-17
[Satellite] Satellite channel closed.
```

## Short defense explanation

> My project uses the Bridge pattern to separate rover commands from communication technologies. `RoverCommand` is the Abstraction and stores a reference to the `CommunicationLink` Implementor. `PhotoCommand` and `TemperatureScanCommand` are Refined Abstractions. `RadioLink` and `SatelliteLink` are Concrete Implementors. Because the two hierarchies are separated, I can add new commands or new communication methods independently. In `Main`, I also switch the communication implementation at runtime without changing the command abstraction.
