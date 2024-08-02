package exercise_6_ProxyPatternExample;

public class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}

/*
Holds a reference to a RealImage object.
Implements lazy initialization: the real image is only loaded when the display() method is called for the first time.
Caches the real image: subsequent calls to display() use the cached RealImage object.
*/