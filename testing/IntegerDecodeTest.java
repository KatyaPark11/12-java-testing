package testing;

import org.junit.Test;

import static java.lang.Integer.decode;
import static org.junit.Assert.*;

public class IntegerDecodeTest {
    @Test(expected = NumberFormatException.class)
    public void textEmpty() {
        decode("");
    }

    @Test()
    public void testNegative() {
        assertEquals((int)decode("-157"), -157);
    }

    @Test()
    public void testPositive() {
        assertEquals((int)decode("+157"), 157);
    }

    @Test()
    public void textHexOx() {
        assertEquals((int)decode("0x9D"), 157);
    }

    @Test()
    public void textHexOX() {
        assertEquals((int)decode("0X9D"), 157);
    }

    @Test()
    public void textHexSharp() {
        assertEquals((int)decode("#9D"), 157);
    }

    @Test()
    public void testOct() {
        assertEquals((int)decode("0235"), 157);
    }

    @Test(expected = NumberFormatException.class)
    public void testExtraMinus() {
        decode("--157");
    }

    @Test(expected = NumberFormatException.class)
    public void testExtraPlus() {
        decode("-+157");
    }
}