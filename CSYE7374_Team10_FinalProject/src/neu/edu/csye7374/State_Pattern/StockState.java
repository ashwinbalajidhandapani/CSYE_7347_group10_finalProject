package neu.edu.csye7374.State_Pattern;


import neu.edu.csye7374.MedicineStore;

public class StockState implements MedicalShopStateAPI {
	
	private static MedicineStore medicineStore;
	
	public  StockState(MedicineStore store) {
		super();
		StockState.medicineStore=store;
	}
	
	@Override
	public void state_Open() {
		// TODO Auto-generated method stub
		medicineStore.setState(medicineStore.getOpenState());
		System.out.println("Transition from Stock State to Open State");
		
	}

	@Override
	public void state_Close() {
		// TODO Auto-generated method stub
		medicineStore.setState(medicineStore.getCloseState());
		System.out.println("Transition from Stock State to Close State");
	}

	@Override
	public void state_Stock() {
		// TODO Auto-generated method stub
		System.out.println("Error ... Already in Stock State");
		
	}
}
