package Project;

public class Utils {
    public Utils() {
        this(5);
    }

    public Utils(int r) {
        this.r = r;
    }

    static int r;

    public static int trX(double x) {
        return (int) ((x + r) / 10) - 1;
    }

    public static int trY(double y) {
        return (int) ((y + r) / 10) - 1;
    }

    public static double arcTrX(double i) {
        return (i + 1) * 10.0 - r;
    }

    public static double arcTrY(double j) {
        return (j + 1) * 10.0 - r;
    }


}
