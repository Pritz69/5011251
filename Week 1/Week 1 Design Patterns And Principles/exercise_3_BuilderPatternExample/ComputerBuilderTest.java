package exercise_3_BuilderPatternExample;

public class ComputerBuilderTest {
    public static void main(String[] args) {
    
        Computer computer1 = new Computer.Builder()
                                    .cpu("Intel i7")
                                    .ram(16)
                                    .storage(512)
                                    .build();
        															// We can change the order of CPU ,RAM setter calls unlike constructors
        														 	// where ordering is important.
        															// Mutable
        															
        Computer computer2 = new Computer.Builder()
                                    .cpu("AMD Ryzen 9")
                                    .ram(32)
                                    .build();
        															// We can even opt to not pass any value, it will get instantiated with a default value.
        															// Like in this case, Storage will get the default value 0, since we are not setting it.
        displayComputerDetails(computer1);
        displayComputerDetails(computer2);
    }

    private static void displayComputerDetails(Computer computer) {
        System.out.println("Computer Configuration:");
        System.out.println("CPU: " + computer.getCpu());
        System.out.println("RAM: " + computer.getRam() + "GB");
        System.out.println("Storage: " + computer.getStorage() + "GB");
        System.out.println();
    }
}
