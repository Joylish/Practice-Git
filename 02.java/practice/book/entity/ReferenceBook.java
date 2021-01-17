package workshop.book.entity;


public class ReferenceBook extends Publication{
	private String field;
	
	public ReferenceBook() {
		super();
	}
	
	public ReferenceBook(String title, String publishingdate, int page, int price, String field) {
		super(title, publishingdate, page, price);
		this.field = field;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

}
