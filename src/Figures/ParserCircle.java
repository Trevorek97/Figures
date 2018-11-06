package Figures;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.Collections;

import org.json.*;

public class ParserCircle implements Parser
{
    public int len;
    File inputFile = null;
    DocumentBuilderFactory dbFactory = null;
    DocumentBuilder dBuilder = null;
    Document doc = null ;
    NodeList nList = null;
    Validator validator;

    ParserCircle()
    {
        try
        {
            inputFile = new File("F:\\PROGRAMOWANIE\\Programy Java\\Figures\\figures.xml");
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            nList = doc.getElementsByTagName("circle");
            len = nList.getLength();
        } catch (Exception e) { e.printStackTrace(); }
    }

    @Override
    public Circle getData()
    {
        validator = new Validator();
        Node nNode = nList.item(0);
        Element eElement = (Element) nNode;

        //Odczyt z XML
        String Ax = eElement.getElementsByTagName("punktA_x").item(0).getTextContent();
        String Ay = eElement.getElementsByTagName("punktA_y").item(0).getTextContent();
        String rad = eElement.getElementsByTagName("promień").item(0).getTextContent();
        String r = eElement.getElementsByTagName("R").item(0).getTextContent();
        String g = eElement.getElementsByTagName("G").item(0).getTextContent();
        String b = eElement.getElementsByTagName("B").item(0).getTextContent();

        //Sprawdzenie czy odczytane dane to liczby
        validator.isNumeric(Ax, "KOŁO");
        validator.isNumeric(Ay, "KOŁO");
        validator.isNumeric(rad, "KOŁO");
        validator.isNumeric(r, "KOŁO");
        validator.isNumeric(g, "KOŁO");
        validator.isNumeric(b, "KOŁO");

        //Konwersja odczytanych danych na typ Integer
        int d_Ax = Integer.parseInt(Ax);
        int d_Ay = Integer.parseInt(Ay);
        int radius = Integer.parseInt(rad);
        int R = Integer.parseInt(r);
        int G = Integer.parseInt(g);
        int B = Integer.parseInt(b);

        //Sprawdzenie czy liczby spełniają wymagania
        validator.checkFigures(d_Ax, "KOŁO");
        validator.checkFigures(d_Ay, "KOŁO");
        validator.checkFigures(radius, "KOŁO");
        validator.checkColors(R, "R", "KOŁO");
        validator.checkColors(G, "G", "KOŁO");
        validator.checkColors(B, "B", "KOŁO");

        Point A = new Point(d_Ax, d_Ay);
        return new Circle(A, radius, R, G, B);
    }
}
