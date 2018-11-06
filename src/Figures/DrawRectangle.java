package Figures;

import java.awt.*;
import javax.swing.*;

public class DrawRectangle extends JEditorPane implements Draw
{
    Rectangle rectangle;
    Parser parser;

    public void draw(Graphics g)
    {
        parser = new ParserRectangle();
        rectangle = (Rectangle) parser.getData();
        Insets b=getInsets();
        g.translate (b.left, b.top);
        g.setColor( new Color( rectangle.R, rectangle.G, rectangle.B));
        g.fillRect(rectangle.bottom.getX(),rectangle.bottom.getY(),rectangle.width,rectangle.height);
    }
}
