package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BunTest {
    private Bun bun;

    private final float price;
    private final String name;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
                {"black bun", 100f},
                {"white bun", 200f},
                {"red bun", 300f}
        };
    }

    @Before
    public void setUp() throws Exception {
        bun = new Bun(name, price);
    }

    @Test
    public void testGetName() {
        Assert.assertEquals(name, bun.getName());
    }

    @Test
    public void testGetPrice() {
        Assert.assertEquals(price, bun.getPrice(), 0.0f);
    }
}