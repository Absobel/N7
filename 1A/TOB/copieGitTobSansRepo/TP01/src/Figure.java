public class Figure {
    public static void main(String[] args) {
        // Construction figure 1
        Point p1 = new Point(2,3);
        Point p2 = new Point(4,11);
        Point p3 = new Point(9,6);

        Segment s1 = new Segment(p1, p2);
        Segment s2 = new Segment(p2, p3);
        Segment s3 = new Segment(p3, p1);

        // Barycentre
        double barycentre_x = (p1.getX() + p2.getX() + p3.getX()) / 3;
        double barycentre_y = (p1.getY() + p2.getY() + p3.getY()) / 3;
        Point barycentre = new Point(barycentre_x, barycentre_y);
    }
}
