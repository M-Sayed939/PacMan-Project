package Project;

public class Utils {

    static int r = 5;

    public static int trX(double x) {
        return (int) ((x + r) / 10) - 1;
    }

    public static int trY(double y) {
        return (int) ((y + r) / 10) - 1;
    }

    public static double arcTrX(int i) {
        return (i + 1) * 10.0 - r;
    }

    public static double arcTrY(int j) {
        return (j + 1) * 10.0 - r;
    }


}
