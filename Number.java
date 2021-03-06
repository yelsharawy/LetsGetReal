public abstract class Number {

    public abstract double getValue();

    /**
    *return 0 when this Number equals the other RealNumber
    *return a negative value when this Number is smaller than the other Number
    *return a positive value when this Number is larger than the other Number
    */
    public int compareTo(Number other) {
        return equals(other) ? 0 : Double.compare(getValue(), other.getValue());
    }

    /**
    *Return true when the % difference of the values
    *are within 0.00001 of eachother.
    *Special case: if one is exactly zero, the other must be exactly zero.
    */
    public boolean equals(Number other) {
        double thisValue = getValue();
        double otherValue = other.getValue();
        return Math.abs(thisValue - otherValue) <= 1e-5 * Math.abs(otherValue);
    }

}
