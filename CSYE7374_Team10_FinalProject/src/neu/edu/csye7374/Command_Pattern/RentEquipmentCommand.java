package neu.edu.csye7374.Command_Pattern;


import neu.edu.csye7374.Medicine;

public class RentEquipmentCommand implements CommandAPI {

	private static RentEquipmentCommand instance;  // Lazy Singleton Factory Class
	private Medicine medicine;
	
	
	private RentEquipmentCommand() {
		super();
	}
	
	public static synchronized RentEquipmentCommand getInstance() {
		if (instance == null) {
			instance = new RentEquipmentCommand();
		}
		return instance;
	}

	@Override
	public String execute() {
		return medicine.rentEquipment();
	}

	public Medicine getMedicine() {
		return medicine;
	}

	public RentEquipmentCommand setMedicine(Medicine medicine) {
		this.medicine = medicine;
		return this;
	}
	
}
