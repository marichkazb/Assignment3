package assignment3;

public class Truncate {
    public static double truncateToNumDigits;

    public static double truncateToTwoDigits(double number) {
        truncateToNumDigits = 2;
        double truncateAuxiliary = Math.pow(10, truncateToNumDigits); //number of 0s denotes number of signs after comma
        double numberToCast = number * truncateAuxiliary;
        double numberToTruncate = (int) numberToCast;
        return numberToTruncate / truncateAuxiliary;
    }

}
