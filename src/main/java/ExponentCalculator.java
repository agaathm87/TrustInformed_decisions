package nl.uva.exp;

public class ExponentCalculator {
    public static double calculateExponent(String x) {
        double xInt = Double.parseDouble(x);
        // Use the Math.exp method to calculate the exponent
        return Math.exp(xInt);
    }   
}
