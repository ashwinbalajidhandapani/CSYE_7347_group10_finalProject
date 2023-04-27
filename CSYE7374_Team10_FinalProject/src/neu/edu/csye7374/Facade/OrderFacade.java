package neu.edu.csye7374.Facade;

import neu.edu.csye7374.Decorator_Pattern.GiftDecorator;
import neu.edu.csye7374.Decorator_Pattern.MedicineDecorator;
import neu.edu.csye7374.MedicineAPI;
import neu.edu.csye7374.ObserverPattern.Order;

public class OrderFacade {
	private MedicineAPI medicine;

	public OrderFacade() {
		super();
	}
	
	public OrderFacade(MedicineAPI medicine) {
		super();
		this.medicine = medicine;
	}
	
	public Order order() {
		Order order = new Order();
		MedicineDecorator giftdecMed = new GiftDecorator(medicine);
		System.out.println(giftdecMed);
		order.addMedicine(giftdecMed);
		return order;
	}
	
	public OrderFacade setMedicine(MedicineAPI medicine) {
		this.medicine = medicine;
		return this;
	}	
}
