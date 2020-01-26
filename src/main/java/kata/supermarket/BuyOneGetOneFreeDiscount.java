package kata.supermarket;

import org.apache.commons.collections4.CollectionUtils;

import java.math.BigDecimal;
import java.util.List;

/**
 * Buy one get one free promotion handler class
 */
public class BuyOneGetOneFreeDiscount {

    /**
     * Applys the promotion based on the item
     *
     * @param List<Item> List of item data
     *
     * @return amount of promotion applied
     */
    public BigDecimal applyDiscount(List<Item> itemsList) {

        BigDecimal discountTotal = BigDecimal.ZERO;

        if (CollectionUtils.isEmpty(itemsList)) {
            return discountTotal;
        }

        if (itemsList.size() >= 2) {
            discountTotal = new BigDecimal(0.20).setScale(2, BigDecimal.ROUND_HALF_UP);
        }

        if (itemsList.size() >= 4) {
            discountTotal = discountTotal.add(new BigDecimal(0.20)).setScale(2, BigDecimal.ROUND_HALF_UP);
        }

        return discountTotal;
    }
}
