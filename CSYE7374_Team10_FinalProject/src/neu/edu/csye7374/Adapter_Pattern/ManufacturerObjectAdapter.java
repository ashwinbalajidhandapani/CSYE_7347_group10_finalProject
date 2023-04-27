package neu.edu.csye7374.Adapter_Pattern;

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
	public int getManufacturerProductCount() {
		// TODO Auto-generated method stub
		return manufacturer.getManufacturerProductCount();
	}

	@Override
	public Object getManufacturerName() {
		// TODO Auto-generated method stub
		return Manufacturer.class.cast(manufacturer);
	}

	@Override
	public String toString() {
		return "[" + manufacturer + "], [medicine=" + medicine + "]";
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return medicine.getPrice();
	}
	
	
}
