public class RationalNumber extends RealNumber  {

    private int numerator, denominator;

    /**Initialize the RationalNumber with the provided values
    *  if the denominator is 0, make the fraction 0/1 instead
    *@param nume the numerator
    *@param deno the denominator
    */
    public RationalNumber(int nume, int deno) {
        super(deno == 0 ? 0.0 : (double)nume/deno);
        if (deno == 0) {
            numerator = 0;
            denominator = 1;
        } else {
            numerator = nume;
            denominator = deno;
            reduce();
        }
    }
    /*
    @Override
    public double getValue() {
        return (double)numerator/denominator;
    }
    */
    /**
    *@return the numerator
    */
    public int getNumerator() {
        return numerator;
    }

    /**
    *@return the denominator
    */
    public int getDenominator() {
        return denominator;
    }

    /**
    *@return a new RationalNumber that has the same numerator
    *and denominator as this RationalNumber but reversed.
    */
    public RationalNumber reciprocal() {
        return new RationalNumber(getDenominator(), getNumerator());
    }

    /**
    *@return true when the RationalNumbers have the same numerators and denominators, false otherwise.
    */
    public boolean equals(RationalNumber other) {
        return getNumerator() == other.getNumerator() &&
                getDenominator() == other.getDenominator();
    }


    /**
    *@return the value expressed as "3/4" or "8/3"
    */
    @Override
    public String toString() {
        return denominator == 1 ? Integer.toString(numerator) :
                numerator + "/" + denominator;
    }

    /**Calculate the GCD of two integers.
    *@param a the first integer
    *@param b the second integer
    *@return the value of the GCD (with the same sign as <code>b</code>)
    */
    private static int gcd(int a, int b) {
        if (a < 0 ^ b < 0) return gcd(-a, b);  // cuz Java's % is not mod
        while (b != 0) {
            int oldB = b;
            b = a % b;
            a = oldB;
        }
        return a;
    }

    /**
    *Divide the numerator and denominator by the GCD
    *This must be used to maintain that all RationalNumbers are
    *reduced after construction.
    */
    private void reduce() {
        int divideBy = gcd(numerator, denominator);
        numerator /= divideBy;
        denominator /= divideBy;
    }

    /******************Operations Return a new RationalNumber!!!!****************/
    /**
    *Return a new RationalNumber that is the product of this and the other
    */
    public RationalNumber multiply(RationalNumber other) {
        return new RationalNumber(getNumerator()*other.getNumerator(),
                                  getDenominator()*other.getDenominator());
    }

    /**
    *Return a new RationalNumber that is the this divided by the other
    */
    public RationalNumber divide(RationalNumber other) {
        return new RationalNumber(getNumerator()*other.getDenominator(),
                                  getDenominator()*other.getNumerator());
    }

    /**
    *Return a new RationalNumber that is the sum of this and the other
    */
    public RationalNumber add(RationalNumber other) {
        int a = getNumerator();
        int b = getDenominator();
        int c = other.getNumerator();
        int d = other.getDenominator();
        return new RationalNumber(a*d + c*b, b*d);
    }

    /**
    *Return a new RationalNumber that this minus the other
    */
    public RationalNumber subtract(RationalNumber other) {
        int a = getNumerator();
        int b = getDenominator();
        int c = other.getNumerator();
        int d = other.getDenominator();
        return new RationalNumber(a*d - c*b, b*d);
    }

}
