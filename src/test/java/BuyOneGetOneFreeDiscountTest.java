import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Test buy one get one free discount pricing
 */
public class BuyOneGetOneFreeDiscountTest {

    private BuyOneGetOneFreeDiscount buyOneGetOneFreeDiscount;

    @Before
    public void setUp() {
        buyOneGetOneFreeDiscount = new BuyOneGetOneFreeDiscount();
    }

    @Test
    public void returnZeroDiscountWhenNullItemsPassed() {
        Assert.assertEquals(BigDecimal.ZERO, buyOneGetOneFreeDiscount.applyDiscount(null));
    }
}
