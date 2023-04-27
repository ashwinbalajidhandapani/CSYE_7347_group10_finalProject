package neu.edu.csye7374.Adapter_Pattern;


public class Manufacturer implements Cloneable{
	
	private String manufacturerName;
	private int manufacturerRegistrationAge;
	private int manufacturerProductCount;
	private static Manufacturer instance;
	
	public Manufacturer() {
		super();
	}
	
	public static synchronized Manufacturer getInstance() {
		if (instance == null) {
			instance = new Manufacturer();
		}
		return instance;
	}

	private Manufacturer(String manufacturerName, int manufacturerRegistrationAge, int manufacturerProductCount) {
		super();
		this.manufacturerName = manufacturerName;
		this.manufacturerRegistrationAge = manufacturerRegistrationAge;
		this.manufacturerProductCount = manufacturerProductCount;
	}
	
	public String getManufacturerName() {
		return manufacturerName;
	}
	public Manufacturer setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
		return this;
	}
	public int getManufacturerRegistrationAge() {
		return manufacturerRegistrationAge;
	}
	public Manufacturer setAge(int age) {
		this.manufacturerRegistrationAge = manufacturerRegistrationAge;
		return this;
	}
	public int getManufacturerProductCount() {
		return manufacturerProductCount;
	}
	public Manufacturer setNoOfManufacturerProductCount(int manufacturerProductCount) {
		this.manufacturerProductCount = manufacturerProductCount;
		return this;
	}
	@Override
	public String toString() {
		return "Manufacturer [ManufacturerName=" + manufacturerName + ", ManufacturerRegistrationAge=" + manufacturerRegistrationAge + ", ManufacturerProductCount=" + manufacturerProductCount + "]";
	}

	
	@Override
	public Manufacturer clone() {
		// TODO Auto-generated method stub
		Manufacturer clone = null;
	      
		try {
			clone = (Manufacturer)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return clone;
	}
	
	
}
