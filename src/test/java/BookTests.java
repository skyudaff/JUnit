import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.stream.Stream;

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
        // assert
        Assertions.assertEquals(expected, sut.estimatePrice(pages, rating));
    }

    @Test
    public void isBigTest() {
        // arrange
        sut.pages = 500;

        // assert               // act
        Assertions.assertFalse(sut.isBig());
    }

    @Test
    public void matchesTest() {
        sut.title = "Java руководство";

        Assertions.assertTrue(sut.matches("ava"));
    }
}