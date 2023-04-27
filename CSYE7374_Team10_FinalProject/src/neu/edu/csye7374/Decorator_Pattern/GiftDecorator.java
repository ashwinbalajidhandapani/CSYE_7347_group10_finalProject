package neu.edu.csye7374.Decorator_Pattern;


import neu.edu.csye7374.Medicine;
import neu.edu.csye7374.MedicineAPI;

public class GiftDecorator extends MedicineDecorator {

	public GiftDecorator(MedicineAPI decoratedMedicine) {
		super(decoratedMedicine);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String medicineDescription() {
		// TODO Auto-generated method stub
		return decoratedMedicine.medicineDescription()+ "..Wrapped for gift along with a pen";
	}

	@Override
	public Object getMedicineManufact() {
		// TODO Auto-generated method stub
		return decoratedMedicine.getMedicineManufact();
	}
	
	public double getMedicinePrice() {
		Medicine b = Medicine.class.cast(decoratedMedicine);
		return b.getMedicinePrice()+10;
	}
	
}
