package DesignPattern;

public class SingletonPattern {
    public static void main(String[] args) {
        Singleton x = Singleton.getInstance();
        Singleton y = Singleton.getInstance();
        Singleton z = Singleton.getInstance();

        // Instance cannot be created because constructor is private
        // Singleton singleton = new Singleton();

        System.out.println("Hashcode of x is " + x.hashCode());
        System.out.println("Hashcode of y is " + y.hashCode());
        System.out.println("Hashcode of z is " + z.hashCode());
    }

}

class Singleton {
    private static Singleton single_instance = null;
    public String s;

    private Singleton() {

    }

    // Static method
    // Static method to create instance of Singleton class
    public static synchronized Singleton getInstance()
    {
        if (single_instance == null)
            single_instance = new Singleton();

        return single_instance;
    }
}
