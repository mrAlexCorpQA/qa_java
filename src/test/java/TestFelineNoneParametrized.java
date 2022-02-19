import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

public class TestFelineNoneParametrized {

    private Feline feline;

    //Создаются объекты для тестов
    @BeforeEach
    public void createFelineObjectsBeforeTest() {
        feline = new Feline();
    }

    //Проверяется метод testEatMeat класса Feline
    @Test
    public void testFelineEatMeat() throws Exception {
        createFelineObjectsBeforeTest();
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }

    //Проверяется метод getFamily класса Feline
    @Test
    public void testFelineGetFamily() {
        createFelineObjectsBeforeTest();
        Assert.assertEquals("Кошачьи", feline.getFamily());
    }

    //Проверяется метод getKittens без передачи значения класса Feline
    @Test
    public void testFelineGetKittens() {
        createFelineObjectsBeforeTest();
        Assert.assertEquals(1, feline.getKittens());
    }

}