public class RealNumber {

    private double value;

    public RealNumber(double v) {
        value = v;
    }

    /*
    *Return the sum of this and the other
    */
    public RealNumber add(RealNumber other) {
        return new RealNumber(getValue() + other.getValue());
    }

    /*
    *Return the product of this and the other
    */
    public RealNumber multiply(RealNumber other) {
        return new RealNumber(getValue() * other.getValue());
    }

    /*
    *Return the this divided by the other
    */
    public RealNumber divide(RealNumber other) {
        return new RealNumber(getValue() / other.getValue());
    }

    /*
    *Return the this minus the other
    */
    public RealNumber subtract(RealNumber other) {
        return new RealNumber(getValue() - other.getValue());
    }


    public double getValue() {
        return value;
    }
    
    public boolean equals(RealNumber other) {
        double thisValue = getValue();
        double otherValue = other.getValue();
        return Math.abs(thisValue - otherValue) <= 1e-3 * Math.abs(otherValue);
    }

    public String toString() {
        return ""+value;
    }

}
