package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class BunTest {

    private final String testName = "craps-burger";
    private final float testPrice = 20.0F;

    Bun bun = new Bun(testName, testPrice);

    @Test
    public void getNameTest() {
        Assert.assertEquals("Ошибка в методе возвращения названия бургера", bun.getName(), testName);
    }

    @Test
    public void getPriceTest() {
        Assert.assertEquals("Ошибка в методе возвращения цены бургера", bun.getPrice(), testPrice, 0.0f);
    }
}