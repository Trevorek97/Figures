package Figures;

public class Line extends Figure
{
    Line(Point P1, Point P2, int R, int G, int B)
    {
        this.P1=P1;
        this.P2=P2;
        this.R=R;
        this.G=G;
        this.B=B;
    }

    protected Point P1;
    protected Point P2;
    protected int R,G,B;

    public double get_length()
    {
        double result_x = (P1.getX() - P2.getX()) * (P1.getX() - P2.getX());
        double result_y = (P1.getY() - P2.getY()) * (P1.getY() - P2.getY());
        return Math.sqrt(result_x + result_y);
    }
}
