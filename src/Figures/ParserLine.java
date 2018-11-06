package Figures;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class ParserLine implements Parser
{
    public int len;
    File inputFile = null;
    DocumentBuilderFactory dbFactory = null;
    DocumentBuilder dBuilder = null;
    Document doc = null ;
    NodeList nList = null;
    Validator validator;
    ParserLine()
    {
        try
        {
            inputFile = new File("F:\\PROGRAMOWANIE\\Programy Java\\Figures\\figures.xml");
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            nList = doc.getElementsByTagName("line");
            len = nList.getLength();
        } catch (Exception e) { e.printStackTrace(); }
    }

    @Override
    public Line getData()
    {
        validator = new Validator();
        Node nNode = nList.item(0);
        Element eElement = (Element) nNode;

        //Odczyt z XML
        String Ax=eElement.getElementsByTagName("punktA_x").item(0).getTextContent();
        String Ay=eElement.getElementsByTagName("punktA_y").item(0).getTextContent();
        String Bx=eElement.getElementsByTagName("punktB_x").item(0).getTextContent();
        String By=eElement.getElementsByTagName("punktB_y").item(0).getTextContent();
        String r=eElement.getElementsByTagName("R").item(0).getTextContent();
        String g=eElement.getElementsByTagName("G").item(0).getTextContent();
        String b=eElement.getElementsByTagName("B").item(0).getTextContent();

        //Sprawdzenie czy odczytane dane to liczby
        validator.isNumeric(Ax, "LINIA");
        validator.isNumeric(Ay, "LINIA");
        validator.isNumeric(Bx, "LINIA");
        validator.isNumeric(By, "LINIA");
        validator.isNumeric(r, "LINIA");
        validator.isNumeric(g, "LINIA");
        validator.isNumeric(b, "LINIA");

        //Konwersja odczytanych danych na typ Integer
        int d_Ax = Integer.parseInt(Ax);
        int d_Ay = Integer.parseInt(Ay);
        int d_Bx = Integer.parseInt(Bx);
        int d_By = Integer.parseInt(By);
        int R = Integer.parseInt(r);
        int G = Integer.parseInt(g);
        int B = Integer.parseInt(b);

        //Sprawdzenie czy liczby spełniają wymagania
        validator.checkFigures(d_Ax, "LINIA");
        validator.checkFigures(d_Ay, "LINIA");
        validator.checkFigures(d_Bx, "LINIA");
        validator.checkFigures(d_By, "LINIA");
        validator.checkColors(R, "R", "LINIA");
        validator.checkColors(G, "G", "LINIA");
        validator.checkColors(B, "B", "LINIA");

        Point P1 = new Point(d_Ax, d_Ay);
        Point P2 = new Point(d_Bx, d_By);
        return new Line(P1,P2,R,G,B);
    }
}
