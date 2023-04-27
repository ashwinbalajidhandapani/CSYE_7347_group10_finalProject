package neu.edu.csye7374.Builder;

import neu.edu.csye7374.ConvertUtility;
import neu.edu.csye7374.Factory_Pattern.MedicineFactory;
import neu.edu.csye7374.Medicine;
import neu.edu.csye7374.MedicineCategory;

public class MedicineBuilder implements BuilderAPI<Medicine>{
	
	private int medicineID;
	private String medicineName;
	private double medicinePrice;
	private MedicineCategory medicineCategory;
	private String medicineManufact;
	
	
	public String getMedicineManufact() {
		return medicineManufact;
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

	public MedicineBuilder(int medicineID, String medicineName, double medicinePrice, MedicineCategory medicineCategory,String medicineManufact) {
		super();
		this.medicineID = medicineID;
		this.medicineName = medicineName;
		this.medicinePrice = medicinePrice;
		this.medicineCategory = medicineCategory;
		this.medicineManufact=medicineManufact;
	}
	
	public MedicineBuilder(String s) {
		String[] tokens=s.split(",");
		this.medicineID= ConvertUtility.StringToInt(tokens[0]);
		this.medicineName=tokens[1];
		this.medicinePrice=ConvertUtility.StringToDouble(tokens[2]);	
		this.medicineCategory=MedicineCategory.getMedicineCategory(tokens[3]);
		this.medicineManufact=tokens[4];
	}


	@Override
	public Medicine build() {
		// TODO Auto-generated method stub
		return MedicineFactory.getInstance().getObject(this);
	}
}
