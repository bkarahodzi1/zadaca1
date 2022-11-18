package ba.unsa.etf.rpr;


/***
 * Class used for checking, calculating and writing the result of an arithmetic expression
 */
public class App {
    /**
     * main method
     * @param args array of strings with only one element, the expression
     */
    public static void main(String[] args) {
        ExpressionEvaluator e=new ExpressionEvaluator();
        double res=e.evaluate(args[0]);
        System.out.println("Result: "+res);
        return;
    }
}