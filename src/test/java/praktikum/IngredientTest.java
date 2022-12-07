package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType ingredientType;
    private final String testName ;
    private final float testPrice;
    private Ingredient ingredient;


    public IngredientTest(IngredientType ingredientType, String testName, float testPrice) {
        this.ingredientType = ingredientType;
        this.testName = testName;
        this.testPrice = testPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getSumData() {
        return new Object[][] {
                {IngredientType.SAUCE, "craps-burger", 20.0F},
                {IngredientType.FILLING, "dual-burger", 15.0F},
                {IngredientType.FILLING, "burger", 100.0F},
                {IngredientType.SAUCE, "burger", 1000.0F},
        };
    }

    @Before
    public void setUp(){
        ingredient = new Ingredient(ingredientType, testName, testPrice);
    }


    @Test
    public void getPriceTest() {
        Assert.assertEquals("Ошибка в методе возвращения цены бургера", ingredient.getPrice(), testPrice, 0.0f);
    }

    @Test
    public void getNameTest() {
        Assert.assertEquals("Ошибка в методе возвращения названия бургера", ingredient.getName(), testName);
    }

    @Test
    public void getTypeTest() {
        Assert.assertEquals("Ошибка в методе возвращения типа ингридиентов", ingredient.getType(), ingredientType);
    }
}