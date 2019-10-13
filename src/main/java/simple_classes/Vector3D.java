package simple_classes;


import java.util.Objects;


public class Vector3D {
    private double x, y, z;


    public Vector3D(double x, double y, double z) {
        if ((Double.isInfinite(x)) || (Double.isNaN(x)) ||
            (Double.isInfinite(y)) || (Double.isNaN(y)) ||
            (Double.isInfinite(z)) || (Double.isNaN(z)))
            throw new IllegalArgumentException();

        this.x = x;
        this.y = y;
        this.z = z;
    }


    public Vector3D(double xBegin, double yBegin, double zBegin, double xEnd, double yEnd, double zEnd) throws ArithmeticException {
        x = SafeOperations.diff(xEnd, xBegin);
        y = SafeOperations.diff(yEnd, yBegin);
        z = SafeOperations.diff(zEnd, zBegin);
    }


    public Vector3D(Point3D begin, Point3D end) throws ArithmeticException {
        this(begin.getX(), begin.getY(), begin.getZ(), end.getX(), end.getY(), end.getZ());
    }


    public Vector3D() {}


    public void setX(double x) {
        this.x = x;
    }


    public void setY(double y) {
        this.y = y;
    }


    public void setZ(double z) {
        this.z = z;
    }


    public double getX() {
        return x;
    }


    public double getY() {
        return y;
    }


    public double getZ() {
        return z;
    }


    public double length() throws ArithmeticException {
        double x = this.x, y = this.y, z = this.z;

        x = SafeOperations.mul(x, x);
        y = SafeOperations.mul(y, y);
        z = SafeOperations.mul(z, z);

        x = SafeOperations.sum(x, y);

        return Math.sqrt(SafeOperations.sum(x, z));
    }


    public Vector3D multiplyBy(double coefficient) throws ArithmeticException {
        return new Vector3D(SafeOperations.mul(coefficient, x),
                            SafeOperations.mul(coefficient, y),
                            SafeOperations.mul(coefficient, z));
    }
    
    
    @Override
    public String toString() {
        return String.format("Vector3D(%.4f; %.4f; %.4f)", x, y, z);
    }


    @Override
    public boolean equals(Object o) {
        final double EPS = 1E-9;

        if (this == o) return true;
        if (!(o instanceof Vector3D)) return false;
        Vector3D vector3D = (Vector3D) o;
        return Math.abs(vector3D.x - x) < EPS &&
                Math.abs(vector3D.y - y) < EPS &&
                Math.abs(vector3D.z - z) < EPS;
    }
}