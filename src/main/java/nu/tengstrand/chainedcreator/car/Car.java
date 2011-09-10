package nu.tengstrand.chainedcreator.car;

public class Car {
    private String name;
    private String color;
    private int length;

    // Package-private access level
    Car() {
    }

    // Creates an instance of a Book
    public static Name create() {
        return new Car().new Name();
    }

    // Example of not using a separate creator class, and take advantage of non-static
    // inner classes in Java who can can access attributes of the enclosing class.
    //
    // Parameter chain. If you have a lot of attributes, this is an example of a more compact format.
    public class Name { public Color name(String name) { Car.this.name = name; return new Color(); }}
    public class Color { public Length color(String color) { Car.this.color = color; return new Length(); }}
    public class Length { public Car length(int length) { Car.this.length = length; return Car.this; }}

    @Override
    public String toString() {
        return "Car{" + "name='" + name + "', color='" + color + "', length=" + length + '}';
    }
}
