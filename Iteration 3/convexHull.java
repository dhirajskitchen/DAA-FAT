import java.util.ArrayList;
import java.util.List;

class Point {
    int x, y;

    Point(int a, int b) {
        x = a;
        y = b;
    }
}

public class convexHull {
    public static int orientation(Point p, Point q, Point r) {
        int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
        if (val == 0)
            return 0;
        return val > 0 ? 1 : 2;
    }

    public static void CH(Point[] points) {
        int n = points.length;
        List<Point> hull = new ArrayList<>();
        int leftMost = 0;
        for (int i = 0; i < n; i++) {
            if (points[i].x < points[leftMost].x)
                leftMost = i;
        }
        int p = leftMost, q;
        do {
            hull.add(points[p]);
            q = (p + 1) % n;
            for (int i = 0; i < n; i++) {
                if (orientation(points[p], points[i], points[q]) == 2) {
                    q = i;
                }
            }
            p = q;
        } while (p != leftMost);

        for (Point P : hull) {
            System.out.printf("%d %d\n", P.x, P.y);
        }
    }

    public static void main(String[] args) {
        Point[] points = {
                new Point(0, 3),
                new Point(2, 2),
                new Point(1, 1),
                new Point(2, 1),
                new Point(3, 0),
                new Point(0, 0),
                new Point(3, 3)
        };

        CH(points);
    }
}
