package linear_algebra;


public class Vector3D {
    private double x, y, z;
    
    
    public Vector3D(double x, double y, double z) {
        setX(x);
        setY(y);
        setZ(z);
    }
    
    
    public Vector3D(double xBegin, double yBegin, double zBegin, double xEnd, double yEnd, double zEnd) {
        setX(xEnd - xBegin);
        setY(yEnd - yBegin);
        setZ(zEnd - zBegin);
    }
    
    
    public Vector3D(Point3D begin, Point3D end) {
        this(begin.getX(), begin.getY(), begin.getZ(), end.getX(), end.getY(), end.getZ());
    }
    
    
    public Vector3D() {
    }
    
    
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
    
    
    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }
    
    
    public Vector3D multiplyBy(double coefficient) {
        return new Vector3D(coefficient * x, coefficient * y, coefficient * z);
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