package course2_laba2;

class Triangle {

    double x1, x2, x3, y1, y2, y3;
    double key;

    Triangle(double x1, double x2, double x3, double y1, double y2, double y3) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
        key = calculateArea();
    }

    public boolean isTriangle() {
        double a, b, c;
        a = Math.sqrt(Math.pow(x2 - x1, 2.0) + Math.pow(y2 - y1, 2.0));
        b = Math.sqrt(Math.pow(x3 - x2, 2.0) + Math.pow(y3 - y2, 2.0));
        c = Math.sqrt(Math.pow(x1 - x3, 2.0) + Math.pow(y1 - y3, 2.0));
        if (a + b > c && b + c > a && a + c > b) {
            return true;
        }
        return false;
    }

    public double calculatePerimeter() {
        if (isTriangle()) {
            double perimeter = Math.sqrt(Math.pow(x2 - x1, 2.0) + Math.pow(y2 - y1, 2.0))
                    + Math.sqrt(Math.pow(x3 - x2, 2.0) + Math.pow(y3 - y2, 2.0))
                    + Math.sqrt(Math.pow(x1 - x3, 2.0) + Math.pow(y1 - y3, 2.0));
            return perimeter;
        }
        return 0;
    }

    public double calculateArea() {
        if (isTriangle()) {
            double area = 0.5 * Math.abs((x2 - x1) * (y3 - y1) + (y2 - y1) * (x3 - x1));
            return area;
        }
        return 0;
    }

    public void showTringle() {
        if (isTriangle()) {
            System.out.println("Points of the triangle: \n A = (" + x1 + ", "
                    + y1 + "); \n B = (" + x2 + ", " + y2 + "); \n C = (" + x3
                    + ", " + y3 + ");");
        } else {
            System.out.println("Empty!!!");
        }
    }
}
