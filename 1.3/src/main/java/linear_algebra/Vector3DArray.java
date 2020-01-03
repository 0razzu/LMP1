package linear_algebra;


public class Vector3DArray {
    private Vector3D[] vectorArray;
    private int size;
    
    
    public Vector3DArray(int size) {
        if (size <= 0)
            throw new IllegalArgumentException();
        
        vectorArray = new Vector3D[size];
        this.size = size;
        
        for (int i = 0; i < size; i++)
            vectorArray[i] = new Vector3D();
    }
    
    
    public void setVector(int place, double x, double y, double z) {
        if ((place < 0) || (place >= size))
            throw new IllegalArgumentException();
        
        vectorArray[place].setX(x);
        vectorArray[place].setY(y);
        vectorArray[place].setZ(z);
    }
    
    
    public void setVector(int place, Vector3D vector) {
        if (vector == null)
            throw new IllegalArgumentException();
        
        setVector(place, vector.getX(), vector.getY(), vector.getZ());
    }
    
    
    public int getSize() {
        return size;
    }
    
    
    public Vector3D getVector(int place) {
        if ((place < 0) || (place >= size))
            throw new IllegalArgumentException();
        
        return vectorArray[place];
    }
    
    
    public double getMaxVectorLength() {
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
    
    
    public Vector3D sumAllVectors() {
        Vector3D vectorSum = new Vector3D();
        
        for (Vector3D v: vectorArray) {
            vectorSum.setX(vectorSum.getX() + v.getX());
            vectorSum.setY(vectorSum.getY() + v.getY());
            vectorSum.setZ(vectorSum.getZ() + v.getZ());
        }
        
        return vectorSum;
    }
    
    
    public Vector3D linCombination(double[] coefficients) {
        if ((coefficients == null) || (vectorArray.length != coefficients.length))
            throw new IllegalArgumentException();
        
        Vector3D lin = new Vector3D();
        
        for (int i = 0; i < size; i++) {
            lin.setX(lin.getX() + coefficients[i] * vectorArray[i].getX());
            lin.setY(lin.getY() + coefficients[i] * vectorArray[i].getY());
            lin.setZ(lin.getZ() + coefficients[i] * vectorArray[i].getZ());
        }
        
        return lin;
    }
    
    
    public Point3D[] movePoint(Point3D point) {
        if (point == null)
            throw new IllegalArgumentException();
        
        Point3D[] pointArray = new Point3D[size];
        
        for (int i = 0; i < size; i++)
            pointArray[i] = new Point3D(
                    point.getX() + vectorArray[i].getX(),
                    point.getY() + vectorArray[i].getY(),
                    point.getZ() + vectorArray[i].getZ());
        
        return pointArray;
    }
}
