package nu.tengstrand.chainedcreator.car;

public class Car {
    private String name;
    private String color;
    private int length;

    // Package-private access level
    Car() {
    }

    // Creates an instance of a Book
    public static ArgName create() {
        return new Car().new ArgName();
    }

    // Parameter chain. If you have a lot of attributes, this is an example of a more compact format.
    public class ArgName { public ArgColor name(String name) { Car.this.name = name; return new ArgColor(); }}
    public class ArgColor { public ArgLength color(String color) { Car.this.color = color; return new ArgLength(); }}
    public class ArgLength { public Car length(int length) { Car.this.length = length; return Car.this; }}

    @Override
    public String toString() {
        return "Car{" + "name='" + name + "', color='" + color + "', length=" + length + '}';
    }
}
