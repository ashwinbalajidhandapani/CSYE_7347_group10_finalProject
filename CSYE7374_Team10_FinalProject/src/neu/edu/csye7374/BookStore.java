package neu.edu.csye7374;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import neu.csye7374.src.Adapter_Pattern.Author;
import neu.csye7374.src.Adapter_Pattern.AuthorObjectAdapter;
import neu.csye7374.src.Builder.BookBuilder;
import neu.csye7374.src.Builder.EmployeeBuilder;
import neu.csye7374.src.Command_Pattern.Invoker;
import neu.csye7374.src.Facade.DeliveryType;
import neu.csye7374.src.Facade.OrderFacade;
import neu.csye7374.src.Factory_Pattern.BookFactory;
import neu.csye7374.src.Factory_Pattern.EmployeeFactory;
import neu.csye7374.src.ObserverPattern.Order;
import neu.csye7374.src.State_Pattern.*;
import neu.csye7374.src.Strategy_Pattern.*;
public class BookStore implements BookStoreStateAPI {
	
    private String name;
    private List<Book> itemList = new ArrayList<>();
    private List<Person> personList = new ArrayList<>();
    public static DiscountStrategy usingStrategy = DiscountStrategy.NONE;
    private static final String FILE_NAME = "edu/neu/csye7374/src/inputData/BookDetails.txt";
	
	private BookStoreStateAPI openState = new OpenState(this);
	private BookStoreStateAPI stockState = new StockState(this);
	private BookStoreStateAPI closeState = new CloseState(this);
	private BookStoreStateAPI state;
	
	
    private static Map<DiscountStrategy,DiscountStrategyAPI> algorithmMap = new HashMap<>();
    {
//    	algorithmMap.put(DiscountStrategy.NONE, null);
        algorithmMap.put(DiscountStrategy.StudentDiscount, new StudentDiscount());
        algorithmMap.put(DiscountStrategy.EmployeeDiscount, new EmployeeDiscount());
    }
	
