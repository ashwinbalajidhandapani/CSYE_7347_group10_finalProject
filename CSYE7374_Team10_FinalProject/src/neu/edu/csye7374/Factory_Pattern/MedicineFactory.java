package neu.edu.csye7374.Factory_Pattern;


import neu.edu.csye7374.Builder.BuilderAPI;
import neu.edu.csye7374.Builder.MedicineBuilder;
import neu.edu.csye7374.Medicine;

public class MedicineFactory extends AbstractFactory<Medicine> {
	
	private static MedicineFactory instance=new MedicineFactory(); // Eager Singleton Factory Class
	
	private  MedicineFactory() {
		super();
	}
	
	public synchronized static MedicineFactory getInstance() {
		return instance;
	}

	@Override
	public Medicine getObject(BuilderAPI<Medicine> builder) {
		// TODO Auto-generated method stub
		MedicineBuilder medicineBuilder=(MedicineBuilder)builder;
		return new Medicine(medicineBuilder);
	}

}
