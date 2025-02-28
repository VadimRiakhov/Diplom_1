import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    private Ingredient ingredient;

    @Before
    public void initIngredient(){
        String name = "Соевый соус";
        float price = 12.5f;
        IngredientType ingredientType = IngredientType.SAUCE;
        ingredient = new Ingredient(ingredientType, name, price);
    }

    // получение названия ингредиента
    @Test
    public void getNameTest(){
        String expectedName = "Соевый соус";
        String actualName = ingredient.getName();
        assertEquals("Возвращаемое имя отличается от ожидаемого", expectedName, actualName);
    }

    // получение цены ингредиента
    @Test
    public void getPriceTest(){
        float expectedPrice = 12.5f;
        float actualPrice = ingredient.getPrice();
        assertEquals("Возвращаемая цена отличается от ожидаемой", expectedPrice, actualPrice, 0);
    }

    // получение типа ингредиента
    @Test
    public void getTypeTest(){
        IngredientType expectedType = IngredientType.SAUCE;
        IngredientType actualType = ingredient.getType();
        assertEquals("Тип ингредиента отличается от ожидаемого", expectedType, actualType);
    }

}
