package neu.edu.csye7374.Strategy_Pattern;


import neu.edu.csye7374.Medicine;

public class EmployeeDiscount implements DiscountStrategyAPI{

    @Override
    public double discountPrice(Medicine medicine) {
        // TODO Auto-generated method stub
        double discountedPrice=medicine.getMedicinePrice() - medicine.getMedicinePrice()*0.15;
        return discountedPrice;
    }

    @Override
    public String discountDescription(Medicine medicine) {
        // TODO Auto-generated method stub
        return "Employee Discount Applied : 15% OFF";
    }

}
