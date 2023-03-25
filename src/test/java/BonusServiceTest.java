import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BonusServiceTest {

    @Test
    public void testShouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        long expected = 30;
        long actual = service.calculate(1000, true);
        //System.out.println("1. " + expected + " == ? == " + actual);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testShouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        long expected = 500;
        long actual = service.calculate(1_000_000, true);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testShouldCalculateUnRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        long expected = 10;
        long actual = service.calculate(1000, false);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testShouldCalculateForRegisteredWithZeroLimit() {
        BonusService service = new BonusService();

        long expected = 0;
        long actual = service.calculate(0, true);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testShouldCalculateUnRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        long expected = 500;
        long actual = service.calculate(2_000_000, false);

        Assertions.assertEquals(expected, actual);
    }


}
