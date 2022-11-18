package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/***
 * Class for checking the validity of an arithmetic expression
 * @author Berin Karahodžić
 * @version 1.0
 */
public class Checker {
    Integer i;

    /**
     * Check is a method that calls a recursive method for help with checking
     * It itself checks that there is a right amount of opened and closed brackets, as well as a right amount of spaces
     * It also casts the string to an Array of split strings and then adds brackets around the sqrt command, so it can be checked more easily
     * @param s string that contains the arithmetic expression
     * @return true if the expression is correct false if not
     */
    public boolean Check(String s) {
        if(s == null) return false;
        if(!s.equals(s.trim()))return false;
        s=s.trim();
        String[] n= s.split(" ");
        List<String> pom = new ArrayList<String>();
        Collections.addAll(pom,n);
        for(int i=0;i<pom.size();i++){
            if(pom.get(i).equals("sqrt")){
                pom.add(i,"(");
                pom.add(i+4,")");
                i++;
            }
        }
        int bro=0,brz=0,brop=0;
        for (String value : pom) {
            if (value.equals(" ")) return false;
            else if (value.equals("(")) bro++;
            else if (value.equals(")")) brz++;
            else if (value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/"))
                brop++;
            else if(value.equals("sqrt"))brop+=2;
        }
        if(brop!=bro || bro!=brz)return false;
        i=0;
        if(pom.get(0).equals("(")){
            i++;
            return RecursiveChecker(pom,this);
        }
        return false;
    }

    /**
     * RecursiveChecker is a method that calls itself everytime it finds an open bracket, so it can check the validity of the expression
     * @param s a list of strings made of brackets, operators and operands
     * @param a an instance of the object Checker so the increment can be changed at every call of the function
     * @return true if the expression is correct false if not
     */
    public boolean RecursiveChecker(List<String> s, Checker a)
    {
        if(s.get(i).equals("(")){
            i++;
            if(!RecursiveChecker(s,a))return false;
            if (s.get(i).equals("+") || s.get(i).equals("-") || s.get(i).equals("*") || s.get(i).equals("/")) {
                i++;
                if (s.get(i).equals("(")) {i++;if(!RecursiveChecker(s, a))return false;}
                else {
                    try {
                        double d2 = Double.parseDouble(s.get(i));
                        i++;
                    } catch (NumberFormatException nfe) {
                        return false;
                    }
                }
            } else return false;
        }
        else {
            if(s.get(i).equals("sqrt")){
                i++;
                if(!s.get(i).equals("("))return false;
                i++;
                try {
                    double d = Double.parseDouble(s.get(i));
                    i++;
                    if(!s.get(i).equals(")")) return false;
                    i++;
                } catch (NumberFormatException nfe) {
                    return false;
                }
            }
            else {
                try {
                    double d = Double.parseDouble(s.get(i));
                    i++;
                    if (s.get(i).equals("+") || s.get(i).equals("-") || s.get(i).equals("*") || s.get(i).equals("/")) {
                        i++;
                        if (s.get(i).equals("(")) {
                            i++;
                            RecursiveChecker(s, a);
                        }
                        else {
                            try {
                                double d2 = Double.parseDouble(s.get(i));
                                i++;
                            } catch (NumberFormatException nfe) {
                                return false;
                            }
                        }
                    } else return false;
                } catch (NumberFormatException nfe) {
                    return false;
                }
            }
        }
        if(s.get(i).equals(")")){
            i++;
            return true;
        }
        return false;
    }
}
