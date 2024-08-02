package exercise_3_BuilderPatternExample;

public class Computer {
    private String cpu;
    private int ram; 
    private int storage; 

    // Private constructor to enforce Builder usage
    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
    }

    public String getCpu() {
        return cpu;
    }
    public int getRam() {
        return ram;
    }
    public int getStorage() {
        return storage;
    }

    // Builder class
    public static class Builder {
        private String cpu;
        private int ram;
        private int storage;

        // Setter methods in Builder class
        public Builder cpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder ram(int ram) {
            this.ram = ram;
            return this;
        }

        public Builder storage(int storage) {
            this.storage = storage;
            return this;
        }

        // Build method to return Computer instance
        public Computer build() {
            return new Computer(this);
        }
    }
}
