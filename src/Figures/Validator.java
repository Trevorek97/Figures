package Figures;

import javax.swing.*;

public class Validator
{
    String message;

    public void checkColors(int col, String color, String figure)
    {
        if(col<0 || col>255)
        {
            message ="Wprowadzono niepoprawny numer koloru " + color + " w figurze " + figure;
            JOptionPane.showMessageDialog(new JFrame(), message, "KRYTYCZNY BŁĄD", JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        }
    }

    public void checkFigures(int size, String figure)
     {
         String message;
         if(size<0 || size > 400)
         {
             message ="Wymiary wprowadzone w figurze " + figure + " są nieprawidłowe!";
             JOptionPane.showMessageDialog(new JFrame(), message, "KRYTYCZNY BŁĄD", JOptionPane.ERROR_MESSAGE);
             System.exit(-1);
         }
     }

    public void isNumeric(String str, String figure)
    {
        try
        {
            int d = Integer.parseInt(str);
        }
        catch(NumberFormatException nfe)
        {
            message ="Wprowadzono dane nie bedące liczbami typu Integer w figurze " + figure;
            JOptionPane.showMessageDialog(new JFrame(), message, "KRYTYCZNY BŁĄD", JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        }
    }
}
