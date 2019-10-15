package simple_classes;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TestVector3DArray {
    private final double EPS = 1E-9;


    @Test
    public void testVector3DArray() {
        Vector3DArray vArray = new Vector3DArray(5);
        Vector3D v0 = new Vector3D();

        assertEquals(5, vArray.getSize());

        for (int i = 0; i < 5; i++)
            assertEquals(v0, vArray.getVector(i));
    }


    @Test
    public void testVector3DArrayExceptions() {
        Vector3DArray vArray = new Vector3DArray(5);

        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> new Vector3DArray(-5)),
                () -> assertThrows(IllegalArgumentException.class, () -> new Vector3DArray(0)),
                () -> assertThrows(IllegalArgumentException.class, () -> vArray.getVector(-2)),
                () -> assertThrows(IllegalArgumentException.class, () -> vArray.getVector(5)),
                () -> assertThrows(IllegalArgumentException.class, () -> vArray.getVector(10))
        );
    }


    @Test
    public void testVector3DArraySetVector1() {
        Vector3DArray vArray = new Vector3DArray(5);
        Vector3D v0 = new Vector3D();

        vArray.setVector(1, 8.5, 9.3, -1.1);
        vArray.setVector(2, 2, 3, 4);

        assertAll (
                () -> assertEquals(v0, vArray.getVector(0)),
                () -> assertEquals(new Vector3D(8.5, 9.3, -1.1), vArray.getVector(1)),
                () -> assertEquals(new Vector3D(2, 3, 4), vArray.getVector(2)),
                () -> assertEquals(v0, vArray.getVector(3)),
                () -> assertEquals(v0, vArray.getVector(4)),
                () -> assertThrows(IllegalArgumentException.class, () -> vArray.setVector(-1, 1, 1, 1)),
                () -> assertThrows(IllegalArgumentException.class, () -> vArray.setVector(5, 1, 1, 1)),
                () -> assertThrows(IllegalArgumentException.class, () -> vArray.getVector(-1)),
                () -> assertThrows(IllegalArgumentException.class, () -> vArray.getVector(5))
        );
    }


    @Test
    public void testVector3DArraySetVector2() {
        Vector3DArray vArray = new Vector3DArray(5);
        Vector3D v0 = new Vector3D();

        vArray.setVector(1, new Vector3D(8.5, 9.3, -1.1));
        vArray.setVector(2, new Vector3D(2, 3, 4));

        assertAll (
                () -> assertEquals(v0, vArray.getVector(0)),
                () -> assertEquals(new Vector3D(8.5, 9.3, -1.1), vArray.getVector(1)),
                () -> assertEquals(new Vector3D(2, 3, 4), vArray.getVector(2)),
                () -> assertEquals(v0, vArray.getVector(3)),
                () -> assertEquals(v0, vArray.getVector(4)),
                () -> assertThrows(IllegalArgumentException.class, () -> vArray.setVector(-1, v0)),
                () -> assertThrows(IllegalArgumentException.class, () -> vArray.setVector(5, v0)),
                () -> assertThrows(IllegalArgumentException.class, () -> vArray.setVector(-1, null))
        );
    }


    @Test
    public void testVector3DArrayGetMaxVectorLength() {
        Vector3DArray vArray1 = new Vector3DArray(5);
        Vector3DArray vArray2 = new Vector3DArray(2);

        vArray1.setVector(1, 1, 1, 1);
        vArray1.setVector(2, 2, 0, 0);
        vArray1.setVector(3, 2, -6, 9);
        vArray1.setVector(4, 1, 2, 1);

        vArray2.setVector(1, Double.MAX_VALUE, Double.MAX_VALUE, 0);

        assertAll(
                () -> assertEquals(11, vArray1.getMaxVectorLength(), EPS),
                () -> assertThrows(ArithmeticException.class, () -> vArray2.getMaxVectorLength())
        );
    }


    @Test
    public void testVector3DArrayFindVector() {
        Vector3DArray vArray = new Vector3DArray(5);

        vArray.setVector(0, 1, 0, 0);
        vArray.setVector(1, 0, 0.1, 0);
        vArray.setVector(2, 0, 0, 4.5);
        vArray.setVector(4, 2, 3.1, 6.323);

        assertAll(
                () -> assertEquals(0, vArray.findVector(new Vector3D(1, 0, 0))),
                () -> assertEquals(1, vArray.findVector(new Vector3D(0, 0.1, 0))),
                () -> assertEquals(2, vArray.findVector(new Vector3D(0, 0, 4.5))),
                () -> assertEquals(3, vArray.findVector(new Vector3D())),
                () -> assertEquals(4, vArray.findVector(new Vector3D(2, 3.1, 6.323))),
                () -> assertEquals(-1, vArray.findVector(new Vector3D(1, 1, 1))),
                () -> assertEquals(-1, vArray.findVector(null))
        );
    }


    @Test
    public void testVector3DArraySumAllVectors() {
        Vector3DArray vArray = new Vector3DArray(5);

        vArray.setVector(0, 1, 0, 0);
        vArray.setVector(1, 0, 0.1, 0);
        vArray.setVector(2, 0, 0, 4.5);
        vArray.setVector(4, 2, 3.1, 6.323);

        assertEquals(new Vector3D(3, 3.2, 10.823), vArray.sumAllVectors());

        vArray.getVector(0).setX(Double.MAX_VALUE);
        vArray.getVector(4).setX(Double.MAX_VALUE);

        assertThrows(ArithmeticException.class, () -> vArray.sumAllVectors());
    }


    @Test
    public void testVector3DArrayLinCombination() {
        Vector3DArray vArray = new Vector3DArray(5);
        double[] coefficients1 = {1, 2, 1.5, 1, 10};
        double[] coefficients2 = {2, 0.5, -3, 11, 0};
        double[] coefficients3 = {1, 2, 1.5, 1};
        double[] coefficients4 = {1, 2, 1.5, 1, 10, 2};
        double[] coefficients5 = null;
        double[] coefficients6 = {2, 1.5, 1, 10, Double.MAX_VALUE};

        vArray.setVector(0, 1, 0, 0);
        vArray.setVector(1, 0, 0.1, 0);
        vArray.setVector(2, 0, 0, 4.5);
        vArray.setVector(4, 2, 3.1, 6.3);

        assertAll(
                () -> assertEquals(new Vector3D(21, 31.2, 69.75), vArray.linCombination(coefficients1)),
                () -> assertEquals(new Vector3D(2, 0.05, -13.5), vArray.linCombination(coefficients2)),
                () -> assertThrows(IllegalArgumentException.class, () -> vArray.linCombination(coefficients3)),
                () -> assertThrows(IllegalArgumentException.class, () -> vArray.linCombination(coefficients4)),
                () -> assertThrows(IllegalArgumentException.class, () -> vArray.linCombination(coefficients5)),
                () -> assertThrows(ArithmeticException.class, () -> vArray.linCombination(coefficients6))
        );

        vArray.getVector(1).setX(Double.MAX_VALUE);

        assertThrows(ArithmeticException.class, () -> vArray.linCombination(coefficients1));
    }


    @Test
    public void testVector3DArrayMovePoint() {
        Vector3DArray vArray = new Vector3DArray(3);
        Point3D point = new Point3D(-2, 2.4, -0.5);
        Point3D[] pointArray = new Point3D[3], pointArrayRes;

        vArray.setVector(1, 1, 2, -3);
        vArray.setVector(2, 5.5, -3.3, 0.8);

        pointArray[0] = point;
        pointArray[1] = new Point3D(-1, 4.4, -3.5);
        pointArray[2] = new Point3D(3.5, -0.9, 0.3);

        pointArrayRes = vArray.movePoint(point);

        assertAll(
                () -> assertEquals(pointArrayRes[0], pointArray[0]),
                () -> assertEquals(pointArrayRes[1], pointArray[1]),
                () -> assertEquals(pointArrayRes[2], pointArray[2]),
                () -> assertThrows(IllegalArgumentException.class, () -> vArray.movePoint(null))
        );

        vArray.setVector(1, 0, Double.MAX_VALUE, 0);
        point.setY(Double.MAX_VALUE);

        assertThrows(ArithmeticException.class, () -> vArray.movePoint(point));
    }
}