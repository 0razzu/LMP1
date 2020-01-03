package linear_algebra;


import org.junit.jupiter.api.Test;

import java.util.Locale;

import static java.lang.Math.sqrt;
import static org.junit.jupiter.api.Assertions.*;


public class TestVector3D {
    private final double EPS = 1E-9;
    
    
    @Test
    void testVector3D1() {
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
    void testVector3D2() {
        Vector3D v = new Vector3D(100, -2.1, 0.71, 96.5, 0.1, -3);
        
        assertAll(
                () -> assertEquals(-3.5, v.getX(), EPS),
                () -> assertEquals(2.2, v.getY(), EPS),
                () -> assertEquals(-3.71, v.getZ(), EPS)
        );
    }
    
    
    @Test
    void testVector3D3() {
        Vector3D v = new Vector3D(new Point3D(-21, 2.1, 5.4), new Point3D(-20, 2.123, -0.6));
        
        assertAll(
                () -> assertEquals(1, v.getX(), EPS),
                () -> assertEquals(0.023, v.getY(), EPS),
                () -> assertEquals(-6, v.getZ(), EPS)
        );
    }
    
    
    @Test
    void testVector3D4() {
        Vector3D v = new Vector3D();
        
        assertAll(
                () -> assertEquals(0, v.getX(), EPS),
                () -> assertEquals(0, v.getY(), EPS),
                () -> assertEquals(0, v.getZ(), EPS)
        );
    }
    
    
    @Test
    void testVector3DSetCoordinates() {
        Vector3D v = new Vector3D(1, 2, 3);
        
        v.setX(0.7);
        v.setY(-1);
        v.setZ(5);
        
        assertAll(
                () -> assertEquals(0.7, v.getX(), EPS),
                () -> assertEquals(-1, v.getY(), EPS),
                () -> assertEquals(5, v.getZ(), EPS)
        );
    }
    
    
    @Test
    void testVector3DLength() {
        assertAll(
                () -> assertEquals(8.6, new Vector3D(5, 6, 3.6).length(), EPS),
                () -> assertEquals(5, new Vector3D(3, 4, 0).length(), EPS),
                () -> assertEquals(4.5, new Vector3D(2, -4, -0.5).length(), EPS),
                () -> assertEquals(sqrt(3), new Vector3D(1, 1, 1).length(), EPS)
        );
    }
    
    
    @Test
    void testVector3DMultiplyBy() {
        Vector3D v1 = new Vector3D(1, 2, 3);
        Vector3D v2 = new Vector3D(-1, 0, 2.5);
        
        assertAll(
                () -> assertEquals(new Vector3D(0.5, 1, 1.5), v1.multiplyBy(0.5)),
                () -> assertEquals(new Vector3D(-2, -4, -6), v1.multiplyBy(-2)),
                () -> assertEquals(new Vector3D(-8, 0, 20), v2.multiplyBy(8))
        );
    }
    
    
    @Test
    void testVector3DToString() {
        Locale.setDefault(Locale.forLanguageTag("ru-RU"));
        
        assertAll(
                () -> assertEquals("Vector3D(1,0000; 2,0000; 3,0000)", new Vector3D(1, 2, 3).toString()),
                () -> assertEquals("Vector3D(0,9876; 1,2999; 5,0000)", new Vector3D(.9876, 1.29985, 4.99996).toString())
        );
    }
    
    
    @Test
    void testVector3DEquals() {
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