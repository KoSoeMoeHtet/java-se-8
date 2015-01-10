package application.util;

public enum Marker {
	
	SYSTEM("\u2716"), USER("\u26AA");

	private final String result;
	
	Marker(String result) {
		this.result = result;
	}
	
	public String getResult() {
		return result;
	}
	
	@Override
	public String toString() {
		return getResult();
	}
}
