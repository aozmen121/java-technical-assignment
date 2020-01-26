package kata.supermarket;

import java.math.BigDecimal;

public class ItemByWeight implements Item {

    private final WeighedProduct product;
    private final BigDecimal weightInKilos;
    private String id;

    ItemByWeight(final WeighedProduct product, final BigDecimal weightInKilos) {
        this.product = product;
        this.weightInKilos = weightInKilos;
    }

    ItemByWeight(final WeighedProduct product, final BigDecimal weightInKilos, String id) {
        this.product = product;
        this.weightInKilos = weightInKilos;
        this.id = id;
    }

    @Override
    public String getItemId() {
        return this.id;
    }

    public BigDecimal price() {
        return product.pricePerKilo().multiply(weightInKilos).setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
