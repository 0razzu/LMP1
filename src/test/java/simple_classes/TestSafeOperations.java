package simple_classes;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TestSafeOperations {
    private final double EPS = 1E-9;


    @Test
    public void TestSafeOperationsSum() {
        assertAll(
                () -> assertEquals(20, SafeOperations.sum(9.5, 10.5), EPS),
                () -> assertEquals(10, SafeOperations.sum(-1.5, 11.5), EPS),
                () -> assertEquals(-10, SafeOperations.sum(-7.5, -2.5), EPS)
        );
    }


    @Test
    public void TestSafeOperationsSumExceptions() {
        assertAll(
                () -> {assertThrows(ArithmeticException.class, () -> SafeOperations.sum(Double.NaN, 0));},
                () -> {assertThrows(ArithmeticException.class, () -> SafeOperations.sum(0, Double.NaN));},
                () -> {assertThrows(ArithmeticException.class, () -> SafeOperations.sum(Double.POSITIVE_INFINITY, 0));},
                () -> {assertThrows(ArithmeticException.class, () -> SafeOperations.sum(Double.NEGATIVE_INFINITY, 0));},
                () -> {assertThrows(ArithmeticException.class, () -> SafeOperations.sum(0, Double.POSITIVE_INFINITY));},
                () -> {assertThrows(ArithmeticException.class, () -> SafeOperations.sum(0, Double.NEGATIVE_INFINITY));},
                () -> {assertThrows(ArithmeticException.class, () -> SafeOperations.sum(-EPS * Double.MAX_VALUE, -Double.MAX_VALUE));},
                () -> {assertThrows(ArithmeticException.class, () -> SafeOperations.sum(-Double.MAX_VALUE, -EPS * Double.MAX_VALUE));},
                () -> {assertThrows(ArithmeticException.class, () -> SafeOperations.sum(EPS * Double.MAX_VALUE, Double.MAX_VALUE));},
                () -> {assertThrows(ArithmeticException.class, () -> SafeOperations.sum(Double.MAX_VALUE, EPS * Double.MAX_VALUE));}
        );
    }


    @Test
    public void TestSafeOperationsDiff() {
        assertAll(
                () -> assertEquals(-1, SafeOperations.diff(9.5, 10.5), EPS),
                () -> assertEquals(-13, SafeOperations.diff(-1.5, 11.5), EPS),
                () -> assertEquals(5, SafeOperations.diff(-7.5, -12.5), EPS)
        );
    }


    @Test
    public void TestSafeOperationsDiffExceptions() {
        assertAll(
                () -> {assertThrows(ArithmeticException.class, () -> SafeOperations.diff(Double.NaN, 0));},
                () -> {assertThrows(ArithmeticException.class, () -> SafeOperations.diff(0, Double.NaN));},
                () -> {assertThrows(ArithmeticException.class, () -> SafeOperations.diff(Double.POSITIVE_INFINITY, 0));},
                () -> {assertThrows(ArithmeticException.class, () -> SafeOperations.diff(Double.NEGATIVE_INFINITY, 0));},
                () -> {assertThrows(ArithmeticException.class, () -> SafeOperations.diff(0, Double.POSITIVE_INFINITY));},
                () -> {assertThrows(ArithmeticException.class, () -> SafeOperations.diff(0, Double.NEGATIVE_INFINITY));},
                () -> {assertThrows(ArithmeticException.class, () -> SafeOperations.diff(-EPS * Double.MAX_VALUE, Double.MAX_VALUE));},
                () -> {assertThrows(ArithmeticException.class, () -> SafeOperations.diff(-Double.MAX_VALUE, EPS * Double.MAX_VALUE));},
                () -> {assertThrows(ArithmeticException.class, () -> SafeOperations.diff(EPS * Double.MAX_VALUE, -Double.MAX_VALUE));},
                () -> {assertThrows(ArithmeticException.class, () -> SafeOperations.diff(Double.MAX_VALUE, EPS * -Double.MAX_VALUE));}
        );
    }


    @Test
    public void TestSafeOperationsMul() {
        assertAll(
                () -> assertEquals(100, SafeOperations.mul(75, 4./3), EPS),
                () -> assertEquals(-11, SafeOperations.mul(-5, 2.2), EPS),
                () -> assertEquals(20, SafeOperations.mul(4, 5), EPS)
        );
    }


    @Test
    public void TestSafeOperationsMulExceptions() {
        assertAll(
                () -> {assertThrows(ArithmeticException.class, () -> SafeOperations.mul(Double.NaN, 0));},
                () -> {assertThrows(ArithmeticException.class, () -> SafeOperations.mul(0, Double.NaN));},
                () -> {assertThrows(ArithmeticException.class, () -> SafeOperations.mul(Double.POSITIVE_INFINITY, 0));},
                () -> {assertThrows(ArithmeticException.class, () -> SafeOperations.mul(Double.NEGATIVE_INFINITY, 0));},
                () -> {assertThrows(ArithmeticException.class, () -> SafeOperations.mul(0, Double.POSITIVE_INFINITY));},
                () -> {assertThrows(ArithmeticException.class, () -> SafeOperations.mul(0, Double.NEGATIVE_INFINITY));},
                () -> {assertThrows(ArithmeticException.class, () -> SafeOperations.mul(Double.MAX_VALUE, 1.5));},
                () -> {assertThrows(ArithmeticException.class, () -> SafeOperations.mul(1.5, Double.MAX_VALUE));}
        );
    }


    @Test
    public void TestSafeOperationsDiv() {
        assertAll(
                () -> assertEquals(2.5, SafeOperations.div(10, 4), EPS),
                () -> assertEquals(-9, SafeOperations.div(81, -9), EPS),
                () -> assertEquals(5, SafeOperations.div(-0.5, -0.1), EPS)
        );
    }


    @Test
    public void TestSafeOperationsDivExceptions() {
        assertAll(
                () -> {assertThrows(ArithmeticException.class, () -> SafeOperations.div(1, 0));},
                () -> {assertThrows(ArithmeticException.class, () -> SafeOperations.div(Double.NaN, 1));},
                () -> {assertThrows(ArithmeticException.class, () -> SafeOperations.div(0, Double.NaN));},
                () -> {assertThrows(ArithmeticException.class, () -> SafeOperations.div(Double.POSITIVE_INFINITY, 1));},
                () -> {assertThrows(ArithmeticException.class, () -> SafeOperations.div(Double.NEGATIVE_INFINITY, 1));},
                () -> {assertThrows(ArithmeticException.class, () -> SafeOperations.div(0, Double.POSITIVE_INFINITY));},
                () -> {assertThrows(ArithmeticException.class, () -> SafeOperations.div(0, Double.NEGATIVE_INFINITY));}
        );
    }
}