package praktikum;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

public class IngredientTypeTest {
    @Test
    public void valueOf() {
        Assert.assertThat(IngredientType.valueOf("SAUCE"), is(notNullValue()));
        Assert.assertThat(IngredientType.valueOf("FILLING"), is(notNullValue()));
    }
}