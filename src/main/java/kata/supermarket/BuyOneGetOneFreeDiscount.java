package kata.supermarket;

import org.apache.commons.collections4.CollectionUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

        Map<String, Long> getMapOfAllCountsOfItems = getMapOfAllCountsOfItems(itemsList);

        for(Map.Entry<String, Long> entrySet : getMapOfAllCountsOfItems.entrySet()) {
            if (entrySet.getValue() >= 2) {
                Long numberOfDiscounts = entrySet.getValue() / 2;
                for(Item item : itemsList) {
                    if (item.equals(entrySet.getKey())) {
                        discountTotal = discountTotal.multiply(new BigDecimal(numberOfDiscounts))
                                .setScale(2, BigDecimal.ROUND_HALF_UP);
                        break;
                    }
                }
            }
        }

        return discountTotal;
    }

    private Map<String, Long> getMapOfAllCountsOfItems(List<Item> lst){
        return lst.stream()
                .collect(Collectors.groupingBy(item -> item.getItemId(),
                        Collectors.counting()));
    }
}
