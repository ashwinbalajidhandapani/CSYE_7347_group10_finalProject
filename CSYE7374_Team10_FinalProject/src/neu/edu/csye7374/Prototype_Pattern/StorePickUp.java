package neu.edu.csye7374.Prototype_Pattern;

public class StorePickUp extends DeliveryType {

	public StorePickUp(int deliveryId, String deliveryType, double deliveryCost) {
		super(deliveryId, deliveryType, deliveryCost);
		// TODO Auto-generated constructor stub
	}

	@Override
	String deliveryDescription() {
		// TODO Auto-generated method stub
		return "You need to pickup your oder from the Store";
	}

}
