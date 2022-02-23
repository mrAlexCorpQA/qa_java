import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TestCat {

    private Feline feline;
    private Cat cat;

    //Создаются объекты для тестов
    @BeforeEach
    public void createCatObjectsBeforeTest() {
        feline = new Feline();
        cat = new Cat(feline);
    }

    //Проверяется метод getSound класса Cat
    @Test
    public void testCatGetSound() {
        createCatObjectsBeforeTest();
        Assert.assertEquals("Мяу", cat.getSound());
    }

    @Mock
    Feline felineMock;

    //Проверяется метод getFood класса Cat (замокирована зависимость)
    @Test
    public void testCatGetFood() throws Exception {
        cat = new Cat(felineMock);
        Mockito.when(felineMock.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), cat.getFood());
    }

}