# PC Periphery Builder — Visitor Design Pattern

## Project Overview

PC Periphery Builder is a Java application developed for Assignment #6 in the Software Design Patterns course.

The project demonstrates the **Visitor Behavioral Design Pattern** through a PC peripheral management system.

Users can create a PC setup consisting of a keyboard, mouse, and monitor. The Visitor pattern allows different operations to be performed on these peripherals without modifying their classes.

## Features

- Build a PC setup with different peripherals.
- Add keyboards, mice, and monitors.
- Calculate the total price of the setup.
- Display detailed specifications of each peripheral.
- Demonstrate double dispatch using the Visitor pattern.
- Add new operations by creating new visitors.

## Technologies Used

- Java
- Object-Oriented Programming (OOP)
- Visitor Design Pattern
- IntelliJ IDEA

## Project Structure

```text
PCPeripheryBuilder/
│
├── src/
│   ├── element/
│   │   ├── Peripheral.java
│   │   ├── Keyboard.java
│   │   ├── Mouse.java
│   │   └── Monitor.java
│   │
│   ├── visitor/
│   │   ├── PeripheralVisitor.java
│   │   ├── PriceVisitor.java
│   │   └── DescriptionVisitor.java
│   │
│   ├── builder/
│   │   ├── PCSetup.java
│   │   └── PCSetupBuilder.java
│   │
│   └── app/
│       └── Main.java
│
└── README.md
```

## Design Pattern Implementation

The project implements the **Visitor Pattern** using the following components.

### 1. Element Interface

`Peripheral` defines the `accept(PeripheralVisitor visitor)` method.

### 2. Concrete Elements

- `Keyboard` — represents a keyboard with a name, price, and switch type.
- `Mouse` — represents a mouse with a name, price, and DPI.
- `Monitor` — represents a monitor with a name, price, and refresh rate.

Each element implements the `accept()` method.

### 3. Visitor Interface

`PeripheralVisitor` declares methods for each concrete element:

```java
void visitKeyboard(Keyboard keyboard);
void visitMouse(Mouse mouse);
void visitMonitor(Monitor monitor);
```

### 4. Concrete Visitors

**PriceVisitor**

Calculates the total cost of all peripherals.

**DescriptionVisitor**

Displays the specifications of each peripheral.

### 5. Object Structure

`PCSetup` stores peripherals in a collection and allows visitors to process each element.

`PCSetupBuilder` provides a convenient way to assemble the setup.

## Double Dispatch

Double dispatch is the key concept of the Visitor pattern.

Example from `Keyboard.java`:

```java
@Override
public void accept(PeripheralVisitor visitor) {
    visitor.visitKeyboard(this);
}
```

First, the appropriate `accept()` implementation is selected based on the concrete peripheral.

Second, the matching `visitKeyboard()` method is called on the visitor.

This allows different operations to be performed without adding those operations directly to peripheral classes.

## Clean Code Principles

The project follows five Clean Code principles:

1. **Single Responsibility Principle:** Each visitor is responsible for one operation.
2. **Open/Closed Principle:** New operations can be introduced by adding new visitors without modifying existing peripheral classes.
3. **Encapsulation:** Peripheral attributes are private and accessed using getter methods.
4. **Meaningful Naming:** Class and method names clearly describe their responsibilities.
5. **Avoiding Type Checking:** Double dispatch eliminates the need for `instanceof` and type-checking chains.

## How to Run

1. Clone or download the repository.
2. Open the project in IntelliJ IDEA.
3. Configure a Java JDK.
4. Open `src/app/Main.java`.
5. Run the `Main` class.

Alternatively, compile and run from the project root:

```bash
javac -d out src/element/*.java src/visitor/*.java src/builder/*.java src/app/*.java
java -cp out app.Main
```

## Example Output

```text
=== PC PERIPHERY BUILDER ===

=== PERIPHERAL DESCRIPTION ===
Keyboard: Redragon K552
Switch type: Mechanical Blue
Mouse: Logitech G102
DPI: 8000
Monitor: Samsung Odyssey G5
Refresh rate: 144 Hz

=== PRICE CALCULATION ===
Keyboard price: $45.0
Mouse price: $25.0
Monitor price: $250.0
Total setup price: $320.0
```

## Conclusion

This project demonstrates how the Visitor Design Pattern separates operations from the objects on which~~~~