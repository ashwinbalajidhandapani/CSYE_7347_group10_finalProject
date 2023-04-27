package neu.edu.csye7374.Strategy_Pattern;

import neu.edu.csye7374.Medicine;

public class FacultyDiscount implements DiscountStrategyAPI {

    @Override
    public double discountPrice(Medicine medicine) {
        // TODO Auto-generated method stub
        double discountedPrice=medicine.getMedicinePrice() - medicine.getMedicinePrice()*0.20;
        return discountedPrice;
    }

    @Override
    public String discountDescription(Medicine medicine) {
        // TODO Auto-generated method stub
        return "Faculty Discount Applied : 20% OFF";
    }

}