	public BookStore(String name) {
		super();
		this.name = name;
		this.state = getOpenState();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getItemList() {
		return itemList;
	}

	public void setItemList(List<Book> itemList) {
		this.itemList = itemList;
	}

	public List<Person> getPersonList() {
		return personList;
	}

	public void setPersonList(List<Person> personList) {
		this.personList = personList;
	}

	public static DiscountStrategy getUsingStrategy() {
		return usingStrategy;
	}

	public static void setUsingStrategy(DiscountStrategy usingStrategy) {
		BookStore.usingStrategy = usingStrategy;
	}

	public static Map<DiscountStrategy, DiscountStrategyAPI> getAlgorithmMap() {
		return algorithmMap;
	}

	public static void setAlgorithmMap(Map<DiscountStrategy, DiscountStrategyAPI> algorithmMap) {
		BookStore.algorithmMap = algorithmMap;
	}

	public BookStoreStateAPI getState() {
		return state;
	}

	public void setState(BookStoreStateAPI state) {
		this.state = state;
	}

	public BookStoreStateAPI getOpenState() {
		return openState;
	}

	public void setOpenState(BookStoreStateAPI openState) {
		this.openState = openState;
	}

	public BookStoreStateAPI getStockState() {
		return stockState;
	}

	public void setStockState(BookStoreStateAPI stockState) {
		this.stockState = stockState;
	}

	public BookStoreStateAPI getCloseState() {
		return closeState;
	}

	public void setCloseState(BookStoreStateAPI closeState) {
		this.closeState = closeState;
	}

	@Override
	public void state_Open() {
		// TODO Auto-generated method stub
		this.state.state_Open();
		
	}

	@Override
	public void state_Close() {
		// TODO Auto-generated method stub
		this.state.state_Close();
	}

	@Override
	public void state_Stock() {
		// TODO Auto-generated method stub
		this.state.state_Stock();
	}
	
	public static void demo() {
		
		
		
		FileUtil.getFileData(FILE_NAME);
		
		
		
		List<Book> bookList = new ArrayList<>();
		
		//Builder Pattern and getting object of Builder using Factory and Singleton Pattern
		System.out.println("***************************************************************************************");
		System.out.println("Demonstrating of Builder pattern. Delegating the responsibilty of creating Books objects to Book Builder which implements build method and builds book object for us");
		System.out.println("Using Factory and singleton pattern to get only single instance of Book Builder object");
		BookBuilder bookBuilder = new BookBuilder(1, "Harry Potter", 10, BookCategory.Fiction, "JK Rowling");
		BookAPI book = BookFactory.getInstance().getObject(bookBuilder);
		bookList.add((Book)book);
		System.out.println(book);
		FileUtil.appendEntryToFile(FILE_NAME, bookBuilder);
		
		//Prototype Pattern to clone the object of author
        System.out.println("***************************************************************************************");
		System.out.println("Demonstrating of prototype pattern to clone the object of Author");
		Author author = Author.getInstance().clone();
		author.setAuthorName("JK Rowling")
		.setAge(52)
		.setNoOfBooksPublished(10);
		
		//Adapter Pattern to adapt author legacy code with  Book Interface
		AuthorObjectAdapter authorAdapter = new AuthorObjectAdapter(book, author);
		
		System.out.println(book);
        System.out.println("***************************************************************************************");
		System.out.println("Demonstrating of Adapter pattern to adapt author legacy class with Book Interface and priting their object");

		System.out.println(authorAdapter);
        System.out.println("***************************************************************************************");

        //Demonstration of facade pattern and decorator pattern to decorate the book object
        System.out.println("Demonstration of Facade pattern and adding Decorator pattern to decorate books and adding it to our order list");
        System.out.println("Demonstration of Observer pattern to notify the shipping cost and discount observer of changes as the number of our orders added into order list");

		OrderFacade orderFacade = new OrderFacade(book);
		Order order = orderFacade.order();
		
		System.out.println(order);
		order.setDeliveryType(DeliveryType.Delivery);

		bookBuilder = new BookBuilder(2, "Yogi Autobiography", 100, BookCategory.Documentary, "Swami Dayananad");
		 book = BookFactory.getInstance().getObject(bookBuilder);
		 order.addBook(book);
		 System.out.println(order);
		 bookList.add((Book)book);
		 FileUtil.appendEntryToFile(FILE_NAME, bookBuilder);
		 
		 bookBuilder = new BookBuilder(3, "Alice in Wonderland", 150, BookCategory.Fiction, "Scott Ross");
		 book = BookFactory.getInstance().getObject(bookBuilder);
		 order.addBook(book);
		 System.out.println(order);
		 bookList.add((Book)book);
		 FileUtil.appendEntryToFile(FILE_NAME, bookBuilder);
		 
		 
		 bookBuilder = new BookBuilder(4, "Last Bout", 101, BookCategory.Documentary, "Mc Gregor");
		 book = BookFactory.getInstance().getObject(bookBuilder);
		 order.addBook(book);
		 System.out.println(order);
		 bookList.add((Book)book);
		 FileUtil.appendEntryToFile(FILE_NAME, bookBuilder);
		 
		 
		 bookBuilder = new BookBuilder(5, "Teresstial Lives", 200, BookCategory.Scifi, "Phil Hughes");
		 book = BookFactory.getInstance().getObject(bookBuilder);
		 order.addBook(book);
		 System.out.println(order);
		 bookList.add((Book)book);
		 
		
		 bookBuilder = new BookBuilder(6, "Playing my way", 310, BookCategory.Documentary, "Sachin Tendulkar");
		 book = BookFactory.getInstance().getObject(bookBuilder);
		 order.addBook(book);
		 System.out.println(order);
		 bookList.add((Book)book);
	     System.out.println("***************************************************************************************");
	     
	     //Command Pattern
	     System.out.println("Demonstration of Command pattern to send the request for all books orders and print them");

		

		
		Invoker invoker = new Invoker();
		invoker.placeOrders(bookList);
		invoker.rentOrders(bookList);
	     System.out.println("***************************************************************************************");
	     
			BookStore bookStr = new BookStore("Kindle");
       EmployeeBuilder emplBuilder = new EmployeeBuilder(7,27,"Daniel","Peters",18.5);
       Employee empl = EmployeeFactory.getInstance().getObject(emplBuilder);
		System.out.println("Using Factory and singleton pattern to get only single instance of Employee Builder object");
		System.out.println(empl);
	    System.out.println("***************************************************************************************");
	    
	    //State Pattern
System.out.println("Demonstration of state pattern completed life cycle of order transitioning from ordered to delived state");

       order.state_Awaiting_OrderConfirmation();
       order.state_OrderConfirmed();
       order.state_OrderDelivered();
       order.state_OrderDispatched();
       order.state_OrderDelivered();
       order.state_OrderDelivered();
	    System.out.println("***************************************************************************************");
	    //Strategy Pattern
	    System.out.println("Demonstration of strategy pattern to show differene discounts applied to original price and final price after student and employee discounts ");       
       System.out.println("Book before discount: \n"+ book);
       double price=0;
       for(DiscountStrategy strategy : BookStore.getAlgorithmMap().keySet()){
       	bookStr.setUsingStrategy(strategy);
           price = ((Book)book).runStrategy();
           System.out.println("Book price after discount during sale: " + strategy + price);
       }
	}

}
