package kata.supermarket.discounts;

import kata.supermarket.discounts.BuyOneGetOneFreeDiscount;
import kata.supermarket.Item;
import kata.supermarket.ItemByUnit;
import kata.supermarket.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
        Item firstItem = new ItemByUnit(new Product(new BigDecimal(0.20)), "Crisps");
        List<Item> itemsList = new ArrayList<>();
        itemsList.add(firstItem);

        Assert.assertEquals(BigDecimal.ZERO, buyOneGetOneFreeDiscount.applyDiscount(itemsList));
    }

    @Test
    public void applyDiscountWhenTwoSameItemsArePassed() {
        Item firstItem = new ItemByUnit(new Product(new BigDecimal(0.20)), "Crisps");

        List<Item> itemsList = new ArrayList<Item>();
        itemsList.add(firstItem);
        itemsList.add(firstItem);

        Assert.assertEquals(new BigDecimal(0.20).setScale(2, BigDecimal.ROUND_HALF_UP), buyOneGetOneFreeDiscount.applyDiscount(itemsList));
    }

    @Test
    public void applyDiscountWhenThreeSameItemsArePassed() {
        Item firstItem = new ItemByUnit(new Product(new BigDecimal(0.20)), "Crisps");

        List<Item> itemsList = new ArrayList<Item>();
        itemsList.add(firstItem);
        itemsList.add(firstItem);
        itemsList.add(firstItem);

        Assert.assertEquals(new BigDecimal(0.20).setScale(2, BigDecimal.ROUND_HALF_UP), buyOneGetOneFreeDiscount.applyDiscount(itemsList));
    }

    @Test
    public void applyDiscountWhenFourSameItemsArePassed() {
        Item firstItem = new ItemByUnit(new Product(new BigDecimal(0.20)), "Crisps");

        List<Item> itemsList = new ArrayList<Item>();
        itemsList.add(firstItem);
        itemsList.add(firstItem);
        itemsList.add(firstItem);
        itemsList.add(firstItem);

        Assert.assertEquals(new BigDecimal(0.40).setScale(2, BigDecimal.ROUND_HALF_UP), buyOneGetOneFreeDiscount.applyDiscount(itemsList));
    }

    @Test
    public void dontApplyDiscountWhenTwoDifferentItemsArePassed() {
        Item firstItem = new ItemByUnit(new Product(new BigDecimal(0.20)), "Crisps");
        Item secondItem = new ItemByUnit(new Product(new BigDecimal(0.30)), "Chocolates");

        List<Item> itemsList = new ArrayList<Item>();
        itemsList.add(firstItem);
        itemsList.add(secondItem);

        Assert.assertEquals(BigDecimal.ZERO, buyOneGetOneFreeDiscount.applyDiscount(itemsList));
    }

    @Test
    public void applyDiscountWhenTwoSameAndOneDifferentMixedItemsArePassed() {
        Item firstItem = new ItemByUnit(new Product(new BigDecimal(0.20)), "Crisps");
        Item secondItem = new ItemByUnit(new Product(new BigDecimal(0.30)), "Chocolates");
        Item thirdItem = new ItemByUnit(new Product(new BigDecimal(0.20)), "Crisps");


        List<Item> itemsList = new ArrayList<Item>();
        itemsList.add(firstItem);
        itemsList.add(secondItem);
        itemsList.add(thirdItem);

        Assert.assertEquals(new BigDecimal(0.20).setScale(2, BigDecimal.ROUND_HALF_UP), buyOneGetOneFreeDiscount.applyDiscount(itemsList));
    }
}
