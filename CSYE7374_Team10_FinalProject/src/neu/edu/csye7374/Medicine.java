package neu.edu.csye7374;


import neu.edu.csye7374.Builder.MedicineBuilder;
import neu.edu.csye7374.Strategy_Pattern.DiscountStrategy;

public class Medicine implements MedicineAPI{
	
	public int medicineID;
	public String medicineName;
	public double medicinePrice;
	public MedicineCategory medicineCategory;
	public Object medicineManufact;
		
	public Medicine(MedicineBuilder builder) {
		super();
		this.medicineID = builder.getMedicineID();
		this.medicineName = builder.getMedicineName();
		this.medicinePrice = builder.getMedicinePrice();
		this.medicineCategory = builder.getMedicineCategory();
		this.medicineManufact=builder.getMedicineManufact();
	}
	
	public Object getMedicineManufact() {
		return String.class.cast(medicineManufact);
	}

	public void setMedicineManufact(String medicineManufact) {
		this.medicineManufact = medicineManufact;
	}

	public int getMedicineID() {
		return medicineID;
	}

	public void setMedicineID(int medicineID) {
		this.medicineID = medicineID;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public double getMedicinePrice() {
		return medicinePrice;
	}

	public void setMedicinePrice(double medicinePrice) {
		this.medicinePrice = medicinePrice;
	}

	public MedicineCategory getMedicineCategory() {
		return medicineCategory;
	}

	public void setMedicineCategory(MedicineCategory medicineCategory) {
		this.medicineCategory = medicineCategory;
	}

	@Override
	public String medicineDescription() {
		// TODO Auto-generated method stub
		return this.medicineName + ", of category "+this.medicineCategory;
	}
	

	@Override
	public int manufacturerProductCount() {
		// TODO Auto-generated method stub
		return (int) Math.random()*10;
	}

	@Override
	public String toString() {
		return "Medicine [medicineID=" + medicineID + ", medicineName=" + medicineName + ", medicinePrice=" + medicinePrice + ", medicineCategory="
				+ medicineCategory + ", medicineManufact=" + (String) medicineManufact + "]";
	}
	
	public String buyMedicine() {
		
		return this.medicineName+ " is bought";
	}
	
	public String rentEquipment() {
		this.medicinePrice = this.medicinePrice * 0.75;
		return this.medicineName + " is rented";
	}
	
	public double runStrategy() {
        double value = 0;
        switch(MedicineStore.usingStrategy){
            case EmployeeDiscount:
                value = MedicineStore.getAlgorithmMap().get(DiscountStrategy.EmployeeDiscount).discountPrice(this);
                break;
            case StudentDiscount:
                value = MedicineStore.getAlgorithmMap().get(DiscountStrategy.StudentDiscount).discountPrice(this);
                break;
            default:
                value = medicinePrice;
                break;
        }
        return value;
    }

}
