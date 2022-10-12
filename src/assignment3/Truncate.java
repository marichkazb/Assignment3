package assignment3;

public class Truncate {
    public static double truncateToNumDigits = 2;
    public static double truncateToTwoDigits(double number) {

        double truncateAuxiliary = Math.pow(10, truncateToNumDigits); //number of 0s denotes number of signs after coma
        double numberToCast = number * truncateAuxiliary;
        double numberToTruncate = (int) numberToCast;
        return numberToTruncate / truncateAuxiliary;
    }

}
