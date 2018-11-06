package Figures;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class ParserRectangle implements Parser
{
        public int len;
        File inputFile = null;
        DocumentBuilderFactory dbFactory = null;
        DocumentBuilder dBuilder = null;
        Document doc = null ;
        NodeList nList = null;
        Validator validator;
        ParserRectangle()
        {
            try
            {
                inputFile = new File("F:\\PROGRAMOWANIE\\Programy Java\\Figures\\figures.xml");
                dbFactory = DocumentBuilderFactory.newInstance();
                dBuilder = dbFactory.newDocumentBuilder();
                doc = dBuilder.parse(inputFile);
                doc.getDocumentElement().normalize();
                nList = doc.getElementsByTagName("rectangle");
                len = nList.getLength();
            } catch (Exception e) { e.printStackTrace(); }
        }

        @Override
        public Rectangle getData()
        {
            validator = new Validator();
            Node nNode = nList.item(0);
            Element eElement = (Element) nNode;

            //Odczyt z XML
            String Ax=eElement.getElementsByTagName("punktA_x").item(0).getTextContent();
            String Ay=eElement.getElementsByTagName("punktA_y").item(0).getTextContent();
            String wid=eElement.getElementsByTagName("szerokość").item(0).getTextContent();
            String hei=eElement.getElementsByTagName("wysokość").item(0).getTextContent();
            String r=eElement.getElementsByTagName("R").item(0).getTextContent();
            String g=eElement.getElementsByTagName("G").item(0).getTextContent();
            String b=eElement.getElementsByTagName("B").item(0).getTextContent();

            //Sprawdzenie czy odczytane dane to liczby
            validator.isNumeric(Ax, "PROSTOKĄT");
            validator.isNumeric(Ay, "PROSTOKĄT");
            validator.isNumeric(wid, "PROSTOKĄT");
            validator.isNumeric(hei, "PROSTOKĄT");
            validator.isNumeric(r, "PROSTOKĄT");
            validator.isNumeric(g, "PROSTOKĄT");
            validator.isNumeric(b, "PROSTOKĄT");

            //Konwersja odczytanych danych na typ Integer
            int d_Ax = Integer.parseInt(Ax);
            int d_Ay = Integer.parseInt(Ay);
            int width = Integer.parseInt(wid);
            int height = Integer.parseInt(hei);
            int R = Integer.parseInt(r);
            int G = Integer.parseInt(g);
            int B = Integer.parseInt(b);

            //Sprawdzenie czy liczby spełniają wymagania
            validator.checkFigures(d_Ax, "PROSTOKĄT");
            validator.checkFigures(d_Ay, "PROSTOKĄT");
            validator.checkFigures(width, "PROSTOKĄT");
            validator.checkFigures(height, "PROSTOKĄT");
            validator.checkColors(R, "R", "PROSTOKĄT");
            validator.checkColors(G, "G", "PROSTOKĄT");
            validator.checkColors(B, "B", "PROSTOKĄT");

            Point A = new Point(d_Ax, d_Ay);
            return new Rectangle(A,width,height,R,G,B);
        }
    }
