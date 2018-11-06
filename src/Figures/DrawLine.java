package Figures;

import java.awt.*;
import javax.swing.*;

public class DrawLine extends JEditorPane implements Draw
{
    Line line;
    Parser parser;

    public void draw(Graphics g)
    {
        parser = new ParserLine();
        line = (Line) parser.getData();
        Insets b = getInsets();
        g.translate (b.left, b.top);
        g.setColor(new Color( line.R, line.G, line.B));
        g.drawLine(line.P1.getX(),line.P1.getY(),line.P2.getX(),line.P2.getY());
    }
}
