import kata.supermarket.BuyOneGetOneFreeDiscount;
import kata.supermarket.Item;
import kata.supermarket.ItemByUnit;
import kata.supermarket.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void returnZeroDiscountWhenOneItemPassed() {
        Item firstItem = Mockito.mock(Item.class);
        List<Item> itemsList = new ArrayList<>();
        itemsList.add(firstItem);

        Mockito.when(firstItem.price()).thenReturn(new BigDecimal(0.20));

        Assert.assertEquals(BigDecimal.ZERO, buyOneGetOneFreeDiscount.applyDiscount(itemsList));
    }

    @Test
    public void applyDiscountWhenTwoSameItemsArePassed() {
        Item firstItem = Mockito.mock(Item.class);
        Mockito.when(firstItem.price()).thenReturn(new BigDecimal(0.20));

        List<Item> itemsList = new ArrayList<Item>();
        itemsList.add(firstItem);
        itemsList.add(firstItem);

        Assert.assertEquals(new BigDecimal(0.20).setScale(2, BigDecimal.ROUND_HALF_UP), buyOneGetOneFreeDiscount.applyDiscount(itemsList));
    }

    @Test
    public void applyDiscountWhenThreeSameItemsArePassed() {
        Item firstItem = Mockito.mock(Item.class);
        Mockito.when(firstItem.price()).thenReturn(new BigDecimal(0.20));

        List<Item> itemsList = new ArrayList<Item>();
        itemsList.add(firstItem);
        itemsList.add(firstItem);
        itemsList.add(firstItem);

        Assert.assertEquals(new BigDecimal(0.20).setScale(2, BigDecimal.ROUND_HALF_UP), buyOneGetOneFreeDiscount.applyDiscount(itemsList));
    }

    @Test
    public void applyDiscountWhenFourSameItemsArePassed() {
        Item firstItem = Mockito.mock(Item.class);
        Mockito.when(firstItem.price()).thenReturn(new BigDecimal(0.20));

        List<Item> itemsList = new ArrayList<Item>();
        itemsList.add(firstItem);
        itemsList.add(firstItem);
        itemsList.add(firstItem);
        itemsList.add(firstItem);

        Assert.assertEquals(new BigDecimal(0.40).setScale(2, BigDecimal.ROUND_HALF_UP), buyOneGetOneFreeDiscount.applyDiscount(itemsList));
    }

    @Test
    public void dontApplyDiscountWhenTwoDifferentItemsArePassed() {
        Item firstItem = Mockito.mock(Item.class);
        Mockito.when(firstItem.price()).thenReturn(new BigDecimal(0.20));
        Mockito.when(firstItem.getItemId()).thenReturn("Crisps");
        Item secondItem = Mockito.mock(Item.class);
        Mockito.when(firstItem.price()).thenReturn(new BigDecimal(0.30));
        Mockito.when(firstItem.getItemId()).thenReturn("Chocolates");

        List<Item> itemsList = new ArrayList<Item>();
        itemsList.add(firstItem);
        itemsList.add(secondItem);

        Assert.assertEquals(new BigDecimal(0.0).setScale(2, BigDecimal.ROUND_HALF_UP), buyOneGetOneFreeDiscount.applyDiscount(itemsList));
    }

    @Test
    public void applyDiscountWhenTwoSameAndOneDifferentMixedItemsArePassed() {
        Item firstItem = Mockito.mock(Item.class);
        Mockito.when(firstItem.price()).thenReturn(new BigDecimal(0.20));
        Mockito.when(firstItem.getItemId()).thenReturn("Crisps");

        Item secondItem = Mockito.mock(Item.class);
        Mockito.when(firstItem.price()).thenReturn(new BigDecimal(0.30));
        Mockito.when(firstItem.getItemId()).thenReturn("Chocolates");

        Item thirdItem = Mockito.mock(Item.class);
        Mockito.when(thirdItem.price()).thenReturn(new BigDecimal(0.20));
        Mockito.when(thirdItem.getItemId()).thenReturn("Crisps");

        List<Item> itemsList = new ArrayList<Item>();
        itemsList.add(firstItem);
        itemsList.add(secondItem);
        itemsList.add(thirdItem);

        Assert.assertEquals(new BigDecimal(0.0).setScale(2, BigDecimal.ROUND_HALF_UP), buyOneGetOneFreeDiscount.applyDiscount(itemsList));
    }
}
