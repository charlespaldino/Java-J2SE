package Connectors;

public class Connector {

	private boolean value;
	private String name;

	public Connector() {}
	public Connector(String name) {this.name = name;}
	
	public boolean getValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
