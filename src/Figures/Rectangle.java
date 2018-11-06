package Figures;

public class Rectangle extends Figure implements Shape2D
{

    Rectangle(Point bottom, int width, int height, int R, int G, int B)
    {
        this.bottom = bottom;
        this.width = width;
        this.height = height;
        this.R=R;
        this.G=G;
        this.B=B;
    }

    protected Point bottom;
    protected int R,G,B, width, height;

    @Override
    public double getArea() { return width*height; }
    @Override
    public double getPerimeter() { return (2*width) + (2*height); }
    @Override
    public void showInformations()
    {
        System.out.println("Figura: prostokąt");
        System.out.println("Wysokość: " + this.height);
        System.out.println("Szerokość: " + this.width);
        System.out.println("Pole: " + this.getArea());
        System.out.println("Obwód: " + this.getPerimeter());
    }
}
