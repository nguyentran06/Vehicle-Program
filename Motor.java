public class Motor extends Vehicle {
    private int cubicCentimeter;

    public Motor(String make, String model, String bodyStyle, int year, double price, int cubicCentimeter) {
        super(make, model, bodyStyle, year, price);
        this.cubicCentimeter = cubicCentimeter;
    }

    public int getCubicCentimeter() {
        return cubicCentimeter;
    }

    public void setCubicCentimeter(int cubicCentimeter) {
        this.cubicCentimeter = cubicCentimeter;
    }

    public String toString() {
        return super.toString() + " " + cubicCentimeter + "cc";
    }
}