package app;

import builder.PCSetup;
import builder.PCSetupBuilder;
import visitor.PriceVisitor;
import visitor.DescriptionVisitor;

public class Main {
    public static void main(String[] args) {

        PCSetup setup = new PCSetupBuilder()
                .addKeyboard("Redragon K552", 45.0, "Mechanical Blue")
                .addMouse("Logitech G102", 25.0, 8000)
                .addMonitor("Samsung Odyssey G5", 250.0, 144)
                .build();

        System.out.println("=== PC PERIPHERY BUILDER ===");

        System.out.println("\n=== PERIPHERAL DESCRIPTION ===");
        DescriptionVisitor descriptionVisitor = new DescriptionVisitor();
        setup.accept(descriptionVisitor);

        System.out.println("\n=== PRICE CALCULATION ===");
        PriceVisitor priceVisitor = new PriceVisitor();
        setup.accept(priceVisitor);

        System.out.println("Total setup price: $"
                + priceVisitor.getTotalPrice());
    }
}