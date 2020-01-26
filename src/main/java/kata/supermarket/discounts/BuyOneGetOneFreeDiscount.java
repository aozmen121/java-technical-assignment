package kata.supermarket.discounts;

import kata.supermarket.Item;
import org.apache.commons.collections4.CollectionUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Buy one get one free promotion handler class
 */
public class BuyOneGetOneFreeDiscount implements Discount {

    @Override
    public BigDecimal applyDiscount(List<Item> itemsList) {

        BigDecimal discountTotal = BigDecimal.ZERO;

        if (CollectionUtils.isEmpty(itemsList)) {
            return discountTotal;
        }

        Map<String, Long> getMapOfAllCountsOfItems = getMapOfAllCountsOfItems(itemsList);

        // Iterate through map and calculate each discount
        // TO-DO this implementation may not be the most efficient way, consider having a state for each item in a map instead of
        // iterating through items list. Needs refactoring
        for(Map.Entry<String, Long> entrySet : getMapOfAllCountsOfItems.entrySet()) {
            if (entrySet.getValue() >= 2) {
                Long numberOfDiscounts = entrySet.getValue() / 2;
                for(Item item : itemsList) {
                    if (item.getItemId().equals(entrySet.getKey())) {
                        discountTotal = discountTotal.add(new BigDecimal(numberOfDiscounts).multiply(item.price()))
                                .setScale(2, BigDecimal.ROUND_HALF_UP);
                        break;
                    }
                }
            }
        }

        return discountTotal;
    }

    /**
     * Gets a count of all items flattened to map
     *
     * @param itemsList List of items
     *
     * @return Map of counts.
     */
    private Map<String, Long> getMapOfAllCountsOfItems(List<Item> itemsList){
        return itemsList.stream()
                .collect(Collectors.groupingBy(item -> item.getItemId(),
                        Collectors.counting()));
    }
}
