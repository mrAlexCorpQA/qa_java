import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

public class TestLionParametrized {

    //Служебный класс для запуска параметризованного теста метода doesHaveMane класса Lion
    @RunWith(Parameterized.class)
    public static class LionClassForTestWithParameters {

        @Parameterized.Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    {"Самец", true},
                    {"Самка", false},
            });
        }

        private String a;
        private boolean expected;

        public LionClassForTestWithParameters(String a, boolean expected) {
            this.a = a;
            this.expected = expected;
        }

        //Проверяется метод doesHaveMane класса Lion
        @Test
        public void testLionDoesHaveManeWithParameters() throws Exception {
            Feline feline = new Feline();
            Lion lion = new Lion(a, feline);
            Assert.assertEquals(expected, lion.doesHaveMane());
        }
    }

}