package linear_algebra;


import static java.lang.Math.abs;


public class Vector3DProcessor {
    public static Vector3D sum(double ux, double uy, double uz, double vx, double vy, double vz) {
        return new Vector3D(ux + vx, uy + vy, uz + vz);
    }
    
    
    public static Vector3D sum(Vector3D u, Vector3D v) {
        if ((u == null) || (v == null))
            throw new IllegalArgumentException();
        
        return sum(u.getX(), u.getY(), u.getZ(), v.getX(), v.getY(), v.getZ());
    }
    
    
    public static Vector3D diff(double ux, double uy, double uz, double vx, double vy, double vz) {
        return new Vector3D(ux - vx, uy - vy, uz - vz);
    }
    
    
    public static Vector3D diff(Vector3D u, Vector3D v) {
        if ((u == null) || (v == null))
            throw new IllegalArgumentException();
        
        return diff(u.getX(), u.getY(), u.getZ(), v.getX(), v.getY(), v.getZ());
    }
    
    
    public static double scalarProduct(double ux, double uy, double uz, double vx, double vy, double vz) {
        return ux * vx + uy * vy + uz * vz;
    }
    
    
    public static double scalarProduct(Vector3D u, Vector3D v) {
        if ((u == null) || (v == null))
            throw new IllegalArgumentException();
        
        return scalarProduct(u.getX(), u.getY(), u.getZ(), v.getX(), v.getY(), v.getZ());
    }
    
    
    public static Vector3D vectorProduct(double ux, double uy, double uz, double vx, double vy, double vz) {
        return diff(uy * vz, uz * vx, ux * vy, uz * vy, ux * vz, uy * vx);
    }
    
    
    public static Vector3D vectorProduct(Vector3D u, Vector3D v) {
        if ((u == null) || (v == null))
            throw new IllegalArgumentException();
        
        return vectorProduct(u.getX(), u.getY(), u.getZ(), v.getX(), v.getY(), v.getZ());
    }
    
    
    public static boolean areCollinear(double ux, double uy, double uz, double vx, double vy, double vz) {
        final double EPS = 1E-9;
        
        return (abs(ux * vy - uy * vx) < EPS) && (abs(uy * vz - uz * vy) < EPS);
    }
    
    
    public static boolean areCollinear(Vector3D u, Vector3D v) {
        if ((u == null) || (v == null))
            throw new IllegalArgumentException();
        
        return areCollinear(u.getX(), u.getY(), u.getZ(), v.getX(), v.getY(), v.getZ());
    }
}