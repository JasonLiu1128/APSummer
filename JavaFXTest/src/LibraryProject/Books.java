package LibraryProject;

public class Books extends Entertainment{
	private String bookISBNs;
	private String fullNames;
	private String price;
	
	public Books(String titles, String bookISBNs, String fullNames, String price) {
		super(titles);
		this.bookISBNs = bookISBNs;
		this.fullNames = fullNames;
		this.price = price;
	}
	public void setBookISBNs(String bookISBNs) {
		this.bookISBNs = bookISBNs;
	}
	public void setFullNames(String fullNames) {
		this.fullNames = fullNames;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getBookISBNs() {
		return bookISBNs;
	}
	public String getFullNames() {
		return fullNames;
	}
	public String getPrice() {
		return price;
	}
	@Override
	public String toString() {
		return "Books [Title=" + getTitle() + ", bookISBNs=" + bookISBNs + ", fullNames=" + fullNames + ", price=" + price + ", Reserved="
				+ isReserve() + "]";
	}
	
}
