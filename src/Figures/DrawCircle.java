package Figures;

import java.awt.*;
import javax.swing.*;

public class DrawCircle extends JEditorPane implements Draw
{
    Circle circle;
    Parser parser;

    public void draw(Graphics g)
    {
        parser = new ParserCircle();
        circle = (Circle) parser.getData();
        Insets b = getInsets();
        g.translate(b.left, b.top);
        g.setColor(new Color(circle.R, circle.G, circle.B));
        g.fillOval(circle.center.getX(),circle.center.getY(),circle.radius,circle.radius);
    }
}
