package LibraryProject;

public class DVD extends Entertainment {
	public String genre;
	public int year;
	public double price;

	public DVD(String title, boolean reserve, String genre, int year, double price) {
		super(title);
		this.genre = genre;
		this.year = year;
		this.price = price;
	}

	public int getYear() {
		return year;
	}

	public String getGenre() {
		return genre;
	}

	public double getPrice() {
		return price;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "DVD [Title=" + getTitle() + ", genre=" + genre + ", year=" + year + ", price=" + price + ", Reserved=" + isReserve()
				+ "]";
	}

}
