package simple_classes;


public class Vector3DProcessor {
    public static Vector3D sum(double ux, double uy, double uz, double vx, double vy, double vz) throws ArithmeticException {
        return new Vector3D(SafeOperations.sum(ux, vx), SafeOperations.sum(uy, vy), SafeOperations.sum(uz, vz));
    }


    public static Vector3D sum(Vector3D u, Vector3D v) throws IllegalArgumentException, ArithmeticException {
        if ((u == null) || (v == null))
            throw new IllegalArgumentException();

        return sum(u.getX(), u.getY(), u.getZ(), v.getX(), v.getY(), v.getZ());
    }


    public static Vector3D diff(double ux, double uy, double uz, double vx, double vy, double vz) throws ArithmeticException {
        return new Vector3D(SafeOperations.diff(ux, vx), SafeOperations.diff(uy, vy), SafeOperations.diff(uz, vz));
    }


    public static Vector3D diff(Vector3D u, Vector3D v) throws IllegalArgumentException, ArithmeticException {
        if ((u == null) || (v == null))
            throw new IllegalArgumentException();

        return diff(u.getX(), u.getY(), u.getZ(), v.getX(), v.getY(), v.getZ());
    }


    public static double scalarProduct(double ux, double uy, double uz, double vx, double vy, double vz) throws ArithmeticException {
        ux = SafeOperations.mul(ux, vx);
        uy = SafeOperations.mul(uy, vy);
        uz = SafeOperations.mul(uz, vz);

        ux = SafeOperations.sum(ux, uy);

        return SafeOperations.sum(ux, uz);
    }


    public static double scalarProduct(Vector3D u, Vector3D v) throws IllegalArgumentException, ArithmeticException {
        if ((u == null) || (v == null))
            throw new IllegalArgumentException();

        return scalarProduct(u.getX(), u.getY(), u.getZ(), v.getX(), v.getY(), v.getZ());
    }


    public static Vector3D vectorProduct(double ux, double uy, double uz, double vx, double vy, double vz) throws ArithmeticException {
        return diff(SafeOperations.mul(uy, vz), SafeOperations.mul(uz, vx), SafeOperations.mul(ux, vy),
                    SafeOperations.mul(uz, vy), SafeOperations.mul(ux, vz), SafeOperations.mul(uy, vx));
    }


    public static Vector3D vectorProduct(Vector3D u, Vector3D v) throws IllegalArgumentException, ArithmeticException {
        if ((u == null) || (v == null))
            throw new IllegalArgumentException();

        return vectorProduct(u.getX(), u.getY(), u.getZ(), v.getX(), v.getY(), v.getZ());
    }


    public static boolean areCollinear(double ux, double uy, double uz, double vx, double vy, double vz) throws ArithmeticException {
        final double EPS = 1E-9;

        return (Math.abs(SafeOperations.mul(ux, vy) - SafeOperations.mul(uy, vx)) < EPS) &&
               (Math.abs(SafeOperations.mul(uy, vz) - SafeOperations.mul(uz, vy)) < EPS);
    }


    public static boolean areCollinear(Vector3D u, Vector3D v) throws IllegalArgumentException, ArithmeticException {
        if ((u == null) || (v == null))
            throw new IllegalArgumentException();

        return areCollinear(u.getX(), u.getY(), u.getZ(), v.getX(), v.getY(), v.getZ());
    }
}