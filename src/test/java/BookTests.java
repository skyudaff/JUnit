import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.stream.Stream;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class BookTests {
    Book sut;

    @BeforeEach
    public void bE() {
        sut = new Book();
    }

    @AfterEach
    public void aE() {
        sut = null;
    }

    @BeforeAll
    public static void start() {
        System.out.println("Начало тестов");
    }

    @AfterAll
    public static void finish() {
        System.out.println("Конец тестов");
    }

    public static Stream<Arguments> estimatePriceTest() {
        return Stream.of(
                Arguments.of(80, 1, 250),
                Arguments.of(1, 5, 250),
                Arguments.of(80, 3, 250)
        );
    }

    @ParameterizedTest
    @MethodSource
    public void estimatePriceTest(int pages, int rating, int expected) {
        // act
        int result = sut.estimatePrice(pages, rating);

        // assert
        Assertions.assertEquals(expected, result);

        // assert JUnit + Hamcrest
        assertThat(result, Matchers.equalTo(expected));
    }

    @Test
    public void isBigTest() {
        // arrange
        sut.pages = 500;

        // assert               // act
        Assertions.assertFalse(sut.isBig());

        // assert JUnit + Hamcrest
        assertThat(sut.isBig(), Matchers.equalTo(false));
    }

    @Test
    public void matchesTest() {
        // given
        sut.title = "Java руководство";

        // when
        boolean result = sut.matches("ava");

        // then
        Assertions.assertTrue(result);

        // then JUnit + Hamcrest
        assertThat(result, Matchers.equalTo(true));
    }

    @Test
    public void notNullTest() {
        assertThat(sut, notNullValue());
    }

    @Test
    public void stringTest() {
    Book book = new Book("Название книги");
    assertThat(book.title, containsString("книги"));
    }
}