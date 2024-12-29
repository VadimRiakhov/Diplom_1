import org.junit.Test;
import praktikum.IngredientType;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {
    // проверка значения SAUCE
    @Test
    public void checkIngredientTypeSauceTest(){
        assertThat(IngredientType.valueOf("SAUCE"), is(notNullValue()));
    }

    // проверка значения FILLING
    @Test
    public void checkIngredientTypeFillingTest(){
        assertThat(IngredientType.valueOf("FILLING"), is(notNullValue()));
    }

    // проверка количества полей в классе IngredientType
    @Test
    public void checkIngredientTypeSizeTest(){
        int expectedSize = 2;
        int actualSize = IngredientType.values().length;
        assertEquals("Количество полей в IngredientType отличается от ожидаемого", expectedSize, actualSize);
    }
}
