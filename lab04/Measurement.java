public class Measurement {

    private int feet;
    private int inches;
    /**
     * Constructor: initialize this object to be a measurement of 0 feet, 0
     * inches
     */
    public Measurement() {
     feet=0;inches=0;
    }

    /**
     * Constructor: takes a number of feet as its single argument, using 0 as
     * the number of inches
     */
    public Measurement(int feet) {
         this.feet=feet;
         this.inches=0;
    }

    /**
     * Constructor: takes the number of feet in the measurement and the number
     * of inches as arguments (in that order), and does the appropriate
     * initialization
     */
    public Measurement(int feet, int inches) {
         this.feet=feet;
         this.inches=inches;
    }

    /**
     * Returns the number of feet in in this Measurement. For example, if the
     * Measurement has 1 foot and 6 inches, this method should return 1.
     */
    public int getFeet() {
        return feet; // provided to allow the file to compile
    }

    /**
     * Returns the number of inches in this Measurement. For example, if the
     * Measurement has 1 foot and 6 inches, this method should return 6.
     */
    public int getInches() {
        return inches; // provided to allow the file to compile
    }

    /** Adds the argument m2 to the current measurement */
    public Measurement plus(Measurement m2) {
        Measurement x= new Measurement();
        x.feet=feet+m2.feet;
        x.inches=inches+m2.inches;
        x.feet+=x.inches/12;
        x.inches%=12;
        return x; // provided to allow the file to compile
    }

    /**
     * Subtracts the argument m2 from the current measurement. You may assume
     * that m2 will always be smaller than the current measurement.
     */
    public Measurement minus(Measurement m2) {
        Measurement x= new Measurement();
        int total=this.feet*12+this.inches;
        int total_m=m2.feet*12+m2.inches;
        x.feet=(total-total_m)/12;
        x.inches=(total-total_m)%12;
        return x; // provided to allow the file to compile
    }

    /**
     * Takes a nonnegative integer argument n, and returns a new object that
     * represents the result of multiplying this object's measurement by n. For
     * example, if this object represents a measurement of 7 inches, multiple
     * (3) should return an object that represents 1 foot, 9 inches.
     */
    public Measurement multiple(int multipleAmount) {
        Measurement x= new Measurement();
        int total=this.feet*12+this.inches;
        total*=multipleAmount;
        x.feet=(total)/12;
        x.inches=(total)%12;
        return x; // provided to allow the file to compile
    }

    /**
     * toString should return the String representation of this object in the
     * form f'i" that is, a number of feet followed by a single quote followed
     * by a number of inches less than 12 followed by a double quote (with no
     * blanks).
     */
    @Override
    public String toString() {
        String s;
        s=feet+"'"+inches+ "\"";
        return s; // provided to allow the file to compile
    }
}