import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TestLionNoneParametrized {

    private Feline feline;
    private Lion lion;

    //Создаются объекты для тестов
    @BeforeEach
    public void createLionObjectsBeforeTest() throws Exception {
        feline = new Feline();
        lion = new Lion("Самец", feline);
    }

    @Mock
    Feline felineMock;

    //Проверяется метод getKittens класса Lion (замокирована зависимость)
    @Test
    public void testLionGetKittens() throws Exception {
        lion = new Lion("Самец", felineMock);
        Mockito.when(felineMock.getKittens()).thenReturn(1);
        Assert.assertEquals(1, lion.getKittens());
    }

    //Проверяется метод getFood класса Lion (замокирована зависимость)
    @Test
    public void testLionGetFood() throws Exception {
        lion = new Lion("Самец", felineMock);
        Mockito.when(felineMock.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }

    //Проверяется передаваемое исключение метода doesHaveMane класса Lion
    @Test
    public void testLionDoesHaveManeException() throws Exception {
        try {
            feline = new Feline();
            lion = new Lion("Другое", feline);
        } catch (Exception exception) {
            Assert.assertEquals("Используйте допустимые значения пола животного - самей или самка", exception.getMessage());
        }
    }

}