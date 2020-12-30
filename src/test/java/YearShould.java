import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class YearShould {


    @Test
    public void
            is_NotleapYear_if_not_dividedby_4() {
        Year year = new Year(1997);
        boolean result = Year.isLeapYear();
        assertThat(result).isFalse();
    }
}
