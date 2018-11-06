package Figures;

public class Circle extends Figure implements Shape2D
{
    Circle(Point center, int radius,int R,int G,int B)
    {
        this.center = center;
        this.radius = radius;
        this.R=R;
        this.G=G;
        this.B=B;
    }

    protected int radius,R,G,B;
    protected Point center;

    @Override
    public double getArea() { return Math.PI * radius * radius; }
    @Override
    public double getPerimeter() { return 2 * Math.PI * radius; }
    @Override
    public void showInformations()
    {
        System.out.println("Figura: koło");
        System.out.println("Środek: ( " + this.center.getX() + " , " + this.center.getY() + " )");
        System.out.println("Promień: " + this.radius);
        System.out.println("Pole: " + this.getArea());
        System.out.println("Obwód: " + this.getPerimeter());
    }
}
