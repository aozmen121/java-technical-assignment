package kata.supermarket;

import java.math.BigDecimal;

public interface Item extends ItemIdentifier {
    BigDecimal price();
}
