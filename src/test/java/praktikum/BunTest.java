package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.*;

public class BunTest {

    @Test
    public void testGetName() {
        Bun bun = new Bun("Sesame", 1.99f);
        Assert.assertEquals("Sesame", bun.getName());
    }

    @Test
    public void testGetPrice() {
        Bun bun = new Bun("Sesame", 1.99f);
        Assert.assertEquals(1.99f, bun.getPrice(), 0.0f);
    }
}