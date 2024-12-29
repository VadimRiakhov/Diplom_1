import org.assertj.core.api.SoftAssertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class    BurgerTest {

    Burger burger;

    @Mock
    Bun mockBun;

    @Mock
    Ingredient mockIngredient1;

    @Mock
    Ingredient mockIngredient2;

    @Mock
    Ingredient mockIngredient3;

    @Before
    public void initBurger(){
        burger = new Burger();
    }

    // проверка установки поля Bun экземпляра класса Burger
    @Test
    public void setBunsTest(){
        burger.setBuns(mockBun);
        assertNotNull("Поле Bun объекта не установлено", burger.bun);
    }

    // проверка добавления ингредиента
    @Test
    public void addIngredientTest(){
        burger.addIngredient(mockIngredient1);
        assertTrue("Ингредиент не добавлен", burger.ingredients.contains(mockIngredient1));
    }

    // проверка удаления ингредиента
    @Test
    public void removeIngredientTest(){
        burger.addIngredient(mockIngredient1);
        int index = burger.ingredients.indexOf(mockIngredient1);
        burger.removeIngredient(index);
        assertFalse("Ингредиент не удален", burger.ingredients.contains(mockIngredient1));
    }

    // проверка перемещения ингредиента
    @Test
    public void moveIngredientTest(){
        int index = 0;
        int newIndex = 2;
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.addIngredient(mockIngredient3);
        burger.moveIngredient(index,newIndex);

        SoftAssertions softAssertions = new SoftAssertions();
        // проверяем, что mockIngredient1 удалился с позиции index
        softAssertions.assertThat(burger.ingredients.get(index))
                        .as("Метод moveIngredient удалил ингредиент с позиции "+index)
                        .isNotEqualTo(mockIngredient1);
        // проверяем, что mockIngredient1 добавиля на позицию newIndex
        softAssertions.assertThat(burger.ingredients.get(newIndex))
                        .as("Метод moveIngredient переместил ингредиент на позицию "+newIndex)
                        .isEqualTo(mockIngredient1);
        softAssertions.assertAll();
    }

    // получение цены
    @Test
    public void getPriceTest(){
        float expectedPrice = 25;
        float delta = 0;
        // стаб для mockBun
        Mockito.when(mockBun.getPrice()).thenReturn(10F);
        // стаб для mockIngredient1
        Mockito.when(mockIngredient1.getPrice()).thenReturn(2F);
        // стаб для mockIngredient2
        Mockito.when(mockIngredient2.getPrice()).thenReturn(3F);
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        float actualPrice = burger.getPrice();
        assertEquals("Фактическая цена отличается от ожидаемой", expectedPrice, actualPrice, delta);
    }

    // получение чека
    @Test
    public void getReceiptTest(){
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        // стаб для mockBun
        Mockito.when(mockBun.getName()).thenReturn("Булочка");
        Mockito.when(mockBun.getPrice()).thenReturn(10F);
        // стаб для mockIngredient1
        Mockito.when(mockIngredient1.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(mockIngredient1.getName()).thenReturn("Котлета");
        Mockito.when(mockIngredient1.getPrice()).thenReturn(2F);
        // стаб для mockIngredient2
        Mockito.when(mockIngredient2.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(mockIngredient2.getName()).thenReturn("Кетчуп");
        Mockito.when(mockIngredient2.getPrice()).thenReturn(3F);
        String actualReceipt = burger.getReceipt();
        // ожидаемый чек
        String expectedReceipt = String.format("(==== %s ====)%n= %s %s =%n= %s %s =%n(==== %s ====)%n%nPrice: %f%n",
                                                 "Булочка", "filling", "Котлета", "sauce", "Кетчуп", "Булочка", 25F);
        assertEquals("Фактический текст в чеке отличается от ожидаемого", expectedReceipt, actualReceipt);

    }
}
