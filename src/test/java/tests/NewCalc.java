package tests;

import objects.CalcPage;
import objects.Keys;
import org.junit.*;


public class NewCalc extends BaseTest {

    static CalcPage calc = new CalcPage(driver);

    @BeforeClass
    public static void openPage() {
        calc.open();
    }

    @Before
    public void cleanup() {
        calc.clear();
    }

    @Test

    public void add_test() {
        calc.click_8();
        calc.click_plus();
        calc.click_2();
        calc.click_equal();
        Assert.assertEquals("10", calc.getResult());
    }

    @Test
    public void subtract_test() {
        calc.click("1");
        calc.click("-");
        calc.click("7");
        calc.click("=");
        Assert.assertEquals("-6", calc.getResult());
    }

    @Test
    public void multiply_test() {
        calc.click(Keys.SIX);
        calc.click(Keys.MULTIPLY);
        calc.click(Keys.EIGHT);
        calc.click(Keys.EQUAL);
        Assert.assertEquals("48", calc.getResult());
    }

    @Test
    public void division_test() {
        calc.click_7();
        calc.click("/");
        calc.click(Keys.TWO);
        calc.click_equal();
        Assert.assertEquals("3.5", calc.getResult());
    }

}