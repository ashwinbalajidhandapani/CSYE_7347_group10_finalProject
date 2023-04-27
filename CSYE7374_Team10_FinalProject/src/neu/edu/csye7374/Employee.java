package neu.edu.csye7374;


import neu.edu.csye7374.Builder.EmployeeBuilder;

public class Employee extends Person {
	private int id;

	public Employee(EmployeeBuilder builder) {
		super(builder.getId(),builder.getManufacturerRegistrationId(),builder.getFirstName(), builder.getLastName());
		this.id=builder.getManufacturerRegistrationId();
	}
	
	public int getWage() {
		return id;
	}

	public void setWage(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "\nEmployee ["+ super.toString() +", Id= "+ id +"]";
	}
}
