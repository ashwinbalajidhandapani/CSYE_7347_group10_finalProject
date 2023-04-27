package neu.edu.csye7374.State_Pattern;


import neu.edu.csye7374.ObserverPattern.Order;

public class OrderConfirmed implements OrderStateAPI{

	private Order order;
	
	public OrderConfirmed(Order order) {
		super();
		this.order = order;
	}
	
	@Override
	public void state_Awaiting_OrderConfirmation() {
		System.out.println("Error ... Order already CONFIRMED");
	}

	@Override
	public void state_OrderConfirmed() {
		System.out.println("Error ... Order already in CONFIRMED State");	
	}

	@Override
	public void state_OrderDispatched() {
		order.setState(order.getOrderDispatched());
		System.out.println("SUCCESS!! Order DISPATCHED");		
	}

	@Override
	public void state_OrderDelivered() {
		System.out.println("Error ... Order not yet DISPATCHED");
	}

}
