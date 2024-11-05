public class Point {
    private double x;
    private double y;
    private String name;

    public Point(double x, double y,String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    public String getName(){
        return name;
    }

    public double distance(Point other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void set(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name+"("+x+","+y+"),";
    }
}