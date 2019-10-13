package simple_classes;


import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;


public class TestVector3D {
    private final double EPS = 1E-9;


    @Test
    public void testVector3D1() {
        Vector3D v1 = new Vector3D(1.1, -2.3, 3.99);
        Vector3D v2 = new Vector3D(0, 0, 0);

        assertAll(
                () -> assertEquals(1.1, v1.getX(), EPS),
                () -> assertEquals(-2.3, v1.getY(), EPS),
                () -> assertEquals(3.99, v1.getZ(), EPS),
                () -> assertEquals(0, v2.getX(), EPS),
                () -> assertEquals(0, v2.getY(), EPS),
                () -> assertEquals(0, v2.getZ(), EPS)
        );
    }


    @Test
    public void testVector3D1Exceptions() {
        assertAll(
        () -> assertThrows(IllegalArgumentException.class, () -> new Vector3D(Double.POSITIVE_INFINITY, 0, 0)),
        () -> assertThrows(IllegalArgumentException.class, () -> new Vector3D(Double.NEGATIVE_INFINITY, 0, 0)),
        () -> assertThrows(IllegalArgumentException.class, () -> new Vector3D(Double.NaN, 0, 0)),
        () -> assertThrows(IllegalArgumentException.class, () -> new Vector3D(0, Double.POSITIVE_INFINITY, 0)),
        () -> assertThrows(IllegalArgumentException.class, () -> new Vector3D(0, Double.NEGATIVE_INFINITY, 0)),
        () -> assertThrows(IllegalArgumentException.class, () -> new Vector3D(0, Double.NaN, 0)),
        () -> assertThrows(IllegalArgumentException.class, () -> new Vector3D(0, 0, Double.POSITIVE_INFINITY)),
        () -> assertThrows(IllegalArgumentException.class, () -> new Vector3D(0, 0, Double.NEGATIVE_INFINITY)),
        () -> assertThrows(IllegalArgumentException.class, () -> new Vector3D(0, 0, Double.NaN))
        );
    }


    @Test
    public void testVector3D2() {
        Vector3D v = new Vector3D(100, -2.1, 0.71, 96.5, 0.1, -3);

        assertAll(
                () -> assertEquals(-3.5, v.getX(), EPS),
                () -> assertEquals(2.2, v.getY(), EPS),
                () -> assertEquals(-3.71, v.getZ(), EPS),
                () -> assertThrows(ArithmeticException.class,
                    () -> new Vector3D(-Double.MAX_VALUE, 1, 1, Double.MAX_VALUE, 1, 1)),
                () -> assertThrows(ArithmeticException.class,
                    () -> new Vector3D(1, -Double.MAX_VALUE, 1, 1, Double.MAX_VALUE, 1)),
                () -> assertThrows(ArithmeticException.class,
                    () -> new Vector3D(1, 1, -Double.MAX_VALUE, 1, 1, Double.MAX_VALUE))
        );
    }


    @Test
    public void testVector3D3() {
        Vector3D v = new Vector3D(new Point3D(-21, 2.1, 5.4), new Point3D(-20, 2.123, -0.6));

        assertAll(
                () -> assertEquals(1, v.getX(), EPS),
                () -> assertEquals(0.023, v.getY(), EPS),
                () -> assertEquals(-6, v.getZ(), EPS)
        );

        Point3D point11 = new Point3D(-Double.MAX_VALUE, 1, 1);
        Point3D point12 = new Point3D(Double.MAX_VALUE, 1, 1);
        Point3D point21 = new Point3D(1, -Double.MAX_VALUE, 1);
        Point3D point22 = new Point3D(1, Double.MAX_VALUE, 1);
        Point3D point31 = new Point3D(1, 1, -Double.MAX_VALUE);
        Point3D point32 = new Point3D(1, 1, Double.MAX_VALUE);

        assertAll(
                () -> assertThrows(ArithmeticException.class, () -> new Vector3D(point11, point12)),
                () -> assertThrows(ArithmeticException.class, () -> new Vector3D(point21, point22)),
                () -> assertThrows(ArithmeticException.class, () -> new Vector3D(point31, point32))
        );
    }


    @Test
    public void testVector3D4() {
        Vector3D v = new Vector3D();

        assertAll(
                () -> assertEquals(0, v.getX(), EPS),
                () -> assertEquals(0, v.getY(), EPS),
                () -> assertEquals(0, v.getZ(), EPS)
        );
    }


    @Test
    public void testVector3DSetCoordinates() {
        Vector3D v = new Vector3D(1, 2, 3);

        v.setX(0.7);
        v.setY(-1);
        v.setZ(5);

        assertAll (
                () -> assertEquals(0.7, v.getX(), EPS),
                () -> assertEquals(-1, v.getY(), EPS),
                () -> assertEquals(5, v.getZ(), EPS)
        );
    }


    @Test
    public void testVector3DLength() {
        assertAll(
                () -> assertEquals(8.6, new Vector3D(5, 6, 3.6).length(), EPS),
                () -> assertEquals(5, new Vector3D(3, 4, 0).length(), EPS),
                () -> assertEquals(4.5, new Vector3D(2, -4, -0.5).length(), EPS),
                () -> assertEquals(Math.sqrt(3), new Vector3D(1, 1, 1).length(), EPS),
                () -> assertThrows(ArithmeticException.class,
                        () -> new Vector3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE).length())
        );
    }


    @Test
    public void testVector3DMultiplyBy() {
        Vector3D v1 = new Vector3D(1, 2, 3);
        Vector3D v2 = new Vector3D(-1, 0, 2.5);
        Vector3D v3 = new Vector3D(Double.MAX_VALUE, 1, 2);

        assertAll(
                () -> assertEquals(new Vector3D(0.5, 1, 1.5), v1.multiplyBy(0.5)),
                () -> assertEquals(new Vector3D(-2, -4, -6), v1.multiplyBy(-2)),
                () -> assertEquals(new Vector3D(-8, 0, 20), v2.multiplyBy(8)),
                () -> assertThrows(ArithmeticException.class, () -> v1.multiplyBy(Double.MAX_VALUE)),
                () -> assertThrows(ArithmeticException.class, () -> v3.multiplyBy(1.2))
        );
    }
    
    
    @Test
    public void testVector3DToString() {
        Locale.setDefault(Locale.forLanguageTag("ru-RU"));
        
        assertAll(
                () -> assertEquals("Vector3D(1,0000; 2,0000; 3,0000)", new Vector3D(1, 2, 3).toString()),
                () -> assertEquals("Vector3D(0,9876; 1,2999; 5,0000)", new Vector3D(.9876, 1.29985, 4.99996).toString())
        );
    }


    @Test
    public void testVector3DEquals() {
        Vector3D v1 = new Vector3D();
        Vector3D v2 = new Vector3D(0, 0, 0);
        Vector3D v3 = null;
        Vector3D v4 = new Vector3D(1, 0, 0);
        Vector3D v5 = new Vector3D(0, 1, 0);
        Vector3D v6 = new Vector3D(0, 0, 1);

        assertAll(
                () -> assertEquals(v1, v1),
                () -> assertEquals(v1, v2),
                () -> assertNotEquals(v1, v3),
                () -> assertNotEquals(v1, ""),
                () -> assertNotEquals(v1, v4),
                () -> assertNotEquals(v1, v5),
                () -> assertNotEquals(v1, v6),
                () -> assertNotEquals(v5, v6)
        );
    }
}