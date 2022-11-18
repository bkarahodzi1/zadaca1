package ba.unsa.etf.rpr;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Class for testing class ExpressionEvaluator
 */
public class ExpressionEvaluatorTest
{
    ExpressionEvaluator s=new ExpressionEvaluator();
    /**
     * first 4 tests should be without exceptions
     * other 4 are for exceptions
     */
    @Test
    void test1() {
        double x=s.evaluate("( ( sqrt ( 4 ) + ( 2 * 5 ) ) / 6 )");
        assertEquals(x,2);
    }
    @Test
    void test2() {
        double x=s.evaluate("( ( 7 + ( 8 - 4 ) ) * 4 )");
        assertEquals(x,44);
    }
    @Test
    void test3() {
        double x=s.evaluate("( ( ( ( 5 * 2 ) * 5 ) + 5 ) / 2 )");
        assertEquals(x,27.5);
    }
    @Test
    void test4() {
        double x=s.evaluate("sqrt ( 4 )");
        assertEquals(x,2);
    }
    @Test
    void test5() {
        String str="( 5 + 2 ) )";
        assertThrows(RuntimeException.class, () -> s.evaluate(str));
    }
    @Test
    void test6() {
        String str="( 5 + 2)";
        assertThrows(RuntimeException.class, () -> s.evaluate(str));
    }
    @Test
    void test7() {
        String str="( 5 +2)";
        assertThrows(RuntimeException.class, () -> s.evaluate(str));
    }
    @Test
    void test8() {
        String str="( sqrt ( 4 ) )";
        assertThrows(RuntimeException.class, () -> s.evaluate(str));
    }
}
