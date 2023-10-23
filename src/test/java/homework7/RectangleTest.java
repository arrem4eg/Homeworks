package homework7;

import org.testng.annotations.Test;

public class RectangleTest {
    Rectangle rectangle1 = new Rectangle(4, 5);
    Rectangle rectangle2 = new Rectangle(7.5, 8.1, "blue");

    @Test
    public void getAreaAndPerimeter1() {
        System.out.println("S1 = " + rectangle1.areaRectangle() + ", P1 = " + rectangle1.perimeterRectangle());
    }

    @Test
    public void getAreaAndPerimeter2() {
        System.out.println("S2 = " + rectangle2.areaRectangle() + ", P2 = " + rectangle2.perimeterRectangle() + ", \"Line color\": " + rectangle2.lineColorRectangle());
    }

}
