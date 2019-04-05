import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class CalculatorTest {

    Calculator calculator ;

    @Before
    public void setup (){
        calculator = new Calculator();
    }

    @Test
    public  void test_add_postive() {
        int a = 5;
        int b =10;
        assertEquals(a+b,calculator.add(a,b));
    }


}