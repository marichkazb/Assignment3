package assignment3.Employee;

public class Truncate {


    public static double truncateToNumDigits = 100; //number of 0s denotes number of signs after coma
    public static double truncateToTwoDigits(double number) {
        //todo why doesn't it return 00 after coma(only 0) -????

        double numberToCast = number * truncateToNumDigits;
        double numberToTruncate = (int) numberToCast;
        double truncatedNumber = numberToTruncate / truncateToNumDigits;
        return Double.parseDouble(String.format("%.2f", truncatedNumber));

//        String.format("%.2f", Math.floor(Math.pow(10, 2) * number)/Math.pow(10, 2));
    }

}
