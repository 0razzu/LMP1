package simple_classes;


public final class SafeOperations {
    public static double sum(double x, double y) throws ArithmeticException {
        if ((Double.isNaN(x)) || (Double.isNaN(y)) ||
            (Double.isInfinite(x)) || (Double.isInfinite(y)) ||
            ((y < 0) && (x < -Double.MAX_VALUE - y)) ||
            ((y > 0) && (x > Double.MAX_VALUE - y)))
            throw new ArithmeticException();

        return x + y;
    }


    public static double diff(double x, double y) throws ArithmeticException {
        return sum(x, -y);
    }


    public static double mul(double x, double y) throws ArithmeticException {
        if ((Double.isNaN(x)) || (Double.isNaN(y)) ||
            (Double.isInfinite(x)) || (Double.isInfinite(y)) ||
            (Math.abs(x) > Double.MAX_VALUE / Math.abs(y)))
            throw new ArithmeticException();

        return x * y;
    }


    public static double div(double x, double y) throws ArithmeticException {
        if ((y == 0) || (Double.isInfinite(y)))
            throw new ArithmeticException();

        return mul(x, 1 / y);
    }
}