package neu.edu.csye7374.Factory_Pattern;


import neu.edu.csye7374.Builder.BuilderAPI;

public abstract class AbstractFactory<T> {
	public abstract T getObject(BuilderAPI<T> builder);
}
