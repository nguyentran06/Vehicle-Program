public class Car extends Vehicle {
    private String color;

    public Car(String make, String model, String bodyStyle, int year, double price, String color) {
        super(make, model, bodyStyle, year, price);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        return super.toString() + " " + color;
    }
}