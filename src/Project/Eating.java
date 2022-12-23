package Project;

import static Project.Utils.arcTrX;
import static Project.Utils.arcTrY;

public class Eating {
    public static final int R = 1;
    public double x, y;
    public int ii, jj;

    public Eating(int i, int j) {
        x = arcTrX(i);
        y = arcTrY(j);

        ii = i;
        jj = j;
    }

}
