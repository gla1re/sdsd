package pcperipherybuilder;

/** The client uses only the Facade, never individual subsystem classes. */
public final class Main {
    private Main() { }

    public static void main(String[] args) {
        PCPeripheryFacade facade = new PCPeripheryFacade();
        try {
            System.out.println("=== GAMING ===");
            facade.startGamingSetup();
            facade.showSetup();
            System.out.println("\n=== OFFICE ===");
            facade.startOfficeSetup();
            facade.showSetup();
        } catch (RuntimeException failure) {
            System.err.println("Setup failed: " + failure.getMessage());
        } finally {
            facade.shutdown();
        }
    }
}
