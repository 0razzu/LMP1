package simple_classes;


public class Vector3DArray {
    private Vector3D[] vectorArray;
    private int size;


    public Vector3DArray(int size) throws IllegalArgumentException {
        if (size <= 0)
            throw new IllegalArgumentException();

        vectorArray = new Vector3D[size];
        this.size = size;

        for (int i = 0; i < size; i++)
            vectorArray[i] = new Vector3D();
    }


    public void setVector(int place, double x, double y, double z) throws IllegalArgumentException {
        if ((place < 0) || (place >= size))
            throw new IllegalArgumentException();

        vectorArray[place].setX(x);
        vectorArray[place].setY(y);
        vectorArray[place].setZ(z);
    }


    public void setVector(int place, Vector3D vector) throws IllegalArgumentException {
        if (vector == null)
            throw new IllegalArgumentException();

        setVector(place, vector.getX(), vector.getY(), vector.getZ());
    }


    public int getSize() {
        return size;
    }


    public Vector3D getVector(int place) throws IllegalArgumentException {
        if ((place < 0) || (place >= size))
            throw new IllegalArgumentException();

        return vectorArray[place];
    }


    public double getMaxVectorLength() throws ArithmeticException {
        double max = 0, length;
        final double EPS = 1E-9;

        for (Vector3D v: vectorArray) {
            length = v.length();

            if (length - max > EPS)
                max = length;
        }

        return max;
    }


    public int findVector(Vector3D vector) {
        if (vector == null)
            return -1;

        for (int i = 0; i < size; i++)
            if (vectorArray[i].equals(vector))
                return i;

        return -1;
    }


    public Vector3D sumAllVectors() throws ArithmeticException {
        Vector3D vectorSum = new Vector3D();

        for (Vector3D v: vectorArray) {
            vectorSum.setX(SafeOperations.sum(vectorSum.getX(), v.getX()));
            vectorSum.setY(SafeOperations.sum(vectorSum.getY(), v.getY()));
            vectorSum.setZ(SafeOperations.sum(vectorSum.getZ(), v.getZ()));
        }

        return vectorSum;
    }


    public Vector3D linCombination(double[] coefficients) throws IllegalArgumentException, ArithmeticException {
        Vector3D lin;

        if ((coefficients == null) || (vectorArray.length != coefficients.length))
            throw new IllegalArgumentException();

        lin = new Vector3D();

        for (int i = 0; i < size; i++) {
            lin.setX(SafeOperations.sum(lin.getX(), SafeOperations.mul(coefficients[i], vectorArray[i].getX())));
            lin.setY(SafeOperations.sum(lin.getY(), SafeOperations.mul(coefficients[i], vectorArray[i].getY())));
            lin.setZ(SafeOperations.sum(lin.getZ(), SafeOperations.mul(coefficients[i], vectorArray[i].getZ())));
        }

        return lin;
    }


    public Point3D[] movePoint(Point3D point) throws IllegalArgumentException, ArithmeticException {
        Point3D[] pointArray;
        double x, y, z;

        if (point == null)
            throw new IllegalArgumentException();

        pointArray = new Point3D[size];
        x = point.getX();
        y = point.getY();
        z = point.getZ();

        for (int i = 0; i < size; i++)
            pointArray[i] = new Point3D(SafeOperations.sum(x, vectorArray[i].getX()),
                                        SafeOperations.sum(y, vectorArray[i].getY()),
                                        SafeOperations.sum(z, vectorArray[i].getZ()));

        return pointArray;
    }
}
