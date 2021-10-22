import org.junit.Test;

import static org.junit.Assert.*;

public class ModNCounterTest {

    @Test
    public void testConstructor() {
        ModNCounter c = new ModNCounter();
        assertEquals(0, c.value());
    }

    @Test
    public void testIncrement() throws Exception {
        ModNCounter c = new ModNCounter(5);
        c.increment();
        assertEquals(6, c.value());
        c.increment();
        assertEquals(7, c.value());
    }

    @Test
    public void testReset() throws Exception {
        ModNCounter c = new ModNCounter();
        c.increment();
        c.reset();
        assertEquals(0, c.value());
    }
}