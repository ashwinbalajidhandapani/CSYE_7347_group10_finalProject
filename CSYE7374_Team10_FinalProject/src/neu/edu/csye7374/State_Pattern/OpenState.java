package neu.edu.csye7374.State_Pattern;


import neu.edu.csye7374.MedicineStore;

public class OpenState implements MedicalShopStateAPI {
	
	private static MedicineStore medicineStore;
	
	public  OpenState(MedicineStore store) {
		super();
		OpenState.medicineStore=store;
	}
	
	@Override
	public void state_Open() {
		// TODO Auto-generated method stub
		System.out.println("Error ... Already in Open State");
		
	}

	@Override
	public void state_Close() {
		// TODO Auto-generated method stub
		medicineStore.setState(medicineStore.getCloseState());
		System.out.println("Currently in Close State");
	}

	@Override
	public void state_Stock() {
		// TODO Auto-generated method stub
		medicineStore.setState(medicineStore.getStockState());
		System.out.println("Currently in Stock State");
		
	}

}
