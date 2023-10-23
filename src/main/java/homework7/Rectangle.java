package homework7;

public class Rectangle {
    double width;
    double height;
    String lineColor;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle(double width, double height, String lineColor) {
        this.width = width;
        this.height = height;
        this.lineColor = lineColor;

    }


    public double areaRectangle() {
        return width * height;
    }

    public double perimeterRectangle() {
        return 2 * (width + height);
    }

    public String lineColorRectangle() {
        return lineColor;
    }
}
