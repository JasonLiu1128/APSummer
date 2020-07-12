package LibraryProject;

public class Entertainment {
	private String title;
	private boolean reserve = false;

	public Entertainment(String title) {
		super();
		this.title = title;
	}


	public void setReserve(boolean reserve) {
		this.reserve = reserve;
	}


	public boolean isReserve() {
		return reserve;
	}


	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}


	@Override
	public String toString() {
		return "Entertainment [title=" + title + ", reserve=" + reserve + "]";
	}
	
}
