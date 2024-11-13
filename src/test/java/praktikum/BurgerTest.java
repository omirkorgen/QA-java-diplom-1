package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;

    @Mock
    private Bun mockBun;

    @Mock
    private Ingredient mockIngredient1;

    @Mock
    private Ingredient mockIngredient2;

    @Mock
    private Ingredient mockIngredient3;

    @Before
    public void setUp() {
        burger = new Burger();

        burger.ingredients = new ArrayList<>();

        Mockito.when(mockBun.getName()).thenReturn("black bun");
        Mockito.when(mockBun.getPrice()).thenReturn(100f);

        Mockito.when(mockIngredient1.getName()).thenReturn("cutlet");
        Mockito.when(mockIngredient1.getPrice()).thenReturn(100f);
        Mockito.when(mockIngredient1.getType()).thenReturn(IngredientType.FILLING);

        Mockito.when(mockIngredient2.getName()).thenReturn("hot sauce");
        Mockito.when(mockIngredient2.getPrice()).thenReturn(100f);
        Mockito.when(mockIngredient2.getType()).thenReturn(IngredientType.SAUCE);

    }

    @Test
    public void testSetBuns() {
        burger.setBuns(mockBun);

        Assert.assertEquals("The bun should be set correctly", mockBun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(mockIngredient1);
        Assert.assertEquals(1, burger.ingredients.size());
        Assert.assertEquals(mockIngredient1, burger.ingredients.get(0));
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        burger.removeIngredient(0);

        Assert.assertEquals(1, burger.ingredients.size());
        Assert.assertEquals(mockIngredient2, burger.ingredients.get(0));
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.addIngredient(mockIngredient3);

        burger.moveIngredient(0, 2);

        Assert.assertEquals(mockIngredient2, burger.ingredients.get(0));
        Assert.assertEquals(mockIngredient3, burger.ingredients.get(1));
        Assert.assertEquals(mockIngredient1, burger.ingredients.get(2));
    }

    @Test
    public void testGetPrice() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        float price = burger.getPrice();

        float expectedPrice = 100f * 2 + 100f + 100f;
        Assert.assertEquals(expectedPrice, price, 0.0f);
    }

    @Test
    public void testGetReceipt() {
        // Arrange
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        String receipt = burger.getReceipt();

        String expectedReceipt = String.format(
                "(==== %s ====)%n" +
                        "= %s %s =%n" +
                        "= %s %s =%n" +
                        "(==== %s ====)%n" +
                        "%nPrice: %f%n",
                "black bun",
                IngredientType.FILLING.toString().toLowerCase(), "cutlet",
                IngredientType.SAUCE.toString().toLowerCase(), "hot sauce",
                "black bun",
                100f * 2 + 100f + 100f
        );
        Assert.assertEquals(expectedReceipt, receipt);
    }
}
