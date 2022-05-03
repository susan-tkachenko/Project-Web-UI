public class Triangle {

    public static double square(int a, int b, int c) {
        long la = a, lb = b, lc = c;

        if ((la + lb <= lc) || (lb + lc <= la) || (la + lc <= lb)) {
            throw new IllegalArgumentException("Invalid triangle side length");
        }

        double perimeter = la + lb + lc;
        double p = perimeter / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

}
