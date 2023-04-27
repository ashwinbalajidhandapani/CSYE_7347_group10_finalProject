package neu.edu.csye7374.Factory_Pattern;


import neu.edu.csye7374.Builder.BuilderAPI;
import neu.edu.csye7374.Builder.EmployeeBuilder;
import neu.edu.csye7374.Employee;

public class EmployeeFactory extends AbstractFactory<Employee> {
	
	private static EmployeeFactory instance;  // Lazy Singleton Factory Class
	
	private  EmployeeFactory() {
		super();
		instance=null;
	}
	
	public static synchronized EmployeeFactory getInstance() {
		if (instance == null) {
			instance = new EmployeeFactory();
		}
		return instance;
	}

	@Override
	public Employee getObject(BuilderAPI<Employee> builder) {
		// TODO Auto-generated method stub
		EmployeeBuilder employeeBuilder=(EmployeeBuilder)builder;
		return new Employee(employeeBuilder);
	}

}
