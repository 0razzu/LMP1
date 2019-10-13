package simple_classes;


import java.util.Objects;


public class Point3D {
    private double x, y, z;


    public Point3D(double x, double y, double z) throws IllegalArgumentException {
        if ((Double.isInfinite(x)) || (Double.isNaN(x)) ||
            (Double.isInfinite(y)) || (Double.isNaN(y)) ||
            (Double.isInfinite(z)) || (Double.isNaN(z)))
            throw new IllegalArgumentException();

        this.x = x;
        this.y = y;
        this.z = z;
    }


    public Point3D() {}


    public double getX() {
        return x;
    }


    public void setX(double x) {
        this.x = x;
    }


    public double getY() {
        return y;
    }


    public void setY(double y) {
        this.y = y;
    }


    public double getZ() {
        return z;
    }


    public void setZ(double z) {
        this.z = z;
    }


    public void moveTo(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }


    public void moveRel(double x, double y, double z) throws ArithmeticException {
        this.x = SafeOperations.sum(this.x, x);
        this.y = SafeOperations.sum(this.y, y);
        this.z = SafeOperations.sum(this.z, z);
    }


    @Override
    public String toString() {
        return String.format("Point3D(%.4f; %.4f; %.4f)", x, y, z);
    }


    @Override
    public boolean equals(Object o) {
        final double EPS = 1E-9;

        if (this == o) return true;
        if (!(o instanceof Point3D)) return false;
        Point3D point3D = (Point3D) o;
        return Math.abs(point3D.x - x) < EPS &&
                Math.abs(point3D.y - y) < EPS &&
                Math.abs(point3D.z - z) < EPS;
    }
}