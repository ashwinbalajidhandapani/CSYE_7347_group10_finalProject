package neu.edu.csye7374;

import neu.csye7374.src.Builder.BookBuilder;
import neu.csye7374.src.Strategy_Pattern.DiscountStrategy;

public class Book implements BookAPI{
	
	public int bookId;
	public String bookName;
	public double bookPrice;
	public BookCategory bookCategory;
	public Object bookAuthor;
		
	public Book(BookBuilder builder) {
		super();
		this.bookId = builder.getBookId();
		this.bookName = builder.getBookName();
		this.bookPrice = builder.getBookPrice();
		this.bookCategory = builder.getBookCategory();
		this.bookAuthor=builder.getBookAuthor();
	}
	
	public Object getBookAuthor() {
		return String.class.cast(bookAuthor);
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public BookCategory getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(BookCategory bookCategory) {
		this.bookCategory = bookCategory;
	}

	@Override
	public String bookDescription() {
		// TODO Auto-generated method stub
		return this.bookName + ", of category "+this.bookCategory;
	}
	

	@Override
	public int noOfBooksPublished() {
		// TODO Auto-generated method stub
		return (int) Math.random()*10;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookPrice=" + bookPrice + ", bookCategory="
				+ bookCategory + ", bookAuthor=" + (String) bookAuthor + "]";
	}
	
	public String buyBook() {
		
		return this.bookName+ " is bought";
	}
	
	public String rentBook() {
		this.bookPrice = this.bookPrice * 0.75;
		return this.bookName + " is rented";
	}
	
	public double runStrategy() {
        double value = 0;
        switch(BookStore.usingStrategy){
            case EmployeeDiscount:
                value = BookStore.getAlgorithmMap().get(DiscountStrategy.EmployeeDiscount).discountPrice(this);
                break;
            case StudentDiscount:
                value = BookStore.getAlgorithmMap().get(DiscountStrategy.StudentDiscount).discountPrice(this);
                break;
            default:
                value = bookPrice;
                break;
        }
        return value;
    }

}
