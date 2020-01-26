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

        if (CollectionUtils.isEmpty(itemsList)) {
            return BigDecimal.ZERO;
        }

        if (itemsList.size() >= 2) {
            return new BigDecimal(0.20).setScale(2, BigDecimal.ROUND_HALF_UP);
        }

        return BigDecimal.ZERO;
    }
}
