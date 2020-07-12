package LibraryProject;

import java.util.Date;

public class Magazine extends Entertainment {
	private Date date;
	public Magazine(String title, Date date) {
		super(title);
		this.date = date;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Magazine [Title=" + getTitle() + ", date=" + date + ", Reserved =" + isReserve() + "]";
	}
	

}
