package linear_algebra;


import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;


public class TestPoint3D {
    private final double EPS = 1E-9;
    
    
    @Test
    void testPoint3D() {
        Point3D point1 = new Point3D(-1, 2, 3);
        Point3D point2 = new Point3D();
        
        assertAll(
                () -> assertEquals(-1, point1.getX(), EPS),
                () -> assertEquals(2, point1.getY(), EPS),
                () -> assertEquals(3, point1.getZ(), EPS),
                () -> assertEquals(0, point2.getX(), EPS),
                () -> assertEquals(0, point2.getY(), EPS),
                () -> assertEquals(0, point2.getZ(), EPS)
        );
    }
    
    
    @Test
    void testPoint3DSetCoordinates() {
        Point3D point = new Point3D();
        
        point.setX(10);
        point.setY(12);
        point.setZ(-100);
        
        assertAll(
                () -> assertEquals(10, point.getX(), EPS),
                () -> assertEquals(12, point.getY(), EPS),
                () -> assertEquals(-100, point.getZ(), EPS)
        );
        
        point.setX(5);
        point.setY(6);
        point.setZ(7);
        
        assertAll(
                () -> assertEquals(5, point.getX(), EPS),
                () -> assertEquals(6, point.getY(), EPS),
                () -> assertEquals(7, point.getZ(), EPS)
        );
    }
    
    
    @Test
    void testPoint3DMoveTo() {
        Point3D point = new Point3D(10, 30, 50);
        
        point.moveTo(2, 3, 5);
        
        assertAll(
                () -> assertEquals(2, point.getX(), EPS),
                () -> assertEquals(3, point.getY(), EPS),
                () -> assertEquals(5, point.getZ(), EPS)
        );
    }
    
    
    @Test
    void testPoint3DMoveRel() {
        Point3D point = new Point3D(1, 8, 4);
        
        point.moveRel(10, -15, 1.2);
        
        assertAll(
                () -> assertEquals(11, point.getX(), EPS),
                () -> assertEquals(-7, point.getY(), EPS),
                () -> assertEquals(5.2, point.getZ(), EPS)
        );
    }
    
    
    @Test
    void testPoint3DToString() {
        Locale.setDefault(Locale.forLanguageTag("ru-RU"));
        
        assertAll(
                () -> assertEquals("Point3D(1,0000; 2,0000; 3,0000)", new Point3D(1, 2, 3).toString()),
                () -> assertEquals("Point3D(0,9876; 1,2999; 5,0000)", new Point3D(.9876, 1.29985, 4.99996).toString())
        );
    }
    
    
    @Test
    void testPoint3DEquals() {
        Point3D point1 = new Point3D();
        Point3D point2 = new Point3D(0, 0, 0);
        Point3D point3 = point2;
        Point3D point4 = new Point3D(1, 0, 0);
        Point3D point5 = new Point3D(0, .03, 0);
        Point3D point6 = new Point3D(0, 0, .2);
        
        assertAll(
                () -> assertEquals(point1, point2),
                () -> assertFalse(point1 == point2),
                () -> assertEquals(point1, point3),
                () -> assertNotEquals(point1, point4),
                () -> assertNotEquals(point1, point5),
                () -> assertNotEquals(point1, point6),
                () -> assertNotEquals(point5, null),
                () -> assertNotEquals(point6, "")
        );
    }
}