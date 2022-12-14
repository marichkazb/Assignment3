package assignment3;

public enum Degrees {
    BSC("BSc"),
    MSC("MSc"),
    PHD("PhD");

    private final String DEGREE;

    Degrees(String type) {
        this.DEGREE = type;
    }

    public String toString() {
        return this.DEGREE;
    }
}