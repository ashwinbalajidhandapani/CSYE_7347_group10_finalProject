package neu.edu.csye7374.State_Pattern;


import neu.edu.csye7374.MedicineStore;

public class CloseState implements MedicalShopStateAPI {
	
	private static MedicineStore medicineStore;
	
	public  CloseState(MedicineStore store) {
		super();
		CloseState.medicineStore=store;
	}
	
	@Override
	public void state_Open() {
		// TODO Auto-generated method stub
		medicineStore.setState(medicineStore.getOpenState());
		System.out.println("Transition from Close State to Open State");
		
	}

	@Override
	public void state_Close() {
		// TODO Auto-generated method stub
		System.out.println("Error ... Already in Close State");
	}

	@Override
	public void state_Stock() {
		// TODO Auto-generated method stub
		medicineStore.setState(medicineStore.getStockState());
		System.out.println("Transition from Close State to Stock State");
		
	}

}
