package kata.supermarket.discounts;

import kata.supermarket.Item;

import java.math.BigDecimal;
import java.util.List;

/**
 * Interface to calculate discounts.
 */
public interface Discount {
    /**
     * Applies the discount based on the items.
     *
     * @param itemsList<Item> List of item data
     *
     * @return amount of promotion applied
     */
    BigDecimal applyDiscount(List<Item> itemsList);
}
