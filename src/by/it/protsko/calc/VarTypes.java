package by.it.protsko.calc;

public enum VarTypes {
    SCALAR(1),
    VECTOR(2),
    MATRIX(3);

    private int order;

    VarTypes(int order) {
        this.order = order;
    }

    public static VarTypes getByOrderCode(int code) {
        for (VarTypes t : values()) {
            if (t.order == code) {
                return t;
            }
        }
        throw new IllegalArgumentException("No such element for code: " + code);
    }
}
