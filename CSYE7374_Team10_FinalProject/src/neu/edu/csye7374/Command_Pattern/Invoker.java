package neu.edu.csye7374.Command_Pattern;


import neu.edu.csye7374.Medicine;

import java.util.ArrayList;
import java.util.List;

public class Invoker {
	private List<Medicine> orderList = new ArrayList<>();

	public void takeOrder(Medicine order){
		orderList.add(order);		
	}

   public void placeOrders(){
	   BuyMedicineCommand buyMedicineCommand = BuyMedicineCommand.getInstance();
      for (Medicine order : orderList) {
    	  System.out.println(buyMedicineCommand.setMedicine(order)
         .execute());
      }
      orderList.clear();
   }
   
   public void placeOrders(List<Medicine> medicineList){
	      for (Medicine b : medicineList) {
	    	  orderList.add(b);
	      }
	      placeOrders();
   }
   
   
   public void rentOrders(){
	   RentEquipmentCommand rentMedicineCommand = RentEquipmentCommand.getInstance();
      for (Medicine order : orderList) {
    	  System.out.println(rentMedicineCommand.setMedicine(order)
         .execute());
      }
      orderList.clear();
   }
   
   public void rentOrders(List<Medicine> medicineList){
	      for (Medicine b : medicineList) {
	    	  orderList.add(b);
	      }
	      rentOrders();
   }
   
   
   
   

	public List<Medicine> getOrderList() {
		return orderList;
	}
	
	public void setOrderList(List<Medicine> orderList) {
		this.orderList = orderList;
	}
   
   
   
   
   
   
   
}


//public class CommandPatternDemo {
//	   public static void main(String[] args) {
//	      Stock abcStock = new Stock();
//
//	      BuyStock buyStockOrder = new BuyStock(abcStock);
//	      SellStock sellStockOrder = new SellStock(abcStock);
//
//	      Broker broker = new Broker();
//	      broker.takeOrder(buyStockOrder);
//	      broker.takeOrder(sellStockOrder);
//
//	      broker.placeOrders();
//	   }
//	}
