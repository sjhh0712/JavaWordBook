package application;

public class product {
	private String word;
	private String mean;
	private String date;
	

	
	public product(String word, String mean, String date) {
		super();
		this.word = word;
		this.mean = mean;
		this.date = date;
	}
	
	public String getword() {
		return word;
	}
	
	public void setword() {
		this.word = word;
	}
	
	public String getmean() {
		return mean;
	}
	
	public void setmean() {
		this.mean = mean;
	}
	
	public String getdate() {
		return date;
	}
	
	public void setdate() {
		this.date = date;
	}
}
