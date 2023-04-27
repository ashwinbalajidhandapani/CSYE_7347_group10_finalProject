package neu.edu.csye7374.Strategy_Pattern;

import neu.edu.csye7374.Medicine;

public interface DiscountStrategyAPI {
    double discountPrice(Medicine medicine);
    String discountDescription(Medicine medicine);
}
