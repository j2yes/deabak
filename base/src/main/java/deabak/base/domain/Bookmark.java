package deabak.base.domain;

public class Bookmark extends Default{
	
	private String bookmarkId;
	private String bookmarkUrl;
	private String bookmarkName;
	private String bookmarkDesc;
	
	public Bookmark() {
		super();
	}

	public String getBookmarkId() {
		return bookmarkId;
	}

	public void setBookmarkId(String bookmarkId) {
		this.bookmarkId = bookmarkId;
	}

	public String getBookmarkUrl() {
		return bookmarkUrl;
	}

	public void setBookmarkUrl(String bookmarkUrl) {
		this.bookmarkUrl = bookmarkUrl;
	}

	public String getBookmarkName() {
		return bookmarkName;
	}

	public void setBookmarkName(String bookmarkName) {
		this.bookmarkName = bookmarkName;
	}

	public String getBookmarkDesc() {
		return bookmarkDesc;
	}

	public void setBookmarkDesc(String bookmarkDesc) {
		this.bookmarkDesc = bookmarkDesc;
	}
	
}
