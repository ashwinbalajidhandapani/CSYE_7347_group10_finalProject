package neu.edu.csye7374.State_Pattern;

public interface OrderStateAPI {
	void state_Awaiting_OrderConfirmation();
	void state_OrderConfirmed();
	void state_OrderDispatched();
	void state_OrderDelivered();
}
