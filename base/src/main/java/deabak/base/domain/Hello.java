package deabak.base.domain;

public class Hello extends Default{
	
	private String korean;
	private String english;
	
	public Hello() {
		super();
	}
	
	public Hello(String korean, String english) {
		super();
		this.korean = korean;
		this.english = english;
	}
	
	public String getKorean() {
		return korean;
	}
	public void setKorean(String korean) {
		this.korean = korean;
	}
	public String getEnglish() {
		return english;
	}
	public void setEnglish(String english) {
		this.english = english;
	}
	
}
