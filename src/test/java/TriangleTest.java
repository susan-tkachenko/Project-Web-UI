import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TriangleTest {

    @Test(expected = IllegalArgumentException.class)
    public void invalidSideA() {
        Triangle.square(-1, 2, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidSideB() {
        Triangle.square(1, -2, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidSideC() {
        Triangle.square(1, 2, -3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void zeroSides() {
        Triangle.square(0, 0, 0);
    }

    @Test
    public void rightTriangle() {
        test(6d, Triangle.square(3, 4, 5));
    }

    @Test
    public void isoscelesTriangle() {
        test(4.14578098794, Triangle.square(3, 3, 5));
    }

    @Test
    public void equilateralTriangle() {
        test(3.89711431702, Triangle.square(3, 3, 3));
    }

    @Test
    public void simpleTriangle() {
        test(10.92874649719, Triangle.square(4, 7, 10));
    }

    @Test
    public void oneBigSideTriangle() {
        test(3.5184372068352E13, Triangle.square(Integer.MAX_VALUE / 2, Integer.MAX_VALUE / 2 + 2, Integer.MAX_VALUE));
    }

    @Test
    public void minTriangle() {
        test(0.4330127018922, Triangle.square(1, 1, 1));
    }

    @Test
    public void maxTriangle() {
        test(1.99691862125803904E18, Triangle.square(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE));
    }

    private void test(double expected, double actual) {
        assertEquals(expected, actual, 0.00000000001d);
    }

}