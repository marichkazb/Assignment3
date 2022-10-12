package assignment3;

public enum Depts {
    BUSINESS("Business"),
    HUMAN_RESOURCES("HumanResources"),
    TECHNICAL("Technical");

    private final String DEPT;

    Depts(String type) {
        this.DEPT = type;
    }

    public String toString() {
        return this.DEPT;
    }
}