public class Vehicle {
    private String make;
    private String model;
    private String bodyStyle;
    private int year;
    private double price;

    public Vehicle(String make, String model, String bodyStyle, int year, double price) {
        this.make = make;
        this.model = model;
        this.bodyStyle = bodyStyle;
        this.year = year;
        this.price = price;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBodyStyle() {
        return bodyStyle;
    }

    public void setBodyStyle(String bodyStyle) {
        this.bodyStyle = bodyStyle;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return String.format("%s %s %s %d $%.2f", make, model, bodyStyle, year, price);
    }
}