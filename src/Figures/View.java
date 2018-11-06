package Figures;

import javax.swing.*;
import java.awt.Graphics;

public class View extends JFrame
{

    View()
    {
        setSize(400,400);
        setLocation(450, 200);
        setVisible(true);
        setTitle("Rysowanie figur");
        ImageIcon img = new ImageIcon("F:\\PROGRAMOWANIE\\Programy Java\\Figures\\circle.png");
        setIconImage(img.getImage());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Graphics g = this.getGraphics();

        Draw d = new DrawCircle();
        d.draw(g);
        d = new DrawRectangle();
        d.draw(g);
        d = new DrawLine();
        d.draw(g);
    }

    public static void main(String[] args) { new View(); }
}
