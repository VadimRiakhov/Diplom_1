import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunParameterizedTest {
    private final Bun bun;
    private final String name;
    private final float price;

    public BunParameterizedTest(String name, float price){
        bun = new Bun(name, price);
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name="Название - {0}, цена - {1}")
    public static Object[][] getData(){
        return new Object[][]{
                {"Булочка", 10F},
                {"", 10F},
                {null, 10F},
                {"БулочкаБулочкаБулочкаБулочкаБулочкаБулочкаБулочкаБулочкаБулочкаБулочкаБулочкаБулочкаБулочкаБулочкаБулочка", 10F},
                {"Булочка c #@&", 10F},
                {"Булочка", -10F},
                {"Булочка", 0},
                {"Булочка", 0.1F},
                {"Булочка", -0.1F},
                {"Булочка", 1000000000F}
        };
    }

    // получение названия булочки
    @Test
    public void getNameTest(){
        String actualName = bun.getName();
        assertEquals("Возвращаемое имя отличается от ожидаемого", name, actualName);
    }

    // получение цены булочки
    @Test
    public void getPriceTest(){
        float actualPrice = bun.getPrice();
        float delta = 0;
        assertEquals("Возвращаемая цена отличается от ожидаемой", price, actualPrice, delta);
    }
}
