package exercise_6_ProxyPatternExample;

public class ProxyPatternTest {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");

        // Image will be loaded from remote server and displayed
        image1.display();
        System.out.println("------------");
        
        // Image will be displayed directly without loading from remote server
        image1.display();
        System.out.println("------------");
        
        // Image will be displayed directly without loading from remote server
        image1.display();
        System.out.println("------------");

        // Image will be loaded from remote server and displayed
        image2.display();
        System.out.println("------------");

        // Image will be displayed directly without loading from remote server
        image2.display();
    }
}


/*

Why Use the Proxy Pattern?
Lazy Initialization:

The proxy object delays the creation and initialization of the real object until it is actually needed. This can save resources and improve performance, especially when dealing with large or resource-intensive objects.
Caching:

The proxy can store a reference to the real object and reuse it, avoiding repeated initialization and potentially expensive operations like loading an image from a remote server.
Access Control:

The proxy can control access to the real object, providing additional functionality such as logging, authentication, or checking permissions before delegating the request to the real object.
Separation of Concerns:

The proxy pattern helps in separating the concerns of different responsibilities. For example, RealImage focuses on loading and displaying the image, while ProxyImage handles lazy initialization and caching.

*/