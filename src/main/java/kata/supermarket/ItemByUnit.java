package kata.supermarket;

import java.math.BigDecimal;

public class ItemByUnit implements Item {

    private final Product product;
    private String id;

    public ItemByUnit(final Product product, String id) {
        this.product = product;
        this.id = id;
    }

    @Override
    public String getItemId() {
        return this.id;
    }

    public BigDecimal price() {
        return product.pricePerUnit();
    }
}
