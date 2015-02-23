package deabak.base.domain;

public class Default {
	
	private String id;
	//기본값 설정 1페이지, 10개 목록
	private int page=1;
	private int limit=10;
	private int start;
	private int totalCount;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getStart() {
		this.start = limit*(page-1);
		return start;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

}
