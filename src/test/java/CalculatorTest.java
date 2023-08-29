import org.example.Calculator;
import org.junit.*;

public class CalculatorTest {
    final double DELTA = 1e-9;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("beforeClass");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("after");
    }

    //    Before BeforeClass
//    After ,After?Class
    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        double result = calculator.add(2, 6);
        Assert.assertEquals(8, result, DELTA);
        System.out.println("Test1");
    }

    @Before
    public void beforeClass2() {
        System.out.println("beforeClass2");
    }

    @After
    public void after() {
        System.out.println("after");
    }

    @Test
    public void testDivide() {
        Calculator calculator = new Calculator();
        double result = calculator.divide(12, 2);
        Assert.assertEquals(6, result, DELTA);
        System.out.println("Test2");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivideByZero() {
        Calculator calculator = new Calculator();
        calculator.divide(12, 0);
        System.out.println("Test3");
    }

    @Test(timeout = 1000)
    public void testAddMethodShouldWorkFast() {
        Calculator calculator = new Calculator();
        double result = calculator.add(2, 6);
        Assert.assertEquals(8, result, DELTA);
        System.out.println("Test4");
    }
}
