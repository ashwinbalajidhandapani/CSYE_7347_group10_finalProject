package neu.edu.csye7374.ObserverPattern;


import neu.edu.csye7374.Facade.DeliveryType;

public class QuantityObserver implements OrderObserver {

	public void updated(Order order) {
		if(order.getDeliveryType()== DeliveryType.Delivery) {
			int count=order.getCount();
			double total = order.getCount();
			if(count<=5) {
				order.setShippingCost(10);
			}else  {
				order.setShippingCost(10 + (count-5)*1.5);
			}
		}
	}
		
}
