import Rest.RestService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

public class RestServiceTest {
    @ParameterizedTest
    @CsvSource(value = {

            "10000,3000,20000,4",
            "100000,60000,150000,3",
            "1000,500,2000,3",
            "1000000,1000,500000,8",
            "1000000,100000,300000,8",
            "100000,100000,1000000,0"
    })
    void testCalculate(int income, int expenses, int threshold, int expected) {
        RestService service = new RestService();
        int actual = service.calculate(income, expenses, threshold);
        Assertions.assertEquals(expected, actual);
    }
    @ParameterizedTest
    @CsvFileSource(resources = "TestData.csv")
    void testCalculateFileSource(int income, int expenses, int threshold, int expected) {
        RestService service = new RestService();
        int actual = service.calculate(income, expenses, threshold);
        Assertions.assertEquals(expected, actual);
    }
}
