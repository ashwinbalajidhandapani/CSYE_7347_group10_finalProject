package neu.edu.csye7374.Adapter_Pattern;

import neu.edu.csye7374.MedicineAPI;

public class ManufacturerObjectAdapter implements MedicineAPI{
	
	private Manufacturer manufacturer;
	private MedicineAPI medicine;
	
	public ManufacturerObjectAdapter(MedicineAPI medicine, Manufacturer adaptee) {
		this.medicine = medicine;
		this.manufacturer=adaptee;
	}

	@Override
	public String medicineDescription() {
		// TODO Auto-generated method stub
		return medicine.medicineDescription();
	}

	@Override
	public Object getMedicineManufact() {
		// TODO Auto-generated method stub
		return Manufacturer.class.cast(manufacturer);
	}

	@Override
	public int manufacturerProductCount() {
		return manufacturer.getManufacturerProductCount();
	}

	@Override
	public double getMedicinePrice() {
		return medicine.getMedicinePrice();
	}



	@Override
	public String toString() {
		return "[" + manufacturer + "], [medicine=" + medicine + "]";
	}

	
	
}
