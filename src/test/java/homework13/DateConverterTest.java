package homework13;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.format.DateTimeParseException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("DateConverterTest")
public class DateConverterTest {

    private static int count = 1;


    @AfterAll
    static void finish() {
        System.out.println("------------ Testing finished ----------------");
    }

    @BeforeEach
    public void startEach() {

        System.out.printf("Test %d started \n", count);
    }

    @AfterEach
    public void finishEach() {
        System.out.printf("Test %d finished \n", count++);
        System.out.println("=============================");
    }

// ==================  Positive tests  ======================

    @ParameterizedTest
    @CsvSource({
            "29-10-2023, dd-MM-yyyy, dd MMM yyyy, 29 Oct 2023",
            "10 Feb 2000, dd MMM yyyy, MM/dd/yyyy, 02/10/2000",
            "11 March 1990, dd MMMM yyyy, dd-MM-yyyy, 11-03-1990",
            "12/10/1980, MM/dd/yyyy, dd-MM-yyyy, 10-12-1980",
            "1970-03-27, yyyy-MM-dd, yyyy MMMM dd, 1970 March 27"
    })
    @Order(1)
    @DisplayName("Check Positive Tests. ConvertDate")
    void checkPositiveConvertDate(String date, String inputFormat, String outputFormat, String expectedResult) {
        assertEquals(DateConverter.convertDate(date, inputFormat, outputFormat), expectedResult);
    }

    @ParameterizedTest
    @CsvSource({
            "29-10-2023, dd-MM-yyyy",
            "10 Feb 2000, dd MMM yyyy",
            "11 March 1990, dd MMMM yyyy",
            "12/10/1980, MM/dd/yyyy",
            "1970-03-27, yyyy-MM-dd"
    })
    @Order(2)
    @DisplayName("Check Positive Tests. Detect Date Format")
    void checkPositiveDetectDateFormat(String dateStr, String expectedResult) {
        assertEquals(DateConverter.detectDateFormat(dateStr), expectedResult);
    }


// ================  Negative tests ========================================

    static Stream<Arguments> checkNegativeConvertDate() {
        return Stream.of(
                Arguments.arguments("29,10,2023", "dd-MM-yyyy", "dd MMM yyyy"),
                Arguments.arguments("10.Feb.2000", "dd MMM yyyy", "MM/dd/yyyy"),
                Arguments.arguments("11 March 1990", "MMMM yyyy", "dd-MM-yyyy"),
                Arguments.arguments("12/10/1980", "MMMM/dd/yyyy", "dd-MM-yyyy"),
                Arguments.arguments("1970-03-27", "1970.03.27", "yyyy-MMMM-dd")

        );
    }

    @ParameterizedTest
    @MethodSource
    @Order(3)
    @DisplayName("Check Negative Tests. Convert Date")
    void checkNegativeConvertDate(String date, String inputFormat, String outputFormat) {
        assertThrows(DateTimeParseException.class, () -> DateConverter.convertDate(date, inputFormat, outputFormat));
    }


    static Stream<Arguments> checkNegativeDetectDateFormat() {
        return Stream.of(
                Arguments.arguments("29,10,2023"),
                Arguments.arguments("10.Feb.2000"),
                Arguments.arguments("10/1980"),
                Arguments.arguments("29-29-1900")
        );
    }

    @ParameterizedTest
    @MethodSource
    @Order(4)
    @DisplayName("Check Null Negative Test. Detect Date Format")
    public void checkNegativeDetectDateFormat(String dateStr) {
        assertNull(DateConverter.detectDateFormat(dateStr));
    }

}
