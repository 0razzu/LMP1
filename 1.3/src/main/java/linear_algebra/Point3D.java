package linear_algebra;


public class Point3D {
    private double x, y, z;
    
    
    public Point3D(double x, double y, double z) {
        setX(x);
        setY(y);
        setZ(z);
    }
    
    
    public Point3D() {
    }
    
    
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
        setX(x);
        setY(y);
        setZ(z);
    }
    
    
    public void moveRel(double x, double y, double z) {
        setX(this.x + x);
        setY(this.y + y);
        setZ(this.z + z);
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