import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

public class TestFelineParametrized {

    //Служебный класс для запуска параметризованного теста метода getKittens класса Feline с передачей параметров
    @RunWith(Parameterized.class)
    public static class FelineClassForTestWithParameters {

        private Feline feline;

        @Parameterized.Parameters
        public static Object[][] getNumberData() {
            return new Object[][]{
                    {3, 3},
                    {4, 4},
            };
        }

        private int valueForTest;
        private int expected;

        public FelineClassForTestWithParameters(int valueForTest, int expected) {
            this.valueForTest = valueForTest;
            this.expected = expected;
        }

        //Проверяется метод getKittens класса Feline с передачей параметров
        @Test
        public void testFelineGetKittensWithParameters() {
            feline = new Feline();
            Assert.assertEquals(expected, feline.getKittens(valueForTest));
        }
    }

}