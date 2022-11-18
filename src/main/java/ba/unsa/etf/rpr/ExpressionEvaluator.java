package ba.unsa.etf.rpr;

import java.util.Stack;

import static java.lang.Math.sqrt;

/***
 *Class for evaluating an arithmetic expression
 * @author Berin Karahodžić
 * @version 1.0
 */
public class ExpressionEvaluator {
    /**
     * Method used for calculating
     * @param s string that contains the expression
     * @return value of the expresssion
     */
    public Double evaluate(String s)
    {
        Checker c=new Checker();
        if(!c.Check(s))throw new RuntimeException("Invalid arithmetic expression");
        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();
        for(String str: s.split(" "))
        {
            if(str.equals("("));
            else if(str.equals("+")) ops.push(str);
            else if(str.equals("-")) ops.push(str);
            else if(str.equals("*")) ops.push(str);
            else if(str.equals("/")) ops.push(str);
            else if(str.equals("sqrt")) ops.push(str);
            else if(str.equals(")")){
                String op=ops.pop();
                double v=vals.pop();
                if(op.equals("+"))v=vals.pop()+v;
                else if(op.equals("-"))v=vals.pop()-v;
                else if(op.equals("*"))v=vals.pop()*v;
                else if(op.equals("/"))v=vals.pop()/v;
                else if(op.equals("sqrt"))v=sqrt(v);
                vals.push(v);
            }
            else vals.push(Double.parseDouble(str));
        }
        return vals.pop();
    }
}
