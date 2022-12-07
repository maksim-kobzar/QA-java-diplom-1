package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private final String burgerNameTest = "craps-burger";
    private final String ingredientNameTest = "cutlet";
    private final float burgerPriceTest = 20f;
    private final float ingredientPriceTest = 10f;


    Burger burger = new Burger();
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(burgerPriceTest);
        Assert.assertEquals("Ошибка в методе получения цены бургера", burger.getPrice(), burgerPriceTest * 2, 0.0f);
    }

    @Test
    public void getPriceIngredientTest() {
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(burgerPriceTest);
        burger.addIngredient(ingredient);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPriceTest);

        float expected = burgerPriceTest * 2 + ingredientPriceTest;
        Assert.assertEquals("Ошибка в расчетах бургера с ингридиентом", burger.getPrice(), expected, 0.0f);
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn(burgerNameTest);
        Mockito.when(bun.getPrice()).thenReturn(burgerPriceTest);
        Mockito.when(ingredient.getType()).thenReturn(SAUCE);
        Mockito.when(ingredient.getName()).thenReturn(ingredientNameTest);
        System.out.println(burger.getReceipt());

        Assert.assertNotNull("Ошибка в методе возврата рецепта", burger.getReceipt());
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient);
        burger.ingredients.add(ingredient);
        burger.ingredients.add(ingredient);
        burger.removeIngredient(2);
    }

    @Test
    public void addIngredientTest() {
        Ingredient ingredient = new Ingredient(SAUCE, "onion", 15f);
        burger.addIngredient(ingredient);
        Assert.assertFalse("Ошибка при в методе добавления бургера", burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientTest() {
        burger.ingredients.add(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        burger.ingredients.add(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        burger.ingredients.add(new Ingredient(IngredientType.SAUCE, "chili sauce", 300));
        burger.moveIngredient(0, 2);
        Assert.assertEquals("Ошибка в методе изменения места в списке", burger.ingredients.size(), 3);
    }
}