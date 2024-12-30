import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {
    // проверка значения SAUCE
    @Test
    public void checkIngredientTypeSauceTest(){
        assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
    }

    // проверка значения FILLING
    @Test
    public void checkIngredientTypeFillingTest(){
        assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }

    // проверка количества полей в классе IngredientType
    @Test
    public void checkIngredientTypeSizeTest(){
        int expectedSize = 2;
        int actualSize = IngredientType.values().length;
        assertEquals("Количество полей в IngredientType отличается от ожидаемого", expectedSize, actualSize);
    }
}
