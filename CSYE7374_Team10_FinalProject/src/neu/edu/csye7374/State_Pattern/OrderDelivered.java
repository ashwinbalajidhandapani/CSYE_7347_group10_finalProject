package neu.edu.csye7374.State_Pattern;


import neu.edu.csye7374.ObserverPattern.Order;

public class OrderDelivered implements OrderStateAPI {

	private Order order;
	
	public OrderDelivered(Order order) {
		super();
		this.order = order;
	}
	
	@Override
	public void state_Awaiting_OrderConfirmation() {
		System.out.println("Error ... Order already DELIVERED");
	}

	@Override
	public void state_OrderConfirmed() {
		System.out.println("Error ... Order already DELIVERED");	
	}

	@Override
	public void state_OrderDispatched() {
		System.out.println("Error ... Order already DELIVERED");
	}

	@Override
	public void state_OrderDelivered() {
		System.out.println("Error ... Order already DELIVERED");
	}
}
