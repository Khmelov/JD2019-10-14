package by.it.kharitonenko.jd02_03.Utils;

/**
 * List of all goods with their prices. Both can be edited here.
 */
public enum Goods {
    APPLES(1, "Apple"),
    MILK(2, "Milk"),
    EGGS(2, "Eggs"),
    MEAT(4, "Meat"),
    COFFEE(4, "Coffee"),
    CIGARETTES(3, "Cigar"),
    VEGETABLES(2, "Soda");

    private final int PRICE;
    private final String NAME;

    Goods(int price, String name) {
        this.PRICE = price;
        this.NAME = name;
    }

    public int getPRICE() {
        return PRICE;
    }

    public String getNAME() {
        return NAME;
    }
}
