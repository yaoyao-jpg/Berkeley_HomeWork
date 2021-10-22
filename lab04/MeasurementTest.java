import org.junit.Test;

import static org.junit.Assert.*;

public class MeasurementTest {
    @Test
    public void testPlus() {
        Measurement a=new Measurement(1,10);
        Measurement b=new Measurement(1,10);
        Measurement c=new Measurement();
        c=a.plus(b);
        assertEquals(3,c.getFeet());
        assertEquals(8,c.getInches());
    }
    @Test
    public void testMinus() {
        Measurement a=new Measurement(2,5);
        Measurement b=new Measurement(1,10);
        Measurement c=new Measurement();
        c=a.minus(b);
        assertEquals(0,c.getFeet());
        assertEquals(7,c.getInches());
    }
    @Test
    public void testMultiply()
    {
        Measurement a=new Measurement(1,10);
        Measurement c=new Measurement();
        c=a.multiple(3);
        assertEquals(5,c.getFeet());
        assertEquals(6,c.getInches());
    }
    @Test
    public void testToString()
    {
        Measurement a=new Measurement(2,5);
        assertEquals("2'5\"",a.toString());
    }
    // TODO: Add additional JUnit tests for Measurement.java here.

}