package simple_classes;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TestVector3DProcessor {
    private final double EPS = 1E-9;


    @Test
    public void testVector3DProcessorSum() {
        Vector3D v1 = new Vector3D(1, 2, -5);
        Vector3D v2 = new Vector3D(2.5, -3, 11);
        Vector3D v3 = new Vector3D(1.5, -1.3, -10.5);
        Vector3D v4 = new Vector3D(Double.MAX_VALUE, 1, 1);

        assertAll(
                () -> assertEquals(new Vector3D(1, 2, 3), Vector3DProcessor.sum(1, -1, 3, 0, 3, 0)),
                () -> assertEquals(new Vector3D(3.5, -1, 6), Vector3DProcessor.sum(v1, v2)),
                () -> assertEquals(new Vector3D(4, -4.3, 0.5), Vector3DProcessor.sum(v2, v3)),
                () -> assertThrows(ArithmeticException.class, () -> Vector3DProcessor.sum(v4, v4)),
                () -> assertThrows(IllegalArgumentException.class, () -> Vector3DProcessor.sum(null, v1)),
                () -> assertThrows(IllegalArgumentException.class, () -> Vector3DProcessor.sum(v1, null))
        );
    }


    @Test
    public void testVector3DProcessorDiff() {
        Vector3D v1 = new Vector3D(1, 2, -5);
        Vector3D v2 = new Vector3D(2.5, -3, 11);
        Vector3D v3 = new Vector3D(1.5, -1.3, -10.5);
        Vector3D v4 = new Vector3D(Double.MAX_VALUE, 1, 1);
        Vector3D v5 = new Vector3D(-Double.MAX_VALUE, 1, 1);

        assertAll(
                () -> assertEquals(new Vector3D(1, -4, 3), Vector3DProcessor.diff(1, -1, 3, 0, 3, 0)),
                () -> assertEquals(new Vector3D(-1.5, 5, -16), Vector3DProcessor.diff(v1, v2)),
                () -> assertEquals(new Vector3D(1, -1.7, 21.5), Vector3DProcessor.diff(v2, v3)),
                () -> assertThrows(ArithmeticException.class, () -> Vector3DProcessor.diff(v4, v5)),
                () -> assertThrows(IllegalArgumentException.class, () -> Vector3DProcessor.diff(null, v1)),
                () -> assertThrows(IllegalArgumentException.class, () -> Vector3DProcessor.diff(v1, null))
        );
    }


    @Test
    public void testVector3DProcessorScalarProduct() {
        Vector3D v1 = new Vector3D(1, 2, -5);
        Vector3D v2 = new Vector3D(2.5, -3, 11);
        Vector3D v3 = new Vector3D(1.5, -1.3, -10.5);
        Vector3D v4 = new Vector3D(Double.MAX_VALUE, 1, 1);

        assertAll(
                () -> assertEquals(-3, Vector3DProcessor.scalarProduct(1, -1, 3, 0, 3, 0), EPS),
                () -> assertEquals(-58.5, Vector3DProcessor.scalarProduct(v1, v2), EPS),
                () -> assertEquals(-107.85, Vector3DProcessor.scalarProduct(v2, v3), EPS),
                () -> assertThrows(ArithmeticException.class, () -> Vector3DProcessor.scalarProduct(v4, v4)),
                () -> assertThrows(IllegalArgumentException.class, () -> Vector3DProcessor.scalarProduct(null, v1)),
                () -> assertThrows(IllegalArgumentException.class, () -> Vector3DProcessor.scalarProduct(v1, null))
        );
    }


    @Test
    public void testVector3DProcessorVectorProduct() {
        Vector3D v1 = new Vector3D(1, 2, -5);
        Vector3D v2 = new Vector3D(2.5, -3, 11);
        Vector3D v3 = new Vector3D(1.5, -1.3, -10.5);
        Vector3D v4 = new Vector3D(Double.MAX_VALUE, 1, 1);
        Vector3D v5 = new Vector3D(0, 0, Double.MAX_VALUE);

        assertAll(
                () -> assertEquals(new Vector3D(-9, 0, 3), Vector3DProcessor.vectorProduct(1, -1, 3, 0, 3, 0)),
                () -> assertEquals(new Vector3D(7, -23.5, -8), Vector3DProcessor.vectorProduct(v1, v2)),
                () -> assertEquals(new Vector3D(45.8, 42.75, 1.25), Vector3DProcessor.vectorProduct(v2, v3)),
                () -> assertThrows(ArithmeticException.class, () -> Vector3DProcessor.vectorProduct(v4, v5)),
                () -> assertThrows(IllegalArgumentException.class, () -> Vector3DProcessor.vectorProduct(null, v1)),
                () -> assertThrows(IllegalArgumentException.class, () -> Vector3DProcessor.vectorProduct(v1, null))
        );
    }


    @Test
    public void testVector3DProcessorAreCollinear() {
        Vector3D v1 = new Vector3D(1, 2, -5);
        Vector3D v2 = new Vector3D(2.5, 3.5, -3.5);
        Vector3D v3 = new Vector3D(2, 4, -10);
        Vector3D v4 = new Vector3D(-1, -2, 5);
        Vector3D v5 = new Vector3D(Double.MAX_VALUE, 1, 1);
        Vector3D v6 = new Vector3D(0, 0, Double.MAX_VALUE);

        assertAll(
                () -> assertTrue(Vector3DProcessor.areCollinear(v1, v1)),
                () -> assertFalse(Vector3DProcessor.areCollinear(v1, v2)),
                () -> assertTrue(Vector3DProcessor.areCollinear(v1, v3)),
                () -> assertTrue(Vector3DProcessor.areCollinear(v1, v4)),
                () -> assertThrows(IllegalArgumentException.class, () -> Vector3DProcessor.areCollinear(null, v1)),
                () -> assertThrows(IllegalArgumentException.class, () -> Vector3DProcessor.areCollinear(v1, null))
        );
    }
}
