package neu.edu.csye7374;


import neu.edu.csye7374.Adapter_Pattern.Manufacturer;
import neu.edu.csye7374.Adapter_Pattern.ManufacturerObjectAdapter;
import neu.edu.csye7374.Builder.EmployeeBuilder;
import neu.edu.csye7374.Builder.MedicineBuilder;
import neu.edu.csye7374.Command_Pattern.Invoker;
import neu.edu.csye7374.Facade.DeliveryType;
import neu.edu.csye7374.Facade.OrderFacade;
import neu.edu.csye7374.Factory_Pattern.EmployeeFactory;
import neu.edu.csye7374.Factory_Pattern.MedicineFactory;
import neu.edu.csye7374.ObserverPattern.Order;
import neu.edu.csye7374.State_Pattern.CloseState;
import neu.edu.csye7374.State_Pattern.MedicalShopStateAPI;
import neu.edu.csye7374.State_Pattern.OpenState;
import neu.edu.csye7374.State_Pattern.StockState;
import neu.edu.csye7374.Strategy_Pattern.DiscountStrategy;
import neu.edu.csye7374.Strategy_Pattern.DiscountStrategyAPI;
import neu.edu.csye7374.Strategy_Pattern.EmployeeDiscount;
import neu.edu.csye7374.Strategy_Pattern.StudentDiscount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MedicineStore implements MedicalShopStateAPI {
	
    private String name;
    private List<Medicine> itemList = new ArrayList<>();
    private List<Person> personList = new ArrayList<>();
    public static DiscountStrategy usingStrategy = DiscountStrategy.NONE;
    private static final String FILE_NAME = "src/neu/edu/csye7374/inputData/details.txt";
	
	private MedicalShopStateAPI openState = new OpenState(this);
	private MedicalShopStateAPI stockState = new StockState(this);
	private MedicalShopStateAPI closeState = new CloseState(this);
	private MedicalShopStateAPI state;
	
	
    private static HashMap<DiscountStrategy, DiscountStrategyAPI> algorithmMap = new HashMap<>();
    {
//    	algorithmMap.put(DiscountStrategy.NONE, null);
        algorithmMap.put(DiscountStrategy.StudentDiscount, new StudentDiscount());
        algorithmMap.put(DiscountStrategy.EmployeeDiscount, new EmployeeDiscount());
    }
	
	public MedicineStore(String name) {
		super();
		this.name = name;
		this.state = getOpenState();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Medicine> getItemList() {
		return itemList;
	}

	public void setItemList(List<Medicine> itemList) {
		this.itemList = itemList;
	}

	public List<Person> getPersonList() {
		return personList;
	}

	public void setPersonList(List<Person> personList) {
		this.personList = personList;
	}

	public static DiscountStrategy getUsingStrategy() {
		return usingStrategy;
	}

	public static void setUsingStrategy(DiscountStrategy usingStrategy) {
		MedicineStore.usingStrategy = usingStrategy;
	}

	public static HashMap<DiscountStrategy, DiscountStrategyAPI> getAlgorithmMap() {
		return algorithmMap;
	}

	public static void setAlgorithmMap(HashMap<DiscountStrategy, DiscountStrategyAPI> algorithmMap) {
		MedicineStore.algorithmMap = algorithmMap;
	}

	public MedicalShopStateAPI getState() {
		return state;
	}

	public void setState(MedicalShopStateAPI state) {
		this.state = state;
	}

	public MedicalShopStateAPI getOpenState() {
		return openState;
	}

	public void setOpenState(MedicalShopStateAPI openState) {
		this.openState = openState;
	}

	public MedicalShopStateAPI getStockState() {
		return stockState;
	}

	public void setStockState(MedicalShopStateAPI stockState) {
		this.stockState = stockState;
	}

	public MedicalShopStateAPI getCloseState() {
		return closeState;
	}

	public void setCloseState(MedicalShopStateAPI closeState) {
		this.closeState = closeState;
	}

	@Override
	public void state_Open() {
		// TODO Auto-generated method stub
		this.state.state_Open();
		
	}

	@Override
	public void state_Close() {
		// TODO Auto-generated method stub
		this.state.state_Close();
	}

	@Override
	public void state_Stock() {
		// TODO Auto-generated method stub
		this.state.state_Stock();
	}
	
	public static void demo() {
		
		
		
		FileUtil.getFileData(FILE_NAME);
		
		
		
		List<Medicine> medicineList = new ArrayList<>();
		
		//Builder Pattern and getting object of Builder using Factory and Singleton Pattern
		System.out.println("***************************************************************************************");
		System.out.println("Demonstrating of Builder pattern. Delegating the responsibilty of creating Medicine objects to Medicine Builder which implements build method and builds medicine object for us");
		System.out.println("Using Factory and singleton pattern to get only single instance of Medicine Builder object");
		MedicineBuilder medicineBuilder = new MedicineBuilder(1, "Paracetomol", 5.99, MedicineCategory.Tablet, "Cipla");
		MedicineAPI medicine = MedicineFactory.getInstance().getObject(medicineBuilder);
		medicineList.add((Medicine)medicine);
		System.out.println(medicine);
		FileUtil.appendEntryToFile(FILE_NAME, medicineBuilder);
		
		//Prototype Pattern to clone the object of manufacture
        System.out.println("***************************************************************************************");
		System.out.println("Demonstrating of prototype pattern to clone the object of Manufacturer");
		Manufacturer manufacture = Manufacturer.getInstance().clone();
		manufacture.setManufacturerName("Modena")
		.setManufacturerRegistration(52)
		.setManufactCounts(10);
		
		//Adapter Pattern to adapt manufacture legacy code with  Medicine Interface
		ManufacturerObjectAdapter manufacturerAdapter = new ManufacturerObjectAdapter(medicine, manufacture);
		
		System.out.println(medicine);
        System.out.println("***************************************************************************************");
		System.out.println("Demonstrating of Adapter pattern to adapt manufacture legacy class with Medicine Interface and priting their object");

		System.out.println(manufacturerAdapter);
        System.out.println("***************************************************************************************");

        //Demonstration of facade pattern and decorator pattern to decorate the medicine object
        System.out.println("Demonstration of Facade pattern and adding Decorator pattern to decorate Medicines and adding it to our order list");
        System.out.println("Demonstration of Observer pattern to notify the shipping cost and discount observer of changes as the number of our orders added into order list");

		OrderFacade orderFacade = new OrderFacade(medicine);
		Order order = orderFacade.order();
		
		System.out.println(order);
		order.setDeliveryType(DeliveryType.Delivery);

		medicineBuilder = new MedicineBuilder(2, "Covid Vaccine", 56.66, MedicineCategory.Injection, "Pfizer");
		 medicine = MedicineFactory.getInstance().getObject(medicineBuilder);
		 order.addMedicine(medicine);
		 System.out.println(order);
		 medicineList.add((Medicine)medicine);
		 FileUtil.appendEntryToFile(FILE_NAME, medicineBuilder);
		 
		 medicineBuilder = new MedicineBuilder(3, "Covid Vaccine", 129.99, MedicineCategory.Injection, "Abbott");
		 medicine = MedicineFactory.getInstance().getObject(medicineBuilder);
		 order.addMedicine(medicine);
		 System.out.println(order);
		 medicineList.add((Medicine)medicine);
		 FileUtil.appendEntryToFile(FILE_NAME, medicineBuilder);
		 
		 
		 medicineBuilder = new MedicineBuilder(4, "Covid Vaccine", 101.74, MedicineCategory.Injection, "Bharath Pharmaceuticals");
		 medicine = MedicineFactory.getInstance().getObject(medicineBuilder);
		 order.addMedicine(medicine);
		 System.out.println(order);
		 medicineList.add((Medicine)medicine);
		 FileUtil.appendEntryToFile(FILE_NAME, medicineBuilder);
		 
		 
		 medicineBuilder = new MedicineBuilder(5, "Dolo 650", 2.99, MedicineCategory.Tablet, "Dolo");
		 medicine = MedicineFactory.getInstance().getObject(medicineBuilder);
		 order.addMedicine(medicine);
		 System.out.println(order);
		 medicineList.add((Medicine)medicine);
		 
		
		 medicineBuilder = new MedicineBuilder(6, "HalDol", 13.99, MedicineCategory.Capsules, "Johnson & Johnson");
		 medicine = MedicineFactory.getInstance().getObject(medicineBuilder);
		 order.addMedicine(medicine);
		 System.out.println(order);
		 medicineList.add((Medicine)medicine);
	     System.out.println("***************************************************************************************");
	     
	     //Command Pattern
	     System.out.println("Demonstration of Command pattern to send the request for all Medicines orders and print them");

		

		
		Invoker invoker = new Invoker();
		invoker.placeOrders(medicineList);
		invoker.rentOrders(medicineList);
	     System.out.println("***************************************************************************************");
	     
			MedicineStore medStr = new MedicineStore("MedPlus");
       EmployeeBuilder emplBuilder = new EmployeeBuilder(7,27,"Jack","Daniels",23.96);
       Employee empl = EmployeeFactory.getInstance().getObject(emplBuilder);
		System.out.println("Using Factory and singleton pattern to get only single instance of Employee Builder object");
		System.out.println(empl);
	    System.out.println("***************************************************************************************");
	    
	    //State Pattern
System.out.println("Demonstration of state pattern completed life cycle of order transitioning from ordered to delived state");

       order.state_Awaiting_OrderConfirmation();
       order.state_OrderConfirmed();
       order.state_OrderDelivered();
       order.state_OrderDispatched();
       order.state_OrderDelivered();
       order.state_OrderDelivered();
	    System.out.println("***************************************************************************************");
	    //Strategy Pattern
	    System.out.println("Demonstration of strategy pattern to show differene discounts applied to original price and final price after student and employee discounts ");       
       System.out.println("Medicine before discount: \n"+ medicine);
       double price=0;
       for(DiscountStrategy strategy : MedicineStore.getAlgorithmMap().keySet()){
		   medStr.setUsingStrategy(strategy);
           price = ((Medicine)medicine).runStrategy();
           System.out.println("Medicine price after discount during sale: " + strategy + price);
       }
	}

}
