package neu.edu.csye7374.Decorator_Pattern;


import neu.edu.csye7374.MedicineAPI;

public abstract class MedicineDecorator implements MedicineAPI {
	
	protected MedicineAPI decoratedMedicine;
	
	public MedicineDecorator(MedicineAPI decoratedMedicine){
	      this.decoratedMedicine = decoratedMedicine;
	}
	 
	@Override
	public String medicineDescription() {
		// TODO Auto-generated method stub
		return decoratedMedicine.medicineDescription();
	}

	@Override
	public int manufacturerProductCount() {
		// TODO Auto-generated method stub
		return decoratedMedicine.manufacturerProductCount();
	}
	
	public MedicineAPI getDecoratedMedicine() {
		return this.decoratedMedicine;
	}

	@Override
	public String toString() {
		return "MedicineDecorator [medicineDescription()=" + medicineDescription() + ", manufacturerProductCount()="
				+ manufacturerProductCount() + ", getDecoratedMedicine()=" + getDecoratedMedicine() + "]";
	}
	
	

}
