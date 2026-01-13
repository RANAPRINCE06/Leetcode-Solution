class Solution {
    public double separateSquares(int[][] squares) {
        double total = 0.0;
        double maxTop = 0.0;

        for (int[] s : squares) {
            double l = s[2];
            total += l * l;
            maxTop = Math.max(maxTop, s[1] + s[2]);
        }

        double target = total / 2.0;
        double lo = 0.0, hi = maxTop;

        for (int i = 0; i < 100; i++) {
            double mid = (lo + hi) / 2.0;
            if (areaBelow(squares, mid) < target) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private double areaBelow(int[][] squares, double h) {
        double area = 0.0;
        for (int[] s : squares) {
            double y = s[1], l = s[2];
            if (y < h) {
                area += Math.min(h - y, l) * l;
            }
        }
        return area;
    }
}